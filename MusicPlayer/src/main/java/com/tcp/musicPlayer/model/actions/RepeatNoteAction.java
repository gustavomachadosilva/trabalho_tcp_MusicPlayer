package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.instruments.Instruments;

public class RepeatNoteAction extends Action {

    public RepeatNoteAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        if(!this.getMusicalContext().getStatusLastAction()){
            this.getMusicalContext().getInstrument().changeInstrument(Instruments.TELEFONE);
        }
        this.getMusicalContext().setStatusLastAction(false);
    }
}
