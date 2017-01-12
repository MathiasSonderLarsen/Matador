package Game.Fields;


import java.awt.*;
import java.util.Arrays;

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

    public Fleet(String name, int groupID , Color color, int price, int[] rentArray) {

        super(name, groupID, color, price);
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
                .setTitle(name)
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText(price + "");
        return a.build();
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "rentArray=" + Arrays.toString(rentArray) +
                '}';
    }
}
