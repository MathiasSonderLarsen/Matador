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
        // Defined as the number of propeties in the group you stand in
        int numberOfPropertiesInGroup = GameController.getGameBoard().getNumberOfPropertiesInGroup(groupID);

        // If you own every lot in the group
        if (GameController.getGameBoard().playerOwnsAllInGroup(player, groupID) && !GameController.getGameBoard().playerOwensAllInGroup(this)) {

            // Defines the question and answers for whether of not you wants to buy a house
            final String question = player.getName() + (Language.getString("buyhouse")
                    + " " + getName() + " " + Language.getString("buy2") + " "
                    + housePrice + " " + Language.getString("point") + " ?"); // TODO: 09-01-2017 Fix string. 

            final String answer1 = Language.getString("no");
            final String answer2 = Language.getString("yes");

            // Runs a do-while loop as long as you want to buy a house
            // and don't have a hotel on all lots in the group
            boolean buyMode = true;
            do {
                if (GameController.getGameBoard().houseAvailable(groupID)){
                    break;
                }
                // Prompts the user with the question of whether o not he wants to buy a house
                String inputAnswer = BoundaryController.getUserButtonPressed(question, answer1, answer2);

                // If the user answers "Yes"
                if (inputAnswer == answer2) {




                    ArrayList<Territory> listOfBuyableHouseOptions = GameController.getGameBoard().getListOfBuyableHouseOptions(GameController.getGameBoard().getFieldsInGroup(getGroupID()));
                    // Defined as the house the user picks
                    String answer = BoundaryController.getUserButtonPressed(question, GameController.getGameBoard().getStringOfBuyableFieldOptions(listOfBuyableHouseOptions));

                    // Finds the house the user picked and adds a house/hotel
                    for (Territory theTerritory : listOfBuyableHouseOptions) {
                        if (answer == theTerritory.getName()) {

                            int fieldNumber = GameController.getGameBoard().getFieldPos(theTerritory);
                            if (theTerritory.getNumOfHouses() < 4) {
                                int numberOfHouseToSet = theTerritory.getNumOfHouses() + 1;
                                theTerritory.setNumOfHouses(numberOfHouseToSet);
                                BoundaryController.buyHouse(fieldNumber, numberOfHouseToSet);
                            } else {
                                theTerritory.setNumOfHouses(5);
                                BoundaryController.setHotel(fieldNumber, true);
                            }

                            BoundaryController.showMessage(player.getName() + " " + Language.getString("bought") + " "
                                    + Language.getString("house1") + theTerritory.getName());
                        }


                    }


                }

                if (inputAnswer == answer1) {
                    buyMode = false;
                }

            } while (buyMode);
        }

    }
    // Returns the number of lots that has hotels
//    private boolean allLotsInGroupHasHotel(int groupID) {
//        boolean out = false;
//        Field[] fieldsInGroup = GameController.getGameBoard().getFieldsInGroup(groupID);
//        Territory[] territories = new Territory[fieldsInGroup.length];
//        for (int i = 0; i < fieldsInGroup.length; i++) {
//            territories[i] = (Territory) fieldsInGroup[i];
//        }
//
//
//        return countTerritoriesWithXHouses(territories, 5) == GameController.getGameBoard().getNumberOfPropertiesInGroup(groupID);
//
//    }
    // Returns string array of available options of lots you can build a house/hotel on
    private String[] getListOfBuyableFields(Territory[] houseBuyableFields, int minNumber, int numOptions) {
        String[] stringArray = new String[numOptions];
        int i = 0;
        for (Territory theTerritory : houseBuyableFields) {
            if (theTerritory.getNumOfHouses() == minNumber) {
                stringArray[i] = theTerritory.getName();
                i++;
            }

        }
        return stringArray;
    }


    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.blue)
                .setSubText(getPrice() + "");
        return a.build();
    }

}