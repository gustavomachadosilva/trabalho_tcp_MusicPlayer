package model.actions;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.actions.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IncreaseOctaveActionTest {

    private MusicalContext createContext(int octave) {
        return new MusicalContext(
                new Note(Notes.DO, octave, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                new Volume(50, 100),
                new BPM(120)
        );
    }

    @Test
    void testExecute_IncreasesOctaveWhenPossible() {
        MusicalContext context = createContext(3);
        int oldOctave = context.getNote().getOctave();

        IncreaseOctaveAction action = new IncreaseOctaveAction(context);
        action.execute();

        assertEquals(oldOctave + 1, context.getNote().getOctave());
    }

    @Test
    void testExecute_DoesNotIncreaseBeyondMax() {
        MusicalContext context = createContext(Note.MAX_OCTAVE);
        int oldOctave = context.getNote().getOctave();

        IncreaseOctaveAction action = new IncreaseOctaveAction(context);
        action.execute();

        // Octave must remain unchanged
        assertEquals(oldOctave, context.getNote().getOctave());
    }

    @Test
    void testExecute_SetsPauseStatusToFalse() {
        MusicalContext context = createContext(4);
        context.setPauseStatus(true);

        IncreaseOctaveAction action = new IncreaseOctaveAction(context);
        action.execute();

        assertFalse(context.isPaused());
    }

    @Test
    void testExecute_SetsLastActionStatusToFalse() {
        MusicalContext context = createContext(2);
        context.setStatusLastAction(true);

        IncreaseOctaveAction action = new IncreaseOctaveAction(context);
        action.execute();

        assertFalse(context.getStatusLastAction());
    }
}
