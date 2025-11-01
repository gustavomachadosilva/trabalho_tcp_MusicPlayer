package com.tcp.musicPlayer.controller;

import com.tcp.musicPlayer.model.MusicalContext;
import com.tcp.musicPlayer.model.Player;
import com.tcp.musicPlayer.model.Volume;
import com.tcp.musicPlayer.model.actions.Action;
import com.tcp.musicPlayer.model.actions.ActionHandler;
import com.tcp.musicPlayer.model.actions.ActionMapper;
import com.tcp.musicPlayer.model.inputHandlers.TextHandler;
import com.tcp.musicPlayer.model.instruments.Instrument;
import com.tcp.musicPlayer.model.instruments.Instruments;
import com.tcp.musicPlayer.model.notes.Note;
import com.tcp.musicPlayer.model.notes.Notes;

public class Teste {

    TextHandler textHandler = new TextHandler("auuhduahduh");

    Note note = new Note(Notes.DO, 5, 500);
    Instrument instrument = new Instrument(Instruments.GUITARRA);
    Volume volume = new Volume(600, 700);
    MusicalContext musicalContext = new MusicalContext(note, instrument, volume);
    Player player = new Player(musicalContext);
    ActionHandler actionHandler = new ActionHandler(musicalContext);



    public void testar() {

        ActionMapper actionMapper = actionHandler.getActionMapper();

        while (textHandler.hasNextChar()) {
            char currentChar = textHandler.getNextChar();

            Action action = actionMapper.getAction(String.valueOf(currentChar));
            action.execute();
            player.play();

        }

        player.close();
    }


}
