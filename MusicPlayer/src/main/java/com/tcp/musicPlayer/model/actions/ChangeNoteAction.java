package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.notes.*;

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
