import model.*;
import model.instruments.Instrument;
import model.instruments.Instruments;
import model.notes.Note;
import model.notes.Notes;

public class Main {

    public static void main(String[] args) {

        Note note = new Note(Notes.DO, 5, 500);
        Instrument instrument = new Instrument(Instruments.GUITARRA);
        Volume volume = new Volume(600, 700);
        BPM bpm = new BPM(100);

        MusicalContext musicalContext = new MusicalContext(note, instrument, volume, bpm);

        MidiFile midiFile = new MidiFile(musicalContext, "teste");

        Player player = new Player(midiFile);

        player.play();

        player.close();

    }

}
