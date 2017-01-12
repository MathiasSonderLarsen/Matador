package Game.ChanceCards;

import Game.Fields.Jail;
import Game.GameController;
import Game.Player;

/**
 * ToJailCard does....blabla
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class ToJailCard extends ChanceCard {

    public ToJailCard(String description) {
        super(description);
    }

    @Override
    public void action(Player user) {
        Jail.addPlayer(user);


        GameController.getGameBoard().movePlayerAnim(user, 11, true);


    }
}