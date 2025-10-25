package model.inputHandlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private Path filePath;

    public FileReader(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public String getFileContent() {
        String content = "";

        try {
            content = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }
}
