package Game.Fields;


import Game.*;

import java.awt.*;

/**
 * Keeps track of the rent, price, name, groupID and houseprice of the territories
 * <p>
 * Bugs: Kan ikke købe 2 huse efter hindanden
 *       Kan købe mere end 2 huse på en plads in en gruppe der har en minimum af 0
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
    private boolean buyMode;

    public Territory(String name, int price, int[] rentArray, int groupID, int housePrice) {
        super(name, price, groupID);

        this.rentArray = rentArray;
        this.housePrice = housePrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getRent() {

        switch (numOfHouses){

            case 0: return rentArray[0];

            case 1: return rentArray[1];

            case 2: return rentArray[2];

            case 3: return rentArray[3];

            case 4: return rentArray[4];

            case 5: return rentArray[5];

            default: System.out.println("Should not happen");
            return 0;
        }

    }

    public void setNumOfHouses(int number){
        this.numOfHouses = number;
    }

    public int getNumOfHouses(){
        return this.numOfHouses;
    }

    @Override
    public void landOnField(Player player){
        super.landOnField(player);

        //køb huse
        int groupID = this.getGroupID();
        int houseNumber;
        int fieldNumber;
        Territory[] houseBuyableFields;

        int numberOfPropertiesOwnedInGroup = GameController.getGameBoard().getNumInGroupOwned(player, groupID);
        int numberOfPropertiesInGroup = GameController.getGameBoard().getNumberOfPropertiesInGroup(groupID);



        // If you own every lot in the group
        if(numberOfPropertiesOwnedInGroup == numberOfPropertiesInGroup){


            final String question, answer1, answer2;
            buyMode = true;

            question = player.getName() + (Language.getString("buyhouse")
                    + " " + getName() + " " + Language.getString("buy2") + " "
                    + housePrice + " " + Language.getString("point") + " ?");

            answer1 = Language.getString("no");
            answer2 = Language.getString("yes");



            do {


                String inputAnswer = BoundaryController.getUserButtonPressed(question, answer1, answer2);

                // Happens if the player wants to buy house
                if (inputAnswer == answer2) {

                    int minimum = 6;
                    int number = 0;
                    String[] stringArray;
                    houseBuyableFields = GameController.getGameBoard().getBuyableArray(groupID, numberOfPropertiesInGroup);


                    for(int i = 0; i < numberOfPropertiesInGroup; i++) {
                        int numberOfHouseOnField = houseBuyableFields[i].getNumOfHouses();

                        // Find the minimum number of houses on the fields with same groupID
                        if (numberOfHouseOnField < minimum) {
                            minimum = houseBuyableFields[i].getNumOfHouses();

                        }
                    }
                    
                    for(int i = 0; i < numberOfPropertiesInGroup; i++){

                        int numberOfHouseOnField = houseBuyableFields[i].getNumOfHouses();

                        // Finds the number of fields with same minimum of houses
                        if(numberOfHouseOnField == minimum){

                            number++;

                        }

                    }

                    stringArray = new String[number];

                    for(int j = 0; j < number; j++ ){
                        stringArray[j] = houseBuyableFields[j].getName();
                    }

                    String answer = BoundaryController.getUserButtonPressed(question, stringArray);

                    for(int i = 0; i < numberOfPropertiesInGroup; i++){

                        if(answer == houseBuyableFields[i].getName()){

                            fieldNumber = GameController.getGameBoard().getFieldPos(houseBuyableFields[i]);

                            BoundaryController.buyHouse(fieldNumber, 1);
                            int numberOfHouseToSet = houseBuyableFields[i].getNumOfHouses() + 1;
                            houseBuyableFields[i].setNumOfHouses(numberOfHouseToSet);

                            BoundaryController.showMessage(player.getName() + " " + Language.getString("bought") + " "
                                    + Language.getString("house1") + houseBuyableFields[i].getName());
                        }
                        break;

                    }

                }

                if(inputAnswer == answer1){
                    buyMode = false;
                }

            }while(buyMode);

        }

    }

    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.blue)
                .setSubText(getPrice()+"");
        return a.build();
    }

}