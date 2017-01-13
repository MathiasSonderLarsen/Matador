package Game.Fields;


import Game.BoundaryController;
import Game.ChanceCards.ChanceCard;
import Game.GameController;
import Game.Language;

import java.awt.*;

/**
 * Handles the chance card pile
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.3
 */
public class Chance extends Field {

    public Chance(String name, int groupID, Color color) {
        super(name, groupID,color );
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void landOnField(Game.Player player) {

        ChanceCard card = GameController.getGameBoard().getChanceDeck().getCard();


        BoundaryController.showMessage(Language.getString("youdrew") + ' ' + Language.getString(card.getDescription()));
        card.action(player);

    }

    public desktop_fields.Chance convertToGUI() {
        desktop_fields.Chance.Builder a = new desktop_fields.Chance.Builder()
                .setFgColor(Color.yellow)
                .setBgColor(color);
        return a.build();
    }
}
