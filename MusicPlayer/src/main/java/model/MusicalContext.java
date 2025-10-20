package model;

import model.instruments.Instrument;
import model.instruments.Instruments;
import model.notes.Note;
import model.notes.Notes;

public class MusicalContext {

    private Note note;
    private Instrument instrument;
    private Volume volume;

    public MusicalContext(Notes note, Instruments instrument, int volume, int maxVolume, int octave, int duration) {
        this.note = new Note(note, octave, duration);
        this.instrument = new Instrument(instrument);
        this.volume = new Volume(volume, maxVolume);
    }

    public Note getNote() {
        return note;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Volume getVolume() {
        return volume;
    }

}
