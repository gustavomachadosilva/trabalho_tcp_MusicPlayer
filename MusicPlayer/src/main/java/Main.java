import Controller.Actions.Action;
import Controller.Actions.ActionMapper;
import Controller.Actions.DoubleVolumeAction;
import Controller.MusicalContext;
import Controller.Player;

public class Main {

    public static void main(String[] args) {
        MusicalContext musicalContext = new MusicalContext(1, 1, 1, 1, 1);
        Player player = new Player(musicalContext);

        ActionMapper actionMapper = new ActionMapper();

        Action currentAction;
        DoubleVolumeAction doubleVolumeAction = new DoubleVolumeAction(musicalContext);

        actionMapper.assignActionToAKey("a", doubleVolumeAction);

        currentAction = actionMapper.getAction("a");
        currentAction.execute();

        player.play();
    }

}
