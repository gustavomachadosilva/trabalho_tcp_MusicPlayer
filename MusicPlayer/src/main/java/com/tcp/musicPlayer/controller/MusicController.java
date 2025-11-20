<<<<<<< Updated upstream
=======
package com.tcp.musicPlayer.controller;

import com.tcp.musicPlayer.model.MusicGenerator;
import com.tcp.musicPlayer.model.RequestMusic;
import com.tcp.musicPlayer.model.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MusicController {

    @PostMapping("/audio")
    public ResponseEntity<ResponseBody> getGeneratedAudio(@RequestBody RequestMusic requestMusic) throws FileNotFoundException {
        MusicGenerator musicGenerator = new MusicGenerator(requestMusic);
        musicGenerator.generateMusic();
        System.out.println("rodando");

        ResponseBody responseBody = new ResponseBody(musicGenerator);

        return ResponseEntity.ok().body(responseBody);
    }

}
>>>>>>> Stashed changes
