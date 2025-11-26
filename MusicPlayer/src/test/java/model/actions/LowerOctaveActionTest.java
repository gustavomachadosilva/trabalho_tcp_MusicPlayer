package model.actions;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.actions.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowerOctaveActionTest {

    private MusicalContext createContext(int octave) {
        return new MusicalContext(
                new Note(Notes.DO, octave, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                new Volume(50, 100),
                new BPM(120)
        );
    }

    @Test
    void testExecute_LowersOctaveWhenPossible() {
        MusicalContext context = createContext(5);
        int oldOctave = context.getNote().getOctave();

        LowerOctaveAction action = new LowerOctaveAction(context);
        action.execute();

        assertEquals(oldOctave - 1, context.getNote().getOctave());
    }

    @Test
    void testExecute_DoesNotLowerBelowMin() {
        MusicalContext context = createContext(Note.MIN_OCTAVE);
        int oldOctave = context.getNote().getOctave();

        LowerOctaveAction action = new LowerOctaveAction(context);
        action.execute();

        // A oitava deve permanecer igual ao mínimo
        assertEquals(oldOctave, context.getNote().getOctave());
    }

    @Test
    void testExecute_SetsPauseStatusToFalse() {
        MusicalContext context = createContext(4);
        context.setPauseStatus(true);

        LowerOctaveAction action = new LowerOctaveAction(context);
        action.execute();

        assertFalse(context.isPaused());
    }

    @Test
    void testExecute_SetsLastActionStatusToFalse() {
        MusicalContext context = createContext(3);
        context.setStatusLastAction(true);

        LowerOctaveAction action = new LowerOctaveAction(context);
        action.execute();

        assertFalse(context.getStatusLastAction());
    }
}
