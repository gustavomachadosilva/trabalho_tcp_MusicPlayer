package model.register;

import com.tcp.musicPlayer.model.register.MusicalRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicalRegisterTest {

    @Test
    void testConstructorInitialValues() {
        MusicalRegister reg = new MusicalRegister();

        assertNull(reg.getInstrument(), "Instrument deve iniciar como null");
        assertNull(reg.getNote(), "Note deve iniciar como null");
        assertEquals(0, reg.getOctave(), "Octave deve iniciar como 0");
    }

    @Test
    void testSettersAndGetters() {
        MusicalRegister reg = new MusicalRegister();

        reg.setInstrument("Piano");
        reg.setNote("C#");
        reg.setOctave(5);

        assertEquals("Piano", reg.getInstrument());
        assertEquals("C#", reg.getNote());
        assertEquals(5, reg.getOctave());
    }
}
