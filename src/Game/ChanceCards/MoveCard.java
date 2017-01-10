package Game.ChanceCards;

import Game.GameController;
import Game.Player;

/**
 * MoveCard does....blabla
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
public class MoveCard extends ChanceCard {

    private int moveAmount;

    public MoveCard(String name, String description, int moveAmount) {
        super(name, description);
        this.moveAmount = moveAmount;
    }

    @Override
    public void action(Player user) {
        GameController.movePlayerAnim(user, moveAmount, false);
    }
}
