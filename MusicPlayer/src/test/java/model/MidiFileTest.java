package model;

import com.tcp.musicPlayer.model.*;
import com.tcp.musicPlayer.model.instruments.*;
import com.tcp.musicPlayer.model.instruments.Instrument;
import com.tcp.musicPlayer.model.notes.*;

import org.junit.jupiter.api.*;
import javax.sound.midi.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MidiFileTest {

    Note note = new Note(Notes.DO, 5, 500);
    Instrument instrument = new Instrument(Instruments.GUITARRA);
    Volume volume = new Volume(600, 700);
    BPM bpm = new BPM(100);

    MusicalContext context = new MusicalContext(note, instrument, volume, bpm);

    @Test
    void testConstructorCreatesSequenceAndTrack() {
        MidiFile mf = new MidiFile(context, "test_file");

        assertNotNull(mf.getSequence(), "Sequence não pode ser nula");
        assertNotNull(mf.getSequence().getTracks(), "Tracks não devem ser nulos");

        assertTrue(mf.getSequence().getTracks().length > 0,
                "O construtor deve criar ao menos 1 track");
    }

    @Test
    void testConstructorAddsInitialEvents() {
        MidiFile mf = new MidiFile(context, "test_file");

        Track t = mf.getSequence().getTracks()[0];

        // Deve ter eventos:
        // changeInstrument (3 eventos)
        // setBPM (1)
        // configVolume (1)
        assertTrue(t.size() >= 5,
                "O construtor deve registrar instrument, bpm e volume (>=5 eventos)");
    }

    @Test
    void testRegisterMusicalEventAddsMoreEvents() {
        MidiFile mf = new MidiFile(context, "test_file");

        Track t = mf.getSequence().getTracks()[0];
        int before = t.size();

        mf.registerMusicalEvent();
        int after = t.size();

        assertTrue(after > before,
                "registerMusicalEvent deve adicionar mais eventos ao track");
    }

    @Test
    void testGenerateCreatesFiles() {
        MidiFile mf = new MidiFile(context, "test_file_unit");

        mf.generate();

        File midi = mf.getMidi();
        File mp3 = mf.getMp3();

        assertNotNull(midi);
        assertNotNull(mp3);

        assertTrue(midi.exists(), "Arquivo .mid deve ser criado");

        // limpar arquivos após teste
        assertTrue(midi.delete(), "Arquivo .mid deve ser deletado");
    }
}
