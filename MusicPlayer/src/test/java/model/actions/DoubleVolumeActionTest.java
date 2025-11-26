package model.actions;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.actions.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleVolumeActionTest {

    @Test
    void testDoubleVolume_NormalCase() {
        // Arrange
        Volume volume = new Volume(20, 100);
        MusicalContext context = new MusicalContext(
                new Note(Notes.DO, 4, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                volume,
                new BPM(120)
        );

        DoubleVolumeAction action = new DoubleVolumeAction(context);

        // Act
        action.execute();

        // Assert
        assertEquals(40, context.getVolume().getCurrentVolume());
        assertFalse(context.isPaused());
        assertFalse(context.getStatusLastAction());
    }

    @Test
    void testDoubleVolume_ClampsAtMaxVolume() {
        // Arrange
        Volume volume = new Volume(70, 100);
        MusicalContext context = new MusicalContext(
                new Note(Notes.DO, 4, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                volume,
                new BPM(120)
        );

        DoubleVolumeAction action = new DoubleVolumeAction(context);

        // Act
        action.execute();

        // Assert — não pode passar de 100
        assertEquals(100, context.getVolume().getCurrentVolume());
    }

    @Test
    void testExecute_SetsPauseToFalse() {
        Volume volume = new Volume(10, 50);
        MusicalContext context = new MusicalContext(
                new Note(Notes.DO, 4, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                volume,
                new BPM(100)
        );

        context.setPauseStatus(true);
        DoubleVolumeAction action = new DoubleVolumeAction(context);

        action.execute();

        assertFalse(context.isPaused());
    }

    @Test
    void testExecute_SetsLastActionStatusToFalse() {
        Volume volume = new Volume(10, 50);
        MusicalContext context = new MusicalContext(
                new Note(Notes.DO, 4, 400),
                new Instrument(Instruments.PIANO_ELETRICO),
                volume,
                new BPM(100)
        );

        context.setStatusLastAction(true);

        DoubleVolumeAction action = new DoubleVolumeAction(context);
        action.execute();

        assertFalse(context.getStatusLastAction());
    }
}
