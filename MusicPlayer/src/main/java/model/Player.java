package model;

public class Player {

    private MusicalContext musicalContext;

    public Player(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
    }

    public MusicalContext getMusicalContext() {
        return musicalContext;
    }

    public void setMusicalContext(MusicalContext musicalContext) {
        this.musicalContext = musicalContext;
    }

    public void play() {
        System.out.println("play");
    }
}
