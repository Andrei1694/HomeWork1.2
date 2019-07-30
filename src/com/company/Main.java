package com.company;

import com.company.FileInteraction.FileReader;
import com.company.FileInteraction.FileWriter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> list = fileReader.readFile();
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeNewLine(" *");
        list.forEach(System.out::println);
    }
}
