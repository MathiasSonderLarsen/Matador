package Game.Fields;


import Game.GameController;
import desktop_fields.Shipping;
import desktop_fields.Shipping.Builder;

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

    public Fleet(String name, int groupID, Color color, int price, int[] rentArray) {

        super(name, groupID, color, price);
        this.rentArray = rentArray;


    }


    @Override
    public int getRent() {

        switch (GameController.getGameBoard().getNumberOfPropertiesInGroup(getGroupID())) {
            case 1:
                return this.rentArray[0];
            case 2:
                return this.rentArray[1];
            case 3:
                return this.rentArray[2];
            case 4:
                return this.rentArray[3];
            default:
                return 0; //Should never happen
        }
    }

    @Override
    public Shipping convertToGUI() {
        Builder a = new Builder()
                .setTitle(this.name)
                .setFgColor(Color.black)
                .setBgColor(this.color)
                .setSubText(this.price + "");
        return a.build();
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "rentArray=" + Arrays.toString(this.rentArray) +
                '}';
    }
}
