package com.company.FileInteraction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private String filePath;
    private Path path;

    public FileReader() {
        this.filePath = "C:\\Users\\Andrei\\IdeaProjects\\HomeWork1.2\\src\\com\\company\\FileInteraction\\data.txt";
        this.path = Paths.get(filePath);
    }

    public List<String> readFile(){
        List<String> list;
        try (Stream<String> stream = Files.lines(this.path)) {
            list = stream.collect(Collectors.toList());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
