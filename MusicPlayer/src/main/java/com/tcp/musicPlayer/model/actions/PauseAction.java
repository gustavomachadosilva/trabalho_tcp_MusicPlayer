package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;

public class PauseAction extends Action {

    public PauseAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(true);
        this.getMusicalContext().setStatusLastAction(false);
    }
}
