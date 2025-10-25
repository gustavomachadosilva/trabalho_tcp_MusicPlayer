package model;

import model.instruments.Instrument;
import model.notes.Note;

import javax.sound.midi.*;

public class Player {

    private MidiFile midiFile;
    private Sequencer sequencer;

    public Player(MidiFile midiFile) {
        this.midiFile = midiFile;
    }

    public void play() {
        try {
            this.sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(midiFile.getSequence());
            sequencer.start();
            System.out.println("Playing...");

            while (sequencer.isRunning()) {
                Thread.sleep(100);
            }

            sequencer.stop();
            sequencer.close();
            System.out.println("Player end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
