package Controller.Actions;

import Controller.MusicalContext;
import Controller.Player;

public class DoubleVolumeAction extends Action{

    public DoubleVolumeAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        int currentVolume = getMusicalContext().getVolume();
        int maxVolume = getMusicalContext().getMaxVolume();

        int doubledVolume = currentVolume * 2;

        getMusicalContext().setVolume(Math.min(doubledVolume, maxVolume));

    }
}
