package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.notes.*;
import java.util.Random;

public class RandomNoteAction extends Action {

    private static final Random RAND = new Random();
    private static final Notes[] VALUES_ENUM = Notes.values();

    public RandomNoteAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        Notes randomNote = VALUES_ENUM[RAND.nextInt(VALUES_ENUM.length)];
        this.getMusicalContext().getNote().updateNote(randomNote);
        this.getMusicalContext().setStatusLastAction(false);
    }
}
