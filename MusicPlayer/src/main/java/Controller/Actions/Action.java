package Controller.Actions;

import Controller.MusicalContext;
import Controller.Player;

public class Action {

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

    public void execute() {
        System.out.println("Action has not been defined!");
    }
}
