package model;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import controller.notes.Note;

public class TextHandler {

    // ===========================
    // INSTRUMENTS
    // ===========================
    public static final int INSTRUMENT_PIANO = 0;
    public static final int INSTRUMENT_BANDONEON = 24;
    public static final int INSTRUMENT_TUBULAR_BELLS = 15;
    public static final int INSTRUMENT_AGOGO = 114;
    public static final int INSTRUMENT_ONDAS_DO_MAR = 123;
    public static final int INSTRUMENT_GAITA_DE_FOLES = 110;

    // ===========================
    // CONSTANTES DE CONFIGURAÇÃO
    // ===========================
    public static final int DEFAULT_OCTAVE = 5;
    public static final int DEFAULT_VOLUME = 80;

    private Synthesizer synth;
    private MidiChannel channel;
    private int instrument = INSTRUMENT_PIANO;
    private int octave = DEFAULT_OCTAVE;
    private int volume = DEFAULT_VOLUME;
    private int lastNote = -1;
    private char lastChar = ' ';

    public TextHandler() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channel = synth.getChannels()[0];
            channel.programChange(instrument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playText(String text) {
        try {
            for (char c : text.toCharArray()) {
                lastChar = c;
                processChar(c);
                Thread.sleep(200); // pequena pausa entre notas
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processChar(char c) {
        if (Character.isUpperCase(c)) {
            playNoteForUpperCase(c);            //notas
        } else if (Character.isDigit(c)) {
            handleDigit(c);
        } else {
            handleSpecialChar(c);
        }
    }

    private void playNoteForUpperCase(char c) {
        int note = Note.getMidiNoteForChar(c, octave);
        if (note != -1) {
            channel.programChange(instrument);
            playNote(note, volume);
            lastNote = note;
        } else {
            pause();
        }
    }

    private void handleDigit(char c) {
        int digit = Character.getNumericValue(c);
        if (digit % 2 == 0) {
            instrument = Math.min(127, instrument + digit);
        } else {
            instrument = INSTRUMENT_TUBULAR_BELLS; // Tubular Bells
        }
        channel.programChange(instrument);
    }

    private void handleSpecialChar(char c) {
        switch (c) {
            case 'O': case 'o': case 'I': case 'i': case 'U': case 'u':
                instrument = INSTRUMENT_GAITA_DE_FOLES;
                break;
            case '!':
                instrument = INSTRUMENT_BANDONEON;
                break;
            case '?':
            case '.':
                octave = Math.min(8, octave + 1);
                break;
            case '\n':
                instrument = INSTRUMENT_ONDAS_DO_MAR;
                break;
            case ';':
                instrument = INSTRUMENT_TUBULAR_BELLS;
                break;
            case ',':
                instrument = INSTRUMENT_AGOGO;
                break;
            case ' ':
                volume = Math.min(127, volume * 2);
                break;
            default:
                repeatOrPause(c);
                return;
        }
        channel.programChange(instrument);
    }

    private void repeatOrPause(char c) {
        //testa se A ultima nota eh uma letra
        if (repeatCondition(c)) {
            playNote(lastNote, volume);
        } else pause();
    }

    private boolean repeatCondition(char c) {
        return (((lastChar >= 'A') && (lastChar <= 'H')) && !(c >= 'a' && c <= 'h'));
    }
    private void pause() {
        sleep(200);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    private void playNote(int note, int volume) {
        channel.noteOn(note, volume);
        sleep(300);
        channel.noteOff(note);
    }
}
