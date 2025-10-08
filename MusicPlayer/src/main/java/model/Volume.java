package model;

public class Volume {

    private int currentVolume;
    private int maxVolume;

    public Volume(int currentVolume, int maxVolume) {
        this.currentVolume = currentVolume;
        this.maxVolume = maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }
}
