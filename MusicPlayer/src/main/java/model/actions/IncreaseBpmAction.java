package model.actions;

import model.MusicalContext;
import model.BPM;

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
