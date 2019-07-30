package com.company.FileInteraction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    private String filePath;
    private Path path;

    public FileReader() {
        this.filePath = "C:\\Users\\Andrei\\IdeaProjects\\HomeWork1.2\\src\\com\\company\\FileInteraction\\data.txt";
        this.path = Paths.get(filePath);
    }

    public Stream<String> readFile(){
        try (Stream<String> stream = Files.lines(this.path)) {
            return stream;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
