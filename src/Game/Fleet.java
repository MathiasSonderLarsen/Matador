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
 * @version v.0.5
 */

public class Fleet extends Ownable {

    //Declares an array of integers
    private final int[] rentArray = new int[]{500,1000,2000,4000};


    public Fleet(String name, int price, int groupID) {

        super(name, price, groupID);

    }


    public int getRent() {

        switch (GameController.getGameBoard().getNoOfFleetsOwned(this.getOwner())) {
            case 1:
                return rentArray[0];
            case 2:
                return rentArray[1];
            case 3:
                return rentArray[2];
            case 4:
                return rentArray[3];
            default:
                return 0; //Should never happen
        }
    }

}
