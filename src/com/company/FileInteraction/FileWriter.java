package com.company.FileInteraction;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    private String filePath;
    private Path path;

    public FileWriter() {
        this.filePath = "C:\\Users\\Andrei\\IdeaProjects\\HomeWork1.2\\src\\com\\company\\FileInteraction\\data.txt";
        this.path = Paths.get(filePath);
    }

    public void writeNewLine(String content){
        content = content + '\n';
        try {
            Files.write(this.path,content.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
