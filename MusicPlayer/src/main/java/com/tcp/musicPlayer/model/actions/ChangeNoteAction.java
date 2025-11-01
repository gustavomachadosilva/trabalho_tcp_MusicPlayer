package model.actions;

import model.MusicalContext;
import model.notes.*;

public class ChangeNoteAction extends Action{

    private Notes note;

    public ChangeNoteAction(MusicalContext musicalContext, Notes note) {
        super(musicalContext);
        this.note = note;
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        this.getMusicalContext().getNote().updateNote(this.note);
        this.getMusicalContext().setStatusLastAction(true);
    }
}
