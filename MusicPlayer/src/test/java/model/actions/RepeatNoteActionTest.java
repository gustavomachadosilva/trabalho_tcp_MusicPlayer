package model.actions;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.actions.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatNoteActionTest {

    private MusicalContext createContext(boolean lastAction) {
        return new MusicalContext(
                new Note(Notes.DO, 4, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                new Volume(50, 100),
                new BPM(120)
        );
    }

    @Test
    void testExecute_ChangesInstrumentWhenNotLastAction() {
        MusicalContext context = createContext(false);
        context.setStatusLastAction(false); // condição para trocar instrumento

        RepeatNoteAction action = new RepeatNoteAction(context);
        action.execute();

        assertEquals("Telefone", context.getInstrument().getName());
        assertEquals(Instruments.TELEFONE.getMidiCode(), context.getInstrument().getMidiCode());
    }

    @Test
    void testExecute_DoesNotChangeInstrumentWhenLastActionWasNote() {
        MusicalContext context = createContext(true);
        context.setStatusLastAction(true);

        Instrument before = context.getInstrument();

        RepeatNoteAction action = new RepeatNoteAction(context);
        action.execute();

        assertEquals(before.getName(), context.getInstrument().getName());
        assertEquals(before.getMidiCode(), context.getInstrument().getMidiCode());
    }

    @Test
    void testExecute_SetsPauseStatusToFalse() {
        MusicalContext context = createContext(false);
        context.setPauseStatus(true);

        RepeatNoteAction action = new RepeatNoteAction(context);
        action.execute();

        assertFalse(context.isPaused());
    }

    @Test
    void testExecute_SetsLastActionStatusToFalseAlways() {
        MusicalContext context = createContext(false);
        context.setStatusLastAction(true);

        RepeatNoteAction action = new RepeatNoteAction(context);
        action.execute();

        assertFalse(context.getStatusLastAction());
    }
}
