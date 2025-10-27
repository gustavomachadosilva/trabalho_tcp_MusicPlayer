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
    private boolean isPaused;
    private boolean isLastActionNote;

    public MusicalContext(Note note, Instrument instrument, Volume volume, BPM bpm) {
        this.note = note;
        this.instrument = instrument;
        this.volume = volume;
        this.bpm = bpm;
        this.isPaused = false;
        this.isLastActionNote = false;
    }

    public Note getNote() {
        return note;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Volume getVolume() {
        Volume silence = new Volume(0, this.volume.getMaxVolume());
        if(isPaused)
            return silence;
        else
            return this.volume;
    }

    public BPM getBpm() {
        return bpm;
    }

    public void setPauseStatus(boolean newStatus){
        isPaused = newStatus;
    }

    public void setStatusLastAction(boolean isLastActionNote){
        this.isLastActionNote = isLastActionNote;
    }

    public boolean getStatusLastAction(){
        return isLastActionNote;
    }
}
