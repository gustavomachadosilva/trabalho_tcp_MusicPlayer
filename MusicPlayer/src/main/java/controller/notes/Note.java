package controller.notes;

public class Note {

    private int octave;
    private float duration;
    private String name;

    public Note() {
    }
    // Notas MIDI baseadas na oitava 5
    private static final int[] NOTE_VALUES = {
            69, // A (Lá)
            71, // B (Si)
            60, // C (Dó)
            62, // D (Ré)
            64, // E (Mi)
            65, // F (Fá)
            67, // G (Sol)
            70  // H (Si♭)
    };

    public static int getMidiNoteForChar(char c, int octave) {
        int base = (octave - 5) * 12; // desloca conforme oitava
        return switch (c) {
            case 'A' -> NOTE_VALUES[0] + base;
            case 'B' -> NOTE_VALUES[1] + base;
            case 'C' -> NOTE_VALUES[2] + base;
            case 'D' -> NOTE_VALUES[3] + base;
            case 'E' -> NOTE_VALUES[4] + base;
            case 'F' -> NOTE_VALUES[5] + base;
            case 'G' -> NOTE_VALUES[6] + base;
            case 'H' -> NOTE_VALUES[7] + base;
            default -> -1;
        };
    }
}
