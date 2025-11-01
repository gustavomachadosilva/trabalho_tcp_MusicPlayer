package com.tcp.musicPlayer.model.actions;

import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.BPM;

public class IncreaseBpmAction extends Action {

    public static final int VALUE_TO_INCREASE = 80;

    public IncreaseBpmAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        BPM bpm;
        bpm = this.getMusicalContext().getBpm();
        int increacedValue = bpm.getValue() + VALUE_TO_INCREASE;
        bpm.setValue(increacedValue);
        this.getMusicalContext().setStatusLastAction(false);
    }
}
