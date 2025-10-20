package controller;

import model.MusicalContext;
import model.actions.*;

public class ActionTest {

    MusicalContext musicalContext = new MusicalContext(1, 1, 1, 1, 1);
    ActionMapper actionMapper = new ActionMapper();
    ChangeNoteAction changeNoteAction = new ChangeNoteAction(musicalContext);
    DoubleVolumeAction doubleVolumeAction = new DoubleVolumeAction(musicalContext);
    IncreaseOctaveAction increaseOctaveAction = new IncreaseOctaveAction(musicalContext);
    LowerOctaveAction lowerOctaveAction = new LowerOctaveAction(musicalContext);
    RepeatNoteAction repeatNoteAction = new RepeatNoteAction(musicalContext);
    RandomNoteAction randomNoteAction = new RandomNoteAction(musicalContext);
    ChangeInstrumentAction changeInstrumentAction = new ChangeInstrumentAction(musicalContext);
    IncreaseBpmAction increaseBpmAction = new IncreaseBpmAction(musicalContext);
    PauseAction pauseAction = new PauseAction(musicalContext);

    public void doMap() {
        actionMapper.assignActionToAKey("A", changeNoteAction);
        actionMapper.assignActionToAKey("B", changeNoteAction);
        actionMapper.assignActionToAKey("C", changeNoteAction);
        actionMapper.assignActionToAKey("D", changeNoteAction);
        actionMapper.assignActionToAKey("E", changeNoteAction);
        actionMapper.assignActionToAKey("F", changeNoteAction);
        actionMapper.assignActionToAKey("G", changeNoteAction);
        actionMapper.assignActionToAKey("H", changeNoteAction);

        actionMapper.assignActionToAKey("a", changeNoteAction);
        actionMapper.assignActionToAKey("b", changeNoteAction);
        actionMapper.assignActionToAKey("c", changeNoteAction);
        actionMapper.assignActionToAKey("d", changeNoteAction);
        actionMapper.assignActionToAKey("e", changeNoteAction);
        actionMapper.assignActionToAKey("f", changeNoteAction);
        actionMapper.assignActionToAKey("g", changeNoteAction);
        actionMapper.assignActionToAKey("h", changeNoteAction);

        actionMapper.assignActionToAKey(" ", doubleVolumeAction);

        actionMapper.assignActionToAKey("+", increaseOctaveAction);

        actionMapper.assignActionToAKey("-", lowerOctaveAction);

        actionMapper.assignActionToAKey("I", repeatNoteAction);
        actionMapper.assignActionToAKey("O", repeatNoteAction);
        actionMapper.assignActionToAKey("U", repeatNoteAction);

        actionMapper.assignActionToAKey("i", repeatNoteAction);
        actionMapper.assignActionToAKey("o", repeatNoteAction);
        actionMapper.assignActionToAKey("u", repeatNoteAction);

        actionMapper.assignActionToAKey("?", randomNoteAction);

        actionMapper.assignActionToAKey("\n", changeInstrumentAction);

        actionMapper.assignActionToAKey("BPM+", increaseBpmAction);

        actionMapper.assignActionToAKey(";", pauseAction);

    }

}
