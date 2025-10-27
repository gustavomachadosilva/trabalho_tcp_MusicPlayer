package model.actions;

import model.MusicalContext;
import model.notes.Notes;

public class ActionHandler {


    private ActionMapper actionMapper = new ActionMapper();
    private ChangeNoteAction changeNoteActionToLA;
    private ChangeNoteAction changeNoteActionToSI;
    private ChangeNoteAction changeNoteActionToDO;
    private ChangeNoteAction changeNoteActionToRE;
    private ChangeNoteAction changeNoteActionToMI;
    private ChangeNoteAction changeNoteActionToFA;
    private ChangeNoteAction changeNoteActionToSOL;
    private ChangeNoteAction changeNoteActionToSIB;
    private DoubleVolumeAction doubleVolumeAction;
    private IncreaseOctaveAction increaseOctaveAction;
    private LowerOctaveAction lowerOctaveAction;
    private RepeatNoteAction repeatNoteAction;
    private RandomNoteAction randomNoteAction;
    private ChangeInstrumentAction changeInstrumentAction;
    private IncreaseBpmAction increaseBpmAction;
    private PauseAction pauseAction;

    public ActionHandler(MusicalContext musicalContext) {
        this.changeNoteActionToLA = new ChangeNoteAction(musicalContext, Notes.LA);
        this.changeNoteActionToSI = new ChangeNoteAction(musicalContext, Notes.SI);
        this.changeNoteActionToDO = new ChangeNoteAction(musicalContext, Notes.DO);
        this.changeNoteActionToRE = new ChangeNoteAction(musicalContext, Notes.RE);
        this.changeNoteActionToMI = new ChangeNoteAction(musicalContext, Notes.MI);
        this.changeNoteActionToFA = new ChangeNoteAction(musicalContext, Notes.FA);
        this.changeNoteActionToSOL = new ChangeNoteAction(musicalContext, Notes.SOL);
        this.changeNoteActionToSIB = new ChangeNoteAction(musicalContext, Notes.SIB);
        this.doubleVolumeAction = new DoubleVolumeAction(musicalContext);
        this.increaseOctaveAction = new IncreaseOctaveAction(musicalContext);
        this.lowerOctaveAction = new LowerOctaveAction(musicalContext);
        this.repeatNoteAction = new RepeatNoteAction(musicalContext);
        this.randomNoteAction = new RandomNoteAction(musicalContext);
        this.changeInstrumentAction = new ChangeInstrumentAction(musicalContext);
        this.increaseBpmAction = new IncreaseBpmAction(musicalContext);
        this.pauseAction = new PauseAction(musicalContext);

        this.doMap();
    }

    private void doMap() {
        actionMapper.assignActionToAKey("A", changeNoteActionToLA);
        actionMapper.assignActionToAKey("B", changeNoteActionToSI);
        actionMapper.assignActionToAKey("C", changeNoteActionToDO);
        actionMapper.assignActionToAKey("D", changeNoteActionToRE);
        actionMapper.assignActionToAKey("E", changeNoteActionToMI);
        actionMapper.assignActionToAKey("F", changeNoteActionToFA);
        actionMapper.assignActionToAKey("G", changeNoteActionToSOL);
        actionMapper.assignActionToAKey("H", changeNoteActionToSIB);

        actionMapper.assignActionToAKey("a", changeNoteActionToLA);
        actionMapper.assignActionToAKey("b", changeNoteActionToSI);
        actionMapper.assignActionToAKey("c", changeNoteActionToDO);
        actionMapper.assignActionToAKey("d", changeNoteActionToRE);
        actionMapper.assignActionToAKey("e", changeNoteActionToMI);
        actionMapper.assignActionToAKey("f", changeNoteActionToFA);
        actionMapper.assignActionToAKey("g", changeNoteActionToSOL);
        actionMapper.assignActionToAKey("h", changeNoteActionToSIB);

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
