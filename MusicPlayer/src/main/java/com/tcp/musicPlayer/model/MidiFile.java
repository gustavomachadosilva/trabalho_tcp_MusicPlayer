package com.tcp.musicPlayer.model;

import javax.sound.midi.*;
import java.io.File;

public class MidiFile {

    private Sequence sequence;
    private Track track;
    private MusicalContext musicalContext;
    private int duration;
    private int currentTick = 0;
    private String fileName;

    public MidiFile(MusicalContext musicalContext, String fileName) {
        this.musicalContext = musicalContext;
        this.fileName = fileName;

        try {
            this.sequence = new Sequence(Sequence.PPQ, 480);
            this.track = sequence.createTrack();

            this.changeInstrument();
            this.setBPM();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Sequence getSequence() {
        return sequence;
    }

    public void changeInstrument() {
        int midiCodeInstrument = this.musicalContext.getInstrument().getMidiCode();

        try {
            ShortMessage change = new ShortMessage();
            change.setMessage(ShortMessage.PROGRAM_CHANGE, 0, midiCodeInstrument, 0);
            this.track.add(new MidiEvent(change, this.currentTick));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setBPM() {
        try {
            int microsecondsPerQuarter = 60000000 / this.musicalContext.getBpm().getValue();
            MetaMessage timeMessage = new MetaMessage();

            // Event type 0x51 (set time)
            byte[] data = {
                    (byte) ((microsecondsPerQuarter >> 16) & 0xFF),
                    (byte) ((microsecondsPerQuarter >> 8) & 0xFF),
                    (byte) (microsecondsPerQuarter & 0xFF)
            };

            timeMessage.setMessage(0x51, data, 3);

            this.track.add(new MidiEvent(timeMessage, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNote() {
        try {
            int midiCode = this.musicalContext.getNote().getMidiCode();
            int noteDuration = this.musicalContext.getNote().getDuration();
            int velocity = 100;
            int ticksDuration = 480 * noteDuration / 500;

            // Note ON
            ShortMessage on = new ShortMessage();
            on.setMessage(ShortMessage.NOTE_ON, 0, midiCode, 0);
            track.add(new MidiEvent(on, currentTick));

            // Note OFF
            ShortMessage off = new ShortMessage();
            off.setMessage(ShortMessage.NOTE_OFF, 0 ,midiCode, 0);
            track.add(new MidiEvent(off, currentTick + ticksDuration));

            currentTick += ticksDuration;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            File file = new File(fileName);
            MidiSystem.write(this.sequence, 1, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
