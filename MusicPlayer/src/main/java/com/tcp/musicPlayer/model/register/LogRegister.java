package com.tcp.musicPlayer.model.register;

import com.tcp.musicPlayer.model.MusicalContext;

import java.util.ArrayList;
import java.util.List;

public class LogRegister {

    private MusicalContext musicalContext;
    private List<MusicalRegister> logMusicalRegister;
    private int numNotes;
    private int numPauses;
    private int duration;

    public LogRegister(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
        this.logMusicalRegister = new ArrayList<>();
        this.numNotes = 0;
        this.numPauses = 0;
        this.duration = 0;
    }

    public void addRegister() {
        MusicalRegister musicalRegister = new MusicalRegister();
        defineMusicalRegister(musicalRegister);

        defineSummary();

        logMusicalRegister.add(musicalRegister);
    }

    private void defineMusicalRegister(MusicalRegister musicalRegister) {
        musicalRegister.setInstrument(musicalContext.getInstrument().getName());
        musicalRegister.setNote(musicalContext.getNote().getName());
        musicalRegister.setOctave(musicalContext.getNote().getOctave());
    }

    private void defineSummary() {

        if (musicalContext.isPaused()) {
            this.numPauses += 1;
        } else {
            this.numNotes += 1;
        }

        this.duration += musicalContext.getNote().getDuration();
    }

    public List<MusicalRegister> getLogMusicalRegister() {
        return logMusicalRegister;
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
}
