package model.instruments;

import com.tcp.musicPlayer.model.instruments.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentTest {

    @Test
    void testConstructorInicializaCorretamente() {
        Instrument instrument = new Instrument(Instruments.PIANO_ELETRICO);

        assertEquals(Instruments.PIANO_ELETRICO.getName(), instrument.getName());
        assertEquals(Instruments.PIANO_ELETRICO.getMidiCode(), instrument.getMidiCode());
    }

    @Test
    void testChangeInstrumentAlteraOsValores() {
        Instrument instrument = new Instrument(Instruments.PIANO_ELETRICO);

        instrument.changeInstrument(Instruments.VIOLINO);

        assertEquals(Instruments.VIOLINO.getName(), instrument.getName());
        assertEquals(Instruments.VIOLINO.getMidiCode(), instrument.getMidiCode());
    }
}
