package com.company;

import com.company.FileInteraction.FileReader;
import com.company.FileInteraction.FileWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Server {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private int maxConnections;
    private List<String> info;
    private HashMap<String, String> users;

    public Server() {
        users = new HashMap<>();
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.readFile();
        this.maxConnections = loadMaxConnections();
        this.loadUsersAndPasswords();
    }

    public void readFile() {
        this.info = this.fileReader.readFile();
    }

    private int loadMaxConnections() {
        Optional<String> str = this.info.stream()
                .filter(e -> e.startsWith("max"))
                .map(e -> e.replaceAll("\\s+", ""))
                .findFirst();
        String s[] = str.get().split("=");
        int max = Integer.parseInt(s[1]);
        return max;
    }

    private void loadUsersAndPasswords() {
        List<String> bla = this.info.stream()
                .filter(e -> !e.startsWith("max"))
                .map(e -> {
                    String temp[] = e.split(" ");
                    this.users.put(temp[0].trim(), temp[1].trim());
                    return e;
                })
                .collect(Collectors.toList());
    }




}
