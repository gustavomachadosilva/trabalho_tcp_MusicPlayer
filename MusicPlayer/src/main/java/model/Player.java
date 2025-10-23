package model;

import model.instruments.Instrument;
import model.notes.Note;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Player {

    private MusicalContext musicalContext;
    private Synthesizer synthesizer;
    private MidiChannel midiChannel;

    public Player(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
        setUpPlayer(musicalContext);
    }

    public MusicalContext getMusicalContext() {
        return musicalContext;
    }

    public void setMusicalContext(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
    }

    private void setUpPlayer(MusicalContext musicalContext) {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            midiChannel = synthesizer.getChannels()[0];
            midiChannel.programChange(musicalContext.getInstrument().getMidiCode());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        Note note = this.musicalContext.getNote();
        Volume volume = this.musicalContext.getVolume();

        midiChannel.noteOn(note.getMidiCode(), volume.getCurrentVolume());

        try {
            Thread.sleep((long) note.getDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        midiChannel.noteOff(note.getMidiCode());
    }

    public void close() {
        if (this.synthesizer != null && this.synthesizer.isOpen()) {
            this.synthesizer.close();
        }
    }
}
