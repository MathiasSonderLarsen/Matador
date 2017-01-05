package Game;

import desktop_fields.Ownable;

/**
 * Brewery field: Keeps track on the rent of the field.
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
public class Brewery extends Ownable {

    GameBoard gameBoard;
    Field otherField;
    int baseRent;


    public Brewery(String name, int price, int baseRent, int groupID) {

        super(name, price, baseRent, groupID);


    }


    public int getRent(Player player) {

        // receive gameboard object from GameController
        gameBoard = getGameBoard();

        if(this == gameBoard.getField(13)){

          otherField = gameBoard.getField(13);

        } else {

          otherField = gameBoard.getField(29);
        }

        if (this.getOwner().equals(otherField.getOwner())) {

            baseRent = gameBoard.getSum() * 200;

        } else {

            baseRent = gameBoard.getSum() * 100;
        }

        return baseRent;
    }


}



