package model;

import model.instruments.Instrument;
import model.instruments.Instruments;
import model.notes.Note;
import model.notes.Notes;

public class MusicalContext {

    private Note note;
    private Instrument instrument;
    private Volume volume;
    private BPM bpm;

    public MusicalContext(Note note, Instrument instrument, Volume volume, BPM bpm) {
        this.note = note;
        this.instrument = instrument;
        this.volume = volume;
        this.bpm = bpm;
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

    public BPM getBpm() {
        return bpm;
    }
}
