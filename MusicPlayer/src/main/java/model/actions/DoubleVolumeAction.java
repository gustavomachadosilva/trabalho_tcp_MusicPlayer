package model.actions;

import model.MusicalContext;
import model.Volume;

public class DoubleVolumeAction extends Action{

    public DoubleVolumeAction(MusicalContext musicalContext) {
        super(musicalContext);
    }

    @Override
    public void execute() {
        Volume volume;
        volume = getMusicalContext().getVolume();
        int currentVolume = volume.getCurrentVolume();
        int maxVolume = volume.getMaxVolume();

        int doubledVolume = currentVolume * 2;

        volume.setCurrentVolume(Math.min(doubledVolume, maxVolume));

    }
}
