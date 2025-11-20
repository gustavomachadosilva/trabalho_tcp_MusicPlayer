package com.tcp.musicPlayer.model;

import com.tcp.musicPlayer.model.register.LogRegister;
import com.tcp.musicPlayer.model.register.MusicalRegister;
import org.springframework.core.io.InputStreamResource;

import javax.sound.midi.Sequence;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ResponseBody {

    private int numNotes;
    private int numPauses;
    private int duration;
    private List<MusicalRegister> logRegister;
    private byte[] midi;

    public ResponseBody(MusicGenerator musicGenerator) {
        defineResponseBody(musicGenerator);
    }

    private void defineResponseBody(MusicGenerator musicGenerator) {
        this.numNotes = musicGenerator.getLogRegister().getNumNotes();
        this.numPauses = musicGenerator.getLogRegister().getNumPauses();
        this.duration = musicGenerator.getLogRegister().getDuration();
        this.logRegister = musicGenerator.getLogRegister().getLogMusicalRegister();
        this.midi = musicGenerator.getMidiFile().generate();
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

    public byte[] getMidi() {
        return midi;
    }
}
