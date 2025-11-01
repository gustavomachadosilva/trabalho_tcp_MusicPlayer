package controller;

import model.MusicalContext;
import model.Player;
import model.Volume;
import model.actions.Action;
import model.actions.ActionHandler;
import model.actions.ActionMapper;
import model.inputHandlers.TextHandler;
import model.instruments.Instrument;
import model.instruments.Instruments;
import model.notes.Note;
import model.notes.Notes;

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
