package com.tcp.musicPlayer.model;

import com.tcp.musicPlayer.model.register.LogRegister;
import com.tcp.musicPlayer.model.register.MusicalRegister;
import org.springframework.core.io.InputStreamResource;

import javax.sound.midi.Sequence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

public class ResponseBody {

    private int numNotes;
    private int numPauses;
    private int duration;
    private List<MusicalRegister> logRegister;
    private String midiFile;
    private String mp3File;

    public ResponseBody(MusicGenerator musicGenerator) throws IOException {
        defineResponseBody(musicGenerator);
    }

    private void defineResponseBody(MusicGenerator musicGenerator) throws IOException {
        this.numNotes = musicGenerator.getLogRegister().getNumNotes();
        this.numPauses = musicGenerator.getLogRegister().getNumPauses();
        this.duration = musicGenerator.getLogRegister().getDuration();
        this.logRegister = musicGenerator.getLogRegister().getLogMusicalRegister();

        musicGenerator.getMidiFile().generate();

        this.midiFile = fileToBase64(musicGenerator.getMidiFile().getMidi());
        this.mp3File = fileToBase64(musicGenerator.getMidiFile().getMp3());
    }

    public int getNumNotes() {
        return numNotes;
    }

    public int getNumPauses() {
        return numPauses;
    }

    public int getDuration() {
        return duration;
    }

    public List<MusicalRegister> getLogRegister() {
        return logRegister;
    }

    public String getMidiFile() {
        return midiFile;
    }

    public String getMp3File() {
        return mp3File;
    }

    private String fileToBase64(File file) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(file.getAbsolutePath()));

        return Base64.getEncoder().encodeToString(bytes);
    }

}
