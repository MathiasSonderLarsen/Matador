package Game.ChanceCards;

import Game.Fields.Fleet;
import Game.GameBoard;
import Game.Player;
import Game.GameController;

import java.util.ArrayList;

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

    @Override
    public void action(Player user) {
    //    GameBoard gameboard = GameController.getGameBoard();
    //    int distNextFleet=0;
    //
    //
    //    for (int i=0; i < gameboard.getBoard().length ; i++){
    //        if(gameboard.getField(i) instanceof Fleet){
    //
    //            int nearestFleet=GameBoard.calStepsToMove(user, gameboard.getFieldPos(gameboard.getField(i)), false);
    //            if( distNextFleet < nearestFleet && distNextFleet != 0) {
    //                distNextFleet = nearestFleet;
    //            }
    //        }
    //    }
    //    GameBoard.movePlayer(user,distNextFleet, false);
    }
}
