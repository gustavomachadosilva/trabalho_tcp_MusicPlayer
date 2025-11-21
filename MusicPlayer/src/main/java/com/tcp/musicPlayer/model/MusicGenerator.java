package com.tcp.musicPlayer.model;

import com.tcp.musicPlayer.model.actions.Action;
import com.tcp.musicPlayer.model.actions.ActionHandler;
import com.tcp.musicPlayer.model.actions.ActionMapper;
import com.tcp.musicPlayer.model.inputHandlers.TextHandler;
import com.tcp.musicPlayer.model.instruments.Instrument;
import com.tcp.musicPlayer.model.instruments.Instruments;
import com.tcp.musicPlayer.model.notes.Note;
import com.tcp.musicPlayer.model.notes.Notes;
import com.tcp.musicPlayer.model.register.LogRegister;
import com.tcp.musicPlayer.model.register.MusicalRegister;
import org.springframework.core.io.FileSystemResource;

public class MusicGenerator {

    private RequestMusic requestMusic;
    private TextHandler textHandler;
    private Note note;
    private Instrument instrument;
    private Volume volume;
    private BPM bpm;
    private MusicalContext musicalContext;
    private ActionHandler actionHandler;
    private MidiFile midiFile;
    private LogRegister logRegister;

    private final Notes initialNote = Notes.DO;
    private final int initialDuration = 500;
    private final Instruments initialInstrument = Instruments.GUITARRA;
    private final int maxVolume = 127;
    private final String fileName = "teste";

    public MusicGenerator(RequestMusic requestMusic) {
        this.requestMusic = requestMusic;

        instantiateProperties();
    }

    private void instantiateProperties() {
        this.textHandler = new TextHandler(this.requestMusic.getInput());
        this.note = new Note(this.initialNote, this.requestMusic.getOctave(), this.initialDuration);
        this.instrument = new Instrument(this.initialInstrument);
        this.volume = new Volume(this.requestMusic.getVolume(), this.maxVolume);
        this.bpm = new BPM(this.requestMusic.getBpm());
        this.musicalContext = new MusicalContext(this.note, this.instrument, this.volume, this.bpm);
        this.actionHandler = new ActionHandler(this.musicalContext);
        this.midiFile = new MidiFile(musicalContext, fileName);
        this.logRegister = new LogRegister(musicalContext);
    }

    public MidiFile getMidiFile() {
        return midiFile;
    }

    public String getFileName() {
        return fileName;
    }

    public LogRegister getLogRegister() {
        return logRegister;
    }

    public void generateMusic() {

        ActionMapper actionMapper = actionHandler.getActionMapper();

        while (this.textHandler.hasNextChar()) {
            String currentChar = this.textHandler.getNextChar();
            System.out.println(currentChar);

            Action action = actionMapper.getAction(currentChar);
            action.execute();

            logRegister.addRegister();

            midiFile.registerMusicalEvent();
        }

    }
}
