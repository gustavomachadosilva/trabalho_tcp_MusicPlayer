package com.tcp.musicPlayer.model.inputHandlers;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private MultipartFile file;

    public FileReader(MultipartFile file) {
        this.file = file;
    }

    public String getFileContent() throws Exception {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)
        )) {
           String line;
           while ((line = reader.readLine()) != null) {
               content.append(line).append("\n");
           }
        } catch (Exception e) {
            throw new Exception("Error reading file");
        }

        return content.toString();
    }
}
