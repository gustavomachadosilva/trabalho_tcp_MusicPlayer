package model.actions;

import model.MusicalContext;
import model.notes.Notes;

public abstract class Action {

    private MusicalContext musicalContext;

    public Action() {
    }

    public Action(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
    }

    public MusicalContext getMusicalContext() {
        return musicalContext;
    }

    public void setMusicalContext(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
    }

    public abstract void execute();
}
