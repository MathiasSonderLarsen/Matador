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

        player.setExtraTurn(true);

    }

    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText("");
        return a.build();
    }
}
