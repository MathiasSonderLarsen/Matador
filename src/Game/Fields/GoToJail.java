package Game.Fields;


import Game.GameController;

import java.awt.*;

/**
 * Created by Matt_Lab on 05/01/2017.
 */
public class GoToJail extends Field {

    public GoToJail(String name, int groupID) {
        super(name, groupID);

    }


    @Override
    public void landOnField(Game.Player player) {

        Jail theJailField = ((Jail) GameController.getGameBoard().getField(11));

        theJailField.addPlayer(player);

        GameController.movePlayerAnim(player, 11 - player.getOnField(), true);


    }

    public desktop_fields.Jail convertToGUI() {
        desktop_fields.Jail.Builder a = new desktop_fields.Jail.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText("");
        return a.build();
    }
}
