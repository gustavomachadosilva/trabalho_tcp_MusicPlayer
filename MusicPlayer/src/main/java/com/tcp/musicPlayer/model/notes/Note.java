package model.notes;

public class Note {

    public static final int MAX_OCTAVE = 8;
    public static final int MIN_OCTAVE = 1;

    private int octave;
    private int duration;
    private int midiCode;

    public Note(Notes note, int octave, int duration) {
        this.octave = octave;
        this.duration = duration;

        this.midiCode = defineMidiCode(note, octave);
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public int getDuration() {
        return duration;
    }

    public int getMidiCode() {
        return midiCode;
    }

    public void updateNote(Notes newNote){
        this.midiCode = defineMidiCode(newNote, this.octave);
    }

    private int defineMidiCode(Notes note, int octave) {
        int base = (octave - Notes.BASE_OCTAVE) * 12;
        return note.getMidiCode() + base;
    }

}
