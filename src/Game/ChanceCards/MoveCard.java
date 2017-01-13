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
    private boolean absolutePos;

    public MoveCard(String description, int moveAmount, boolean absolutePos) {
        super(description);
        this.moveAmount = moveAmount;
        this.absolutePos = absolutePos;
    }

    @Override
    public void action(Player user) {
        GameController.getGameBoard().movePlayer(user, moveAmount, absolutePos);
        GameController.getGameBoard().getField(user.getOnField()).landOnField(user);
    }

    @Override
    public String toString() {
        return "MoveCard{" +
                "moveAmount=" + moveAmount +
                ", absolutePos=" + absolutePos +
                '}';
    }
}
