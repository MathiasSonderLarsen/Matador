package Game.ChanceCards;

import Game.Fields.Fleet;
import Game.GameBoard;
import Game.GameController;
import Game.Player;

/**
 * GoToNearestFleet does moves the player to the nearest fleet when the card is drawn.
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
public class GoToNearestFleet extends ChanceCard {
    public GoToNearestFleet(String description) {
        super(description);
    }

    /** {@inheritDoc} */
    @Override
    public void action(Player user) {
            GameBoard gameboard = GameController.getGameBoard();
            int distNextFleet=0;



            for (int i=1; i <= gameboard.getBoard().length ; i++){
                if(gameboard.getField(i) instanceof Fleet){

                    int nearestFleet=gameboard.calStepsToMove(user, i);
                    if( distNextFleet < nearestFleet && distNextFleet != 0) {
                        distNextFleet = nearestFleet;
                    }
                }
            }
            gameboard.movePlayer(user,distNextFleet, false);
    }
}
