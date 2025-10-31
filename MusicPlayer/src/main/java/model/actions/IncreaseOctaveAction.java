package model.actions;

import model.MusicalContext;
import model.notes.Note;

public class IncreaseOctaveAction extends Action{

    public IncreaseOctaveAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        int increasedOctave = this.getMusicalContext().getNote().getOctave() + 1;
        if(increasedOctave <= Note.MAX_OCTAVE){
            this.getMusicalContext().getNote().setOctave(increasedOctave);
        }
        this.getMusicalContext().setStatusLastAction(false);
    }
}