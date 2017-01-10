package Game.Fields;


import Game.BoundaryController;
import Game.GameController;
import Game.Language;
import Game.Player;

import java.awt.*;

/**
 * Keeps track of the rent, price, name, groupID and houseprice of the territories
 * <p>
 * Bugs: Kan ikke købe 2 huse efter hindanden
 * Kan købe mere end 2 huse på en plads in en gruppe der har en minimum af 0
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
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

        //køb huse

        int numberOfPropertiesInGroup = GameController.getGameBoard().getNumberOfPropertiesInGroup(groupID);


        // If you own every lot in the group
        if (GameController.getGameBoard().playerOwnsAllInGroup(player, groupID) && !allHousesInGroupHasHotel(groupID)) {


            final String question = player.getName() + (Language.getString("buyhouse")
                    + " " + getName() + " " + Language.getString("buy2") + " "
                    + housePrice + " " + Language.getString("point") + " ?"); // TODO: 09-01-2017 Fix string. 

            final String answer1 = Language.getString("no");
            final String answer2 = Language.getString("yes");


            boolean buyMode = true;
            do {
                if (allHousesInGroupHasHotel(groupID)){
                    break;
                }

                String inputAnswer = BoundaryController.getUserButtonPressed(question, answer1, answer2);

                if (inputAnswer == answer2) {

                    Territory[] houseBuyableFields = GameController.getGameBoard().getBuyableArray(groupID, numberOfPropertiesInGroup);


                    int minNumber = getMinHouses(houseBuyableFields);

                    int numOptions = countTerritoriesWithXHouses(houseBuyableFields, minNumber);

                    String[] listOfBuyableFieldOptions = getListOfBuyableFields(houseBuyableFields, minNumber, numOptions);

                    String answer = BoundaryController.getUserButtonPressed(question, listOfBuyableFieldOptions);


                    for (Territory theTerritory : houseBuyableFields) {
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

    private boolean allHousesInGroupHasHotel(int groupID) {
        boolean out = false;
        Field[] fieldsInGroup = GameController.getGameBoard().getFieldsInGroup(groupID);
        Territory[] territories = new Territory[fieldsInGroup.length];
        for (int i = 0; i < fieldsInGroup.length; i++) {
            territories[i] = (Territory) fieldsInGroup[i];
        }


        return countTerritoriesWithXHouses(territories, 5) == GameController.getGameBoard().getNumberOfPropertiesInGroup(groupID);

    }

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

    private int countTerritoriesWithXHouses(Territory[] houseBuyableFields, int minNumber) {
        int number = 0;
        for (Territory theTerritory : houseBuyableFields) {
            if (theTerritory.getNumOfHouses() == minNumber) {

                number++;
            }
        }
        return number;
    }

    private int getMinHouses(Territory[] houseBuyableFields) {
        int minNumber = Integer.MAX_VALUE;
        for (Territory theTerritory : houseBuyableFields) {
            if (theTerritory.getNumOfHouses() < minNumber) {
                minNumber = theTerritory.getNumOfHouses();
            }
        }
        return minNumber;
    }

    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.blue)
                .setSubText(getPrice() + "");
        return a.build();
    }

}