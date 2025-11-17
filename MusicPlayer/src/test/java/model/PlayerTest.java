package model;

import model.instruments.Instrument;
import model.notes.Notes;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import model.MidiFile;
import model.MusicalContext;
import model.Player;
import model.instruments.Instruments;
import model.notes.Note;
import model.BPM;
import model.Volume;

public class PlayerTest extends TestCase {

    private Note note = new Note(Notes.DO, 5, 500);
    private Instrument instrument = new Instrument(Instruments.GUITARRA);
    private Volume volume = new Volume(600, 700);
    private BPM bpm = new BPM(100);
    private MusicalContext musicalContext = new MusicalContext(note, instrument, volume, bpm);
    private MidiFile midiFile = new MidiFile(musicalContext, "test.mid");
    private Player player = new Player(midiFile);

    @Test
    public void testPlayerInitialization() {
        assertNotNull("O Player deve ser inicializado com um MidiFile válido", player);
    }

    @Test
    public void testPlayDoesNotThrowException() {
        try {
            // Executa em thread separada para evitar travar o teste
            Thread thread = new Thread(() -> player.play());
            thread.start();
            Thread.sleep(500);
            player.close();

            assertTrue(true); // Se chegou aqui, o metodo rodou sem lançar exceções
        } catch (Exception e) {
            fail("play() lançou uma exceção: " + e.getMessage());
        }
    }

    @Test
    public void testCloseDoesNotThrowException() {
        try {
            player.play();
            player.close();
            assertTrue(true);
        } catch (Exception e) {
            fail("close() lançou uma exceção: " + e.getMessage());
        }
    }
}
