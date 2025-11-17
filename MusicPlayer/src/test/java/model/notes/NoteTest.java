package model.notes;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class NoteTest extends TestCase {


    private Note noteC4 = new Note(Notes.DO, 4, 500);;

    public void testConstructorSetsValuesCorrectly() {
        assertEquals("A oitava deve ser 4", 4, noteC4.getOctave());
        assertEquals("A duração deve ser 500", 500, noteC4.getDuration());
    }

    @Test
    public void testMidiCodeCalculationIsCorrect() {
        int expectedMidi = Notes.DO.getMidiCode() + (4 - Notes.BASE_OCTAVE) * 12;
        assertEquals("O código MIDI deve ser calculado corretamente", expectedMidi, noteC4.getMidiCode());
    }

    @Test
    public void testHigherOctaves() {
        Note noteHigher = new Note(Notes.DO, 5, 500);
        assertTrue("Uma oitava mais alta deve ter código MIDI maior",
                noteHigher.getMidiCode() > noteC4.getMidiCode());
    }

    @Test
    public void testLowerOctave(){
        Note noteLower = new Note(Notes.DO, 3, 500);
        assertTrue("Uma oitava mais baixa deve ter código MIDI menor",
                noteLower.getMidiCode() < noteC4.getMidiCode());
    }

    @Test
    public void testDurationGetter() {
        assertEquals("getDuration deve retornar o valor correto", 500, noteC4.getDuration());
    }

}