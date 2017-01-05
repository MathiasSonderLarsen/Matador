package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.4
 */

public class Fleet extends Ownable {

    private final int[] rent = {500, 1000, 2000, 4000};

    public Fleet(int number, String name, int price) {

        super(number, name, price);

    }


    public int getRent() {
        switch (GameController.getGameBoard().getNoOfFleetsOwned(this.getOwner())) {
            case 1:
                return rent[0];
            case 2:
                return rent[1];
            case 3:
                return rent[2];
            case 4:
                return rent[3];
            default:
                return 0; //Should never happen
        }
    }

}
