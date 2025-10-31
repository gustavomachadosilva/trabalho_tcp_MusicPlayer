package model.actions;

import model.MusicalContext;
import model.notes.Note;

public class LowerOctaveAction extends Action {

    public LowerOctaveAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        int loweredOctave = this.getMusicalContext().getNote().getOctave() - 1;
        if(loweredOctave >= Note.MIN_OCTAVE){
            this.getMusicalContext().getNote().setOctave(loweredOctave);
        }
        this.getMusicalContext().setStatusLastAction(false);
    }
}
