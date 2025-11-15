package com.tcp.musicPlayer.controller;

import com.tcp.musicPlayer.model.MusicGenerator;
import com.tcp.musicPlayer.model.RequestMusic;
import com.tcp.musicPlayer.model.ResponseBody;
import com.tcp.musicPlayer.model.inputHandlers.FileReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/audio")
    public ResponseEntity<ResponseBody> getGeneratedAudio(@RequestBody RequestMusic requestMusic) throws FileNotFoundException {
        MusicGenerator musicGenerator = new MusicGenerator(requestMusic);
        musicGenerator.generateMusic();

        ResponseBody responseBody = new ResponseBody(musicGenerator);

        return ResponseEntity.ok().body(responseBody);
    }

}
