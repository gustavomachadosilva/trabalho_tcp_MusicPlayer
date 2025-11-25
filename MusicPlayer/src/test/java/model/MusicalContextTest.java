package model;




import com.tcp.musicPlayer.model.BPM;
import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.Volume;
import com.tcp.musicPlayer.model.instruments.Instrument;
import com.tcp.musicPlayer.model.instruments.Instruments;
import com.tcp.musicPlayer.model.notes.Note;
import com.tcp.musicPlayer.model.notes.Notes;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class MusicalContextTest extends TestCase {

    private Note note = new Note(Notes.DO, 5, 500);
    private Instrument instrument = new Instrument(Instruments.GUITARRA);
    private Volume volume = new Volume(600, 700);
    private BPM bpm = new BPM(100);
    private MusicalContext context = new MusicalContext(note, instrument, volume, bpm);

    @Test
    public void testConstructorSetsValueCorrectly() {
        assertNotNull("O construtor deve definir uma nota", context.getNote());
        assertNotNull("O construtor deve definir um instrumento", context.getInstrument());
        assertNotNull("O construtor deve definir um volume", context.getVolume());
        assertNotNull("O construtor deve definir um BPM", context.getBpm());
    }
    @Test
    public void testGetNote() {
        assertEquals("getNote deve retornar a nota correta", note, context.getNote());
    }

    @Test
    public void testGetInstrument() {
        assertEquals("getInstrument deve retornar o instrumento correto", instrument, context.getInstrument());
    }

    @Test
    public void testGetVolume() {
        assertEquals("getVolume deve retornar o volume correto", volume, context.getVolume());
    }

    @Test
    public void testGetBpm() {
        assertEquals("getBpm deve retornar o BPM correto", bpm, context.getBpm());
    }
}