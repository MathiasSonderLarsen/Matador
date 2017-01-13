package Game.Fields;


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

    public FreeParking(String name, int groupID, Color color) {
        super(name, groupID, color);
    }

    /** {@inheritDoc} */
    @Override
    public void landOnField(Player player) {

        player.setExtraTurn(true);

    }

    /** {@inheritDoc} */
    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText("");
        return a.build();
    }
}
