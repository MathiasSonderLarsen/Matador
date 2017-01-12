package Game.Fields;


import java.awt.*;

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
    private final int[] rentArray;

    public Fleet(String name, int groupID, int price, int[] rentArray) {

        super(name, groupID, price);
        this.rentArray = rentArray;


    }


    public int getRent() {

        switch (Game.GameController.getGameBoard().getNumberOfPropertiesInGroup(this.getGroupID())) {
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

    public desktop_fields.Shipping convertToGUI() {
        desktop_fields.Shipping.Builder a = new desktop_fields.Shipping.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText(getPrice() + "");
        return a.build();
    }

}
