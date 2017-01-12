package Game.Fields;


import Game.*;

import java.awt.*;
import java.util.ArrayList;

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

    public Territory(String name, int price, int[] rentArray, int groupID, int housePrice) {
        super(name, price, groupID);

        this.rentArray = rentArray;
        this.housePrice = housePrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getRent() {

        switch (numOfHouses) {

            case 0:
                return rentArray[0];

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

    public int getNumOfHouses() {
        return this.numOfHouses;
    }

    public void setNumOfHouses(int number) {
        this.numOfHouses = number;
    }

    @Override
    public void landOnField(Player player) {
        super.landOnField(player);


        if (GameController.getGameBoard().playerOwensAllInGroup(this, player) && GameController.getGameBoard().houseAvailable(this.groupID)) {

            String[] stringOfBuyableFieldOptions;
            while (player.getBalance() > this.getHousePrice()) {
                stringOfBuyableFieldOptions = GameController.getGameBoard().getStringOfBuyableFieldOptions(this.getGroupID());
                stringOfBuyableFieldOptions[stringOfBuyableFieldOptions.length-1] = Language.getString("stop");

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
                }
                else break;
            }
        }
    }

    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.blue)
                .setSubText(getPrice() + "");
        return a.build();
    }

}