import model.notes.Note;
import model.notes.Notes;

public class Main {

    public static void main(String[] args) {

        Note note = new Note(Notes.LA, 5, 500);

        System.out.println(note.getMidiCode());

    }

}
