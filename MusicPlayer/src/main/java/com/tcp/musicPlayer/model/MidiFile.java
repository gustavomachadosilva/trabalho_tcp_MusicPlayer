package com.tcp.musicPlayer.model;

import javax.sound.midi.*;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class MidiFile {

    private Sequence sequence;
    private Track track;
    private MusicalContext musicalContext;
    private int duration;
    private int currentTick = 0;
    private String fileName;
    private File midi;
    private File mp3;

    public File getMidi() {
        return midi;
    }

    public File getMp3() {
        return mp3;
    }

    public MidiFile(MusicalContext musicalContext, String fileName) {
        this.musicalContext = musicalContext;
        this.fileName = fileName;

        try {
            this.sequence = new Sequence(Sequence.PPQ, 480);
            this.track = sequence.createTrack();

            this.changeInstrument();
            this.setBPM();
            this.configVolume();
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

            // BANK SELECT MSB
            ShortMessage bankMsb = new ShortMessage();
            bankMsb.setMessage(ShortMessage.CONTROL_CHANGE, 0, 0, 0);
            track.add(new MidiEvent(bankMsb, currentTick));

            // BANK SELECT LSB
            ShortMessage bankLsb = new ShortMessage();
            bankLsb.setMessage(ShortMessage.CONTROL_CHANGE, 0, 32, 0);
            track.add(new MidiEvent(bankLsb, currentTick));

            ShortMessage change = new ShortMessage();
            change.setMessage(ShortMessage.PROGRAM_CHANGE, 0, midiCodeInstrument, 0);
            this.track.add(new MidiEvent(change, this.currentTick));
        } catch (Exception e) {
            e.printStackTrace();
        }

        currentTick += 10;

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

            this.track.add(new MidiEvent(timeMessage, currentTick));

            currentTick += 5;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addNote() {
        try {
            int midiCode = this.musicalContext.getNote().getMidiCode();
            int noteDuration = this.musicalContext.getNote().getDuration();
            int velocity = 100;
            int ticksDuration = 480 * noteDuration / 500;

            // Note ON
            ShortMessage on = new ShortMessage();
            on.setMessage(ShortMessage.NOTE_ON, 0, midiCode, velocity);
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

    private void configVolume() {
        try {
            ShortMessage vol = new ShortMessage();
            vol.setMessage(ShortMessage.CONTROL_CHANGE, 0 ,7, musicalContext.getVolume().getCurrentVolume());
            this.track.add(new MidiEvent(vol, currentTick));
            currentTick += 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerMusicalEvent() {
        this.changeInstrument();
        this.setBPM();
        this.configVolume();
        this.addNote();
    }

    public void generate() {
        try {
            midi = new File(this.fileName + ".mid");
            mp3 = new File(this.fileName + "aaa.mp3");

            MidiSystem.write(this.sequence, 1, midi);
//            System.out.println("Arquivo MIDI salvo em: " + midi.getAbsolutePath());

            MidiToMp3Converter.convertMidiToMp3(midi, mp3);
//            System.out.println("Arquivo MP3 salvo em: " + mp3.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
