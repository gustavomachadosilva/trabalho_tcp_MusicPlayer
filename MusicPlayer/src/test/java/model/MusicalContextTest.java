package model;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicalContextTest {

    Note note = new Note(Notes.DO, 5, 500);
    Instrument instrument = new Instrument(Instruments.GUITARRA);
    Volume volume = new Volume(600, 700);
    BPM bpm = new BPM(100);

    MusicalContext context = new MusicalContext(note, instrument, volume, bpm);

    @Test
    void testConstructorSetsValuesCorrectly() {
        assertEquals(note, context.getNote());
        assertEquals(instrument, context.getInstrument());
        assertEquals(volume, context.getVolume());
        assertEquals(bpm, context.getBpm());
        assertFalse(context.isPaused());
    }

    @Test
    void testGetVolumeWhenNotPaused() {
        assertEquals(volume, context.getVolume());
    }

    @Test
    void testGetVolumeWhenPaused() {
        context.setPauseStatus(true);

        Volume v = context.getVolume();

        assertEquals(0, v.getCurrentVolume());
        assertEquals(volume.getMaxVolume(), v.getMaxVolume());
    }

    @Test
    void testPauseStatusSetter() {
        context.setPauseStatus(true);
        assertTrue(context.isPaused());

        context.setPauseStatus(false);
        assertFalse(context.isPaused());
    }

    @Test
    void testLastActionStatus() {
        context.setStatusLastAction(true);
        assertTrue(context.getStatusLastAction());

        context.setStatusLastAction(false);
        assertFalse(context.getStatusLastAction());
    }
}
