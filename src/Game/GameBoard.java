package Game;

import Game.Fields.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * GameBoard encapsulates all the Fields used in the game
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class GameBoard {

    private final int maxHouses = 32;
    private final int maxHotels = 12;
    private final Field[] board;
    private int numberOfFields;
    private Shaker shaker;

    /**
     * The constructor of the class GameBoard
     *
     * @param number The number of fields we want on the board
     */
    public GameBoard(int number, Shaker shaker) {

        numberOfFields = number;
        this.shaker = shaker;

        //board = new Field[numberOfFields];
        board = loadBoardFromFile("board.cfg");
        BoundaryController.showOnGui(board);


    }

    public Field[] getBoard() {
        return board;
    }

    public  Shaker getShaker() {
        return shaker;
    }

    /**
     * Creates field objects from a properties file, converted through Gson.
     *
     * @param fileName Name of the ressource file
     * @return
     */
    public Field[] loadBoardFromFile(String fileName) {

        try {
            Gson g = new Gson();

            Field[] loadedFields = new Field[40];

            Path relativePath = Paths.get(fileName);
            String absolutePath = relativePath.toAbsolutePath().toString();

            BufferedReader fileReader = new BufferedReader(new FileReader(absolutePath));

            String line;
            int i = 0;
            while ((line = fileReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                loadedFields[i] = g.fromJson(lineSplit[1], (Type) Class.forName("Game.Fields." + lineSplit[0]));
                i++;

            }

            fileReader.close();

            return loadedFields;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;// only happens if there was an error
    }


    /**
     * Gets the field object of an index on the board
     *
     * @param num the position on the board from 1
     * @return the field object
     */
    public Field getField(int num) {
        if (num <= board.length) {
            return board[num - 1];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Gets the amount of fleets owned by a specific player
     *
     * @param player the player
     * @return the amount of fleets the player currently owns
     */
    public int getNumInGroupOwned(Player player, int groupID) {
        int num = 0;

        for (Field theField : board) {
            if ((theField instanceof Ownable) && ((Ownable) theField).getGroupID() == groupID) {
                if (((Ownable) theField).getOwner() == player) {
                    num++;
                }
            }


        }

        return num;
    }

    public int getNumberOfPropertiesInGroup(int groupID) {
        int num = 0;

        for (Field theField : board) {
            if (theField.getGroupID() == groupID) {
                num++;
            }
        }
        return num;
    }

    public void deleteOwnership(Player player) {

        for (Field theField : board) {
            if (theField instanceof Ownable) {
                if (((Ownable) theField).getOwner() == player) {
                    ((Ownable) theField).removeOwner();
                }
            }
        }


    }

    public boolean playerOwnsAllInGroup(Player player, int groupID) {
        if (getNumberOfPropertiesInGroup(groupID) == getNumInGroupOwned(player, groupID))
            return true;
        else {
            return false;
        }
    }

    public int getFieldPos(Field fieldToFind) {

        int i = 0;
        for (i = 0; i < board.length; i++) {
            if (fieldToFind == board[i]) {
                break;
            }
        }
        return i+1;
    }

    public Territory[] getBuyableArray(int groupID) {

        Territory[] houseBuyableFields = new Territory[getFieldsInGroup(groupID).length];
        int j = 0;

        for (int i = 1; i <= 40; i++) {

            if(getField(i) instanceof Territory && getField(i).getGroupID() == groupID){
                houseBuyableFields[j] = (Territory) getField(i);
                j++;
            }
        }
        return houseBuyableFields;
    }

    public Field[] getFieldsInGroup(int groupID) {

        Field[] fields = new Field[getNumberOfPropertiesInGroup(groupID)];
        int i = 0;
        for (Field theField : board) {
            if (theField.getGroupID() == groupID) {
                fields[i] = theField;
                i++;
            }
        }
        return fields;
    }

    public int calStepsToMove(Player thisPlayer, int fieldNum){
        int stepsToMove = fieldNum - thisPlayer.getOnField();

        if(stepsToMove <= 0) {
            stepsToMove = stepsToMove + 40;
        }

        return stepsToMove;
    }



    public  void movePlayer(Player thisPlayer, int stepsToMove, boolean absolute) {

        if(absolute == true){
            stepsToMove = calStepsToMove(thisPlayer, stepsToMove);
        }

        if(stepsToMove > 0) {
            for (int i = 0; i < stepsToMove; i++) {
                //stores the players location on the gameBoard
                if (thisPlayer.getOnField() + 1 > numberOfFields) {
                    thisPlayer.setOnField(1);
                    if (Jail.isJailed(thisPlayer) == false) {
                        thisPlayer.addBalance(Start.getStartBonus());
                    }
                } else {
                    thisPlayer.setOnField(thisPlayer.getOnField() + 1);
                }
                BoundaryController.removeAllCars(thisPlayer.getName());
                BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());
            }
        }
        else {
            for (int i = 0; i > stepsToMove; i--) {
                thisPlayer.setOnField(thisPlayer.getOnField() - 1);

                BoundaryController.removeAllCars(thisPlayer.getName());
                BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());
            }
        }
    }

    /**
     *
     * @param fieldType
     * @return the number of fields of a certain type in the gameboard
     */
    public int getNumOfFieldsOfTypeX(Class<?> fieldType){
        int numOfFieldOfTypeX = 0;

        for(int i=0; i < board.length; i++){
            if(board.getClass() == fieldType){
                numOfFieldOfTypeX++;
            }
        }
        return numOfFieldOfTypeX;
    }

    /**
     *
     * @param fieldType
     * @return a field array containing all fields of a certain type
     */
    public Field[] getArrayOfFieldsByType(Class<?> fieldType){
        int numOfFields = getNumOfFieldsOfTypeX(fieldType);
        Field[] arrayOfFieldByType = new Field[numOfFields];
        int arrayIndex=0;
        for(int i = 0; i < board.length; i++){
            if(getField(i).getClass() == fieldType){
                arrayOfFieldByType[arrayIndex] = getField(i);
                arrayIndex++;
            }
        }
        return arrayOfFieldByType;
    }


    /**
     *
     * @param groupID
     * @return the minimum number of houses in a group
     */
    public int getLowestNumOfHousesOnFieldsInThisGroup(int groupID){
        Field[] fieldsInGroup = getFieldsInGroup(groupID);
        int lovesNumOfHousesOnFieldsInThisGroup = 5;
        for(Field currentField : fieldsInGroup){
            Territory currentTerritory = (Territory) currentField;
            if(currentTerritory.getNumOfHouses() < lovesNumOfHousesOnFieldsInThisGroup)
                lovesNumOfHousesOnFieldsInThisGroup = currentTerritory.getNumOfHouses();
        }
        return lovesNumOfHousesOnFieldsInThisGroup;
    }

    /**
     *
     * @param groupID
     * @return the maximum number of houses on fields in a group
     */
    public int getHigestNumOfHousesOnFieldsInThisGroup(int groupID){
        Field[] fieldsInGroup = getFieldsInGroup(groupID);
        int highestNumOfHousesOnFieldsInThisGroup = 0;
        for(Field currentField : fieldsInGroup){
            Territory currentTerritory = (Territory) currentField;
            if(currentTerritory.getNumOfHouses() > highestNumOfHousesOnFieldsInThisGroup)
                highestNumOfHousesOnFieldsInThisGroup = currentTerritory.getNumOfHouses();
        }
        return highestNumOfHousesOnFieldsInThisGroup;
    }

    /**
     *
     * @param player
     * @return ArrayList of fields with houses or hotels owend by a player
     */
    public ArrayList<Territory> getListOfTerritoriesWithHousesByPlayer(Player player){
        ArrayList<Territory> territoriesWithHousesByPlayer = new ArrayList<>();

        Territory[] allTerritories = (Territory[]) getArrayOfFieldsByType(Territory.class);
        for (Territory currentTerritory: allTerritories) {
            if(currentTerritory.getOwner() == player && currentTerritory.getNumOfHouses() > 0){
                territoriesWithHousesByPlayer.add(currentTerritory);
            }
        }
        return territoriesWithHousesByPlayer;
    }

    /**
     *
     * @param player
     * @return ArrayList of fields where the player can sell a house or hotel. houses and hotels have to bee disturbed evenly on all fields in group.
     */
    public ArrayList<String> getSellableHouseList(Player player){

        ArrayList<Territory> listOfterritoriesWithHousesByPlayer = getListOfTerritoriesWithHousesByPlayer(player);
        ArrayList<String> sellableHouseList = new ArrayList<>();
        for (Territory currentTerritory:listOfterritoriesWithHousesByPlayer) {
            if(currentTerritory.getNumOfHouses() == getHigestNumOfHousesOnFieldsInThisGroup(currentTerritory.getGroupID())){
                sellableHouseList.add(currentTerritory.getName());
            }
        }

        return sellableHouseList;
    }


    public boolean playerOwensAllInGroup(Territory territory){
        int groupID = territory.getGroupID();
            if(getNumInGroupOwned(territory.getOwner(), groupID) == getNumberOfPropertiesInGroup(groupID)){
                return true;
            }
        return false;
    }
    /**
     *
     * @param territory
     * @return true if the player can buy a house og hotel on the territory in question.
     * needs to own all fields in group and houses have to bee disturbed evenly on all fields in group.
     */
    public boolean canBuyHouse(Territory territory){
        int groupID = territory.getGroupID();
        boolean owensAllInGroup = false;
        if(getNumInGroupOwned(territory.getOwner(), groupID) == getNumberOfPropertiesInGroup(groupID)){
            owensAllInGroup = true;
        }
        int lowestNumHouses = getLowestNumOfHousesOnFieldsInThisGroup(groupID);
        if(territory.getNumOfHouses() == lowestNumHouses){
            return true;
        }
        return false;
    }

    /**
     *
     * @param fieldArray
     * @return ArrayList of territories where the player can buy houses og hotels. only in the group the player have just landet on
     */
    public ArrayList<Territory> getListOfBuyableHouseOptions(Field[] fieldArray){
        Territory[] territoryArray = ((Territory[]) fieldArray);
        ArrayList<Territory> listOfBuyableFieldOptions = new ArrayList<>();
        for (Territory currentTerritory: territoryArray) {
            if(canBuyHouse(currentTerritory)){
               listOfBuyableFieldOptions.add(currentTerritory);
            }
        }
        return listOfBuyableFieldOptions;
    }

    public String[] getStringOfBuyableFieldOptions(ArrayList<Territory> listOfBuyableFieldOptions){
        String[] StringOfBuyableFieldOptions = new String[listOfBuyableFieldOptions.size()];
        for (int i = 0; i< listOfBuyableFieldOptions.size(); i++) {
            StringOfBuyableFieldOptions[i] = listOfBuyableFieldOptions.get(i).getName();

        }
        return StringOfBuyableFieldOptions;
    }

    /**
     * checks if there is houses or hotel available according to the max amount.
     * @param groupiD
     * @return boolean
     */
    public boolean houseAvailable(int groupiD){
        Field[] territoryArray = getArrayOfFieldsByType(Territory.class);
        int numOfHouses = 0;
        int numOfHotels = 0;
        for (Field currentField :  territoryArray) {
            Territory currentTerritory = (Territory) currentField;
            if(currentTerritory.getNumOfHouses() == 5){
                numOfHotels++;
            }
            else{
                numOfHouses = numOfHouses + currentTerritory.getNumOfHouses();
            }
        }
        if(numOfHouses < maxHouses && getLowestNumOfHousesOnFieldsInThisGroup(groupiD) < 4){
            return true;
        }
        else if(numOfHotels < maxHotels  && getLowestNumOfHousesOnFieldsInThisGroup(groupiD) == 4){
                return true;
            }
            else {
                return false;
            }

    }


}