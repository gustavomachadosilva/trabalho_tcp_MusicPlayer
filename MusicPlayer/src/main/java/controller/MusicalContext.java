package controller;

import controller.instruments.Instrument;
import controller.notes.Note;

public class MusicalContext {

    private Note note;
    private Instrument instrument;
    private Volume volume;

    public MusicalContext(int nota, int instrumento, int volume, int maxVolume, int oitava) {
        this.note = new Note();
        this.instrument = new Instrument();
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
