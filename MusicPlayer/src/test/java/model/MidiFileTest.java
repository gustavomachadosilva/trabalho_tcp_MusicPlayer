package model;
import com.tcp.musicPlayer.model.BPM;
import com.tcp.musicPlayer.model.MidiFile;
import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.Volume;
import com.tcp.musicPlayer.model.instruments.Instrument;
import com.tcp.musicPlayer.model.instruments.Instruments;
import com.tcp.musicPlayer.model.notes.Note;
import com.tcp.musicPlayer.model.notes.Notes;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.File;

public class MidiFileTest extends TestCase {

    private Note note = new Note(Notes.DO, 5, 500);
    private Instrument instrument = new Instrument(Instruments.GUITARRA);
    private Volume volume = new Volume(600, 700);
    private BPM bpm = new BPM(100);
    private MusicalContext musicalContext = new MusicalContext(note, instrument, volume, bpm);
    private MidiFile midiFile = new MidiFile(musicalContext, "test.mid");
    private Sequence sequence = midiFile.getSequence();
    private Track[] tracks = sequence.getTracks();

    @Test
    public void testTrackFromSequence() {
        assertNotNull("Track deve ser criada dentro da sequência", tracks);
        assertTrue("Deve existir ao menos uma track", tracks.length > 0);
    }

    @Test
    public void testTrackEvents() {
        Track track = tracks[0];
        assertTrue("O construtor deve adicionar eventos iniciais (BPM e instrumento)", track.size() > 0);
    }

    @Test
    public void testGetSequence() {
        Sequence seq = midiFile.getSequence();
        assertNotNull("A sequência não deve ser nula", seq);
    }

    @Test
    public void testChangeInstrument() {
        midiFile.changeInstrument();
        // Verifica se há eventos na track (o metodo adiciona um evento de mudança de instrumento)
        assertTrue("Track deve ter pelo menos 1 evento após changeInstrument", midiFile.getSequence().getTracks()[0].size() > 0);
    }

    @Test
    public void testAddNote() {
        midiFile.addNote();
        // Deve adicionar 2 eventos: NOTE_ON e NOTE_OFF
        assertTrue("Track deve ter pelo menos 2 eventos após addNote", midiFile.getSequence().getTracks()[0].size() >= 2);
    }

    @Test
    public void testSaveFile() {
        String fileName = "test_output.mid";
        midiFile = new MidiFile(musicalContext, fileName);
        midiFile.saveFile();

        File file = new File(fileName);
        assertTrue("Arquivo MIDI deve ser criado", file.exists());

        // Limpeza
        file.delete();
    }
}
