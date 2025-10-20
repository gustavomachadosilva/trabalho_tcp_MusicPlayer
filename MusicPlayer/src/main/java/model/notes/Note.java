package model.notes;

public class Note {

    private int octave;
    private float duration;
    private int midiCode;

    public Note(Notes note, int octave, float duration) {
        this.octave = octave;
        this.duration = duration;

        this.midiCode = defineMidiCode(note, octave);
    }

    public int getOctave() {
        return octave;
    }

    public float getDuration() {
        return duration;
    }

    public int getMidiCode() {
        return midiCode;
    }

    private int defineMidiCode(Notes note, int octave) {
        int base = (octave - Notes.BASE_OCTAVE) * 12;
        return note.getMidiCode() + base;
    }

}
