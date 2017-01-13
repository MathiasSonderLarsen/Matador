package Game.Fields;


import Game.BoundaryController;
import Game.GameController;
import Game.Language;
import Game.Player;

import java.awt.*;
import java.util.Arrays;

/**
 * Keeps track of the rent, price, name, groupID and houseprice of the territories
 * <p>
 * Bugs: None known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.2
 */

public class Territory extends Ownable {

    private int[] rentArray;
    private int numOfHouses = 0;
    private int housePrice;

    public Territory(String name, int groupID, Color color, int price, int[] rentArray, int housePrice) {
        super(name, groupID, color, price);

        this.rentArray = rentArray;
        this.housePrice = housePrice;
    }

    /**
     * Getter for property 'housePrice'.
     *
     * @return Value for property 'housePrice'.
     */
    public int getHousePrice() {
        return housePrice;
    }

    /** {@inheritDoc} */
    public int getRent() {

        switch (numOfHouses) {

            case 0:
                if ( GameController.getGameBoard().playerOwnsAllInGroup(this, owner)) {
                    return rentArray[0]*2;
                }else {
                    return rentArray[0];
                }
            case 1:
                return rentArray[1];

            case 2:
                return rentArray[2];

            case 3:
                return rentArray[3];

            case 4:
                return rentArray[4];

            case 5:
                return rentArray[5];

            default:
                System.out.println("Should not happen");
                return 0;
        }

    }

    /**
     * Getter for property 'numOfHouses'.
     *
     * @return Value for property 'numOfHouses'.
     */
    public int getNumOfHouses() {
        return this.numOfHouses;
    }

    /**
     * Setter for property 'numOfHouses'.
     *
     * @param number Value to set for property 'numOfHouses'.
     */
    public void setNumOfHouses(int number) {
        this.numOfHouses = number;

        int fieldNumber = GameController.getGameBoard().getFieldPos(this);
        if (number < 5) {
            BoundaryController.buyHouse(fieldNumber, number);
        } else {
            BoundaryController.setHotel(fieldNumber, true);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void landOnField(Player player) {
        super.landOnField(player);


        if (GameController.getGameBoard().playerOwnsAllInGroup(this, player) && GameController.getGameBoard().houseAvailable(this.groupID)) {

            String[] stringOfBuyableFieldOptions;
            while (player.getBalance() > housePrice) {
                stringOfBuyableFieldOptions = GameController.getGameBoard().getStringOfBuyableFieldOptions(groupID);
                stringOfBuyableFieldOptions[stringOfBuyableFieldOptions.length - 1] = Language.getString("stop");

                // Defines the question and answers for whether of not you wants to buy a house
                //output "do 'player' want to buy a house for 'x' points"
                String question = player.getName() + (Language.getString("buyhouse")
                        + " " + Language.getString("buy2") + " "
                        + housePrice + " " + Language.getString("point") + " ?"); // TODO: 09-01-2017 Fix string.

                String answer1 = Language.getString("no");
                String answer2 = Language.getString("yes");

                // Prompts the user with the question of whether o not he wants to buy a house
                String inputAnswer = BoundaryController.getUserButtonPressed(question, answer1, answer2);

                if (inputAnswer == answer2) {
                    question = Language.getString("where");
                    inputAnswer = BoundaryController.getUserButtonPressed(question, stringOfBuyableFieldOptions);

                    Field[] fieldsInGroup = GameController.getGameBoard().getFieldsInGroup(groupID);
                    for (Field currentField : fieldsInGroup) {
                        Territory currentTerritory = (Territory) currentField;
                        if (currentTerritory.getName().equals(inputAnswer)) {
                            currentTerritory.setNumOfHouses(currentTerritory.getNumOfHouses() + 1);
                            player.addBalance(-currentTerritory.getHousePrice());
                            System.out.println(currentTerritory.getNumOfHouses());
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    /** {@inheritDoc} */
    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText(price + "");
        return a.build();
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Territory{" +
                "rentArray=" + Arrays.toString(rentArray) +
                ", numOfHouses=" + numOfHouses +
                ", housePrice=" + housePrice +
                '}';
    }
}