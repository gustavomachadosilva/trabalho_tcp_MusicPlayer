import model.MusicalContext;
import model.Player;
import model.Volume;
import model.instruments.Instrument;
import model.instruments.Instruments;
import model.notes.Note;
import model.notes.Notes;

public class Main {

    public static void main(String[] args) {

        Note note = new Note(Notes.DO, 5, 500);
        Instrument instrument = new Instrument(Instruments.GUITARRA);
        Volume volume = new Volume(600, 700);

        MusicalContext musicalContext = new MusicalContext(note, instrument, volume);

        Player player = new Player(musicalContext);

        player.play();

        player.close();

    }

}
