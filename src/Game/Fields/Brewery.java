package Game.Fields;



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

    Game.GameBoard gameBoard;
    int baseRent;


    public Brewery(String name, int price, int baseRent, int groupID) {

        super(name, price, groupID);
        this.baseRent = baseRent;

    }


    public int getRent(Game.Player player) {

        // receive gameboard object from GameController
        gameBoard = Game.GameController.getGameBoard();

        Ownable otherField;

        if (this == gameBoard.getField(13)) {

            otherField = (Ownable) gameBoard.getField(13);

        } else {

            otherField = (Ownable) gameBoard.getField(29);
        }

        if (this.getOwner().equals(otherField.getOwner())) {

            baseRent = Game.GameController.getShaker().getSum() * 200;

        } else {

            baseRent = Game.GameController.getShaker().getSum() * 100;
        }

        return baseRent;
    }


    @Override
    public int getRent() {
        return 0;
    }
}



