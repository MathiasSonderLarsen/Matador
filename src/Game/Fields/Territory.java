package Game.Fields;


import java.awt.*;

/**
 * Keeps track of the rent, price, name, groupID and houseprice of the territories
 * <p>
 * Bugs: none known
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
    private int numOfHouses;
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
        numOfHouses = number;
    }

    public int getNumOfHouses(){
        return numOfHouses;
    }


    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setFgColor(Color.blue)
                .setSubText(getPrice()+"");
        return a.build();
    }

}