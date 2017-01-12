package Game.Fields;


import Game.GameController;

import java.awt.*;

/**
 * Created by Matt_Lab on 05/01/2017.
 */
public class GoToJail extends Field {

    public GoToJail(String name, int groupID,Color color) {
        super(name, groupID, color);

    }


    @Override
    public void landOnField(Game.Player player) {

        Jail theJailField = ((Jail) GameController.getGameBoard().getField(11));

        theJailField.addPlayer(player);

        GameController.getGameBoard().movePlayerAnim(player, 11, true);


    }

    public desktop_fields.Jail convertToGUI() {
        desktop_fields.Jail.Builder a = new desktop_fields.Jail.Builder()
                .setTitle(name)
                .setFgColor(Color.white)
                .setBgColor(color)
                .setSubText("");
        return a.build();
    }
}
