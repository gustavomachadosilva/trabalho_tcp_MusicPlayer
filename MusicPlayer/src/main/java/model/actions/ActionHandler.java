package model.actions;

import model.MusicalContext;

public class ActionHandler {


    private ActionMapper actionMapper = new ActionMapper();
    private ChangeNoteAction changeNoteAction;
    private DoubleVolumeAction doubleVolumeAction;
    private IncreaseOctaveAction increaseOctaveAction;
    private LowerOctaveAction lowerOctaveAction;
    private RepeatNoteAction repeatNoteAction;
    private RandomNoteAction randomNoteAction;
    private ChangeInstrumentAction changeInstrumentAction;
    private IncreaseBpmAction increaseBpmAction;
    private PauseAction pauseAction;

    public ActionHandler(MusicalContext musicalContext) {
        this.changeNoteAction = new ChangeNoteAction(musicalContext);
        this.doubleVolumeAction = new DoubleVolumeAction(musicalContext);
        this.increaseOctaveAction = new IncreaseOctaveAction(musicalContext);
        this.lowerOctaveAction = new LowerOctaveAction(musicalContext);
        this.repeatNoteAction = new RepeatNoteAction(musicalContext);
        this.randomNoteAction = new RandomNoteAction(musicalContext);
        this.changeInstrumentAction = new ChangeInstrumentAction(musicalContext);
        this.increaseBpmAction = new IncreaseBpmAction(musicalContext);
        this.pauseAction = new PauseAction(musicalContext);
    }

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

    public ActionMapper getActionMapper() {
        return actionMapper;
    }
}
