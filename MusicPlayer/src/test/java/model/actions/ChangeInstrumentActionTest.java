package model.actions;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.actions.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeInstrumentActionTest {

    private MusicalContext createContext(Instruments instrumentEnum) {
        return new MusicalContext(
                new Note(Notes.DO, 4, 500),
                new Instrument(instrumentEnum),
                new Volume(50, 100),
                new BPM(120)
        );
    }

    @Test
    void testExecute_ChangesInstrumentToDifferentOne() {

        MusicalContext context = createContext(Instruments.PIANO_ELETRICO);
        int oldMidiCode = context.getInstrument().getMidiCode();

        ChangeInstrumentAction action = new ChangeInstrumentAction(context);
        action.execute();

        int newMidiCode = context.getInstrument().getMidiCode();

        assertNotEquals(oldMidiCode, newMidiCode);
    }

    @Test
    void testExecute_SetsPauseStatusToFalse() {

        MusicalContext context = createContext(Instruments.FLAUTA);
        context.setPauseStatus(true);

        ChangeInstrumentAction action = new ChangeInstrumentAction(context);
        action.execute();

        assertFalse(context.isPaused());
    }

    @Test
    void testExecute_SetsLastActionStatusToFalse() {

        MusicalContext context = createContext(Instruments.VIOLINO);
        context.setStatusLastAction(true);

        ChangeInstrumentAction action = new ChangeInstrumentAction(context);
        action.execute();

        assertFalse(context.getStatusLastAction());
    }

    @Test
    void testExecute_ActuallyChangesNameAndMidiCode() {

        MusicalContext context = createContext(Instruments.GUITARRA);

        String oldName = context.getInstrument().getName();
        int oldCode  = context.getInstrument().getMidiCode();

        ChangeInstrumentAction action = new ChangeInstrumentAction(context);
        action.execute();

        assertNotEquals(oldName, context.getInstrument().getName());
        assertNotEquals(oldCode, context.getInstrument().getMidiCode());
    }
}
