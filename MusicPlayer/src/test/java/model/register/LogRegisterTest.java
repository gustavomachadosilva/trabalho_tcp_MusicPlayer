package model.register;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.notes.*;
import com.tcp.musicPlayer.model.register.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogRegisterTest {

    // musical context base
    Note note = new Note(Notes.DO, 4, 500);
    Instrument instrument = new Instrument(Instruments.PIANO_ACUSTICO);
    Volume volume = new Volume(80, 127);
    BPM bpm = new BPM(120);

    @Test
    void testConstructorInitialValues() {
        MusicalContext context = new MusicalContext(note, instrument, volume, bpm);
        LogRegister log = new LogRegister(context);

        assertEquals(0, log.getNumNotes());
        assertEquals(0, log.getNumPauses());
        assertEquals(0, log.getDuration());
        assertTrue(log.getLogMusicalRegister().isEmpty());
    }

    @Test
    void testAddRegisterNote() {
        MusicalContext context = new MusicalContext(note, instrument, volume, bpm);
        LogRegister log = new LogRegister(context);

        context.setPauseStatus(false);
        log.addRegister();

        assertEquals(1, log.getNumNotes());
        assertEquals(0, log.getNumPauses());
        assertEquals(500, log.getDuration());
        assertEquals(1, log.getLogMusicalRegister().size());

        MusicalRegister reg = log.getLogMusicalRegister().get(0);
        assertEquals("Piano Acústico", reg.getInstrument());
        assertEquals("DO", reg.getNote());
        assertEquals(4, reg.getOctave());
    }

    @Test
    void testAddRegisterPause() {
        MusicalContext context = new MusicalContext(note, instrument, volume, bpm);
        LogRegister log = new LogRegister(context);

        context.setPauseStatus(true);
        log.addRegister();

        assertEquals(0, log.getNumNotes());
        assertEquals(1, log.getNumPauses());
        assertEquals(500, log.getDuration());
        assertEquals(1, log.getLogMusicalRegister().size());

        MusicalRegister reg = log.getLogMusicalRegister().get(0);
        assertEquals("Piano Acústico", reg.getInstrument());
        assertEquals("DO", reg.getNote());
        assertEquals(4, reg.getOctave());
    }

    @Test
    void testMultipleRegisters() {
        MusicalContext context = new MusicalContext(note, instrument, volume, bpm);
        LogRegister log = new LogRegister(context);

        // 1) Nota
        context.setPauseStatus(false);
        log.addRegister();  // +1 note (duration 500)

        // 2) Pausa
        context.setPauseStatus(true);
        log.addRegister();  // +1 pause (duration 500)

        // 3) Nota novamente
        context.setPauseStatus(false);
        log.addRegister();  // +1 note (duration 500)

        assertEquals(2, log.getNumNotes());
        assertEquals(1, log.getNumPauses());
        assertEquals(1500, log.getDuration());
        assertEquals(3, log.getLogMusicalRegister().size());
    }
}
