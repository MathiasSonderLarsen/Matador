package Game.Fields;


import Game.GameController;
import Game.Player;

import java.awt.*;

/**
 * FreeParking class
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.2
 */
public class FreeParking extends Field {

    public FreeParking(String name, int groupID) {
        super(name, groupID);
    }

    @Override
    public void landOnField(Player player) {

        GameController.playTurn(player);

    }

    public desktop_fields.Jail convertToGUI() {
        desktop_fields.Jail.Builder a = new desktop_fields.Jail.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText("");
        return a.build();
    }
}
