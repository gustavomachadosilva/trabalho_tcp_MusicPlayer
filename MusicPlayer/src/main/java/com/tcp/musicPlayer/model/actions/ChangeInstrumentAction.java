package model.actions;

import model.MusicalContext;
import model.instruments.*;
import java.util.Random;

public class ChangeInstrumentAction extends Action {

    private static final Random RAND = new Random();
    private static final Instruments[] VALUES_ENUM = Instruments.values();

    public ChangeInstrumentAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        this.getMusicalContext().setPauseStatus(false);
        Instruments newInstrumemt;
        do{
            newInstrumemt = VALUES_ENUM[RAND.nextInt(VALUES_ENUM.length)];
        }
        while(newInstrumemt.getMidiCode() == this.getMusicalContext().getInstrument().getMidiCode());
        this.getMusicalContext().getInstrument().changeInstrument(newInstrumemt);
        this.getMusicalContext().setStatusLastAction(false);
    }
}
