package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;

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
