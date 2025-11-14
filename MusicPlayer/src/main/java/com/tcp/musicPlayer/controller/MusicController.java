package com.tcp.musicPlayer.controller;

import com.tcp.musicPlayer.model.MusicGenerator;
import com.tcp.musicPlayer.model.RequestMusic;
import com.tcp.musicPlayer.model.inputHandlers.FileReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
public class MusicController {

    @PostMapping("/txt")
    public ResponseEntity<String> extractString(@RequestParam("file") MultipartFile file) {
        FileReader fileReader = new FileReader(file);
        String content = "";

        try {
            content = fileReader.getFileContent();
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error processing file");
        }
    }

    @GetMapping("/audio")
    public ResponseEntity<InputStreamResource> getGeneratedAudio(@RequestBody RequestMusic requestMusic) throws FileNotFoundException {
        MusicGenerator musicGenerator = new MusicGenerator(requestMusic);

        File music = musicGenerator.getMidiFile().generate();

        InputStreamResource resource = new InputStreamResource(new FileInputStream(music));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + musicGenerator.getFileName())
                .contentType(MediaType.parseMediaType("audio/midi"))
                .contentLength(music.length())
                .body(resource);
    }

}
