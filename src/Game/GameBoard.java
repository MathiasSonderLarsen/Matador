package Game;

import Game.ChanceCards.ChanceDeck;
import Game.Fields.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * GameBoard encapsulates all the Fields used in the game
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.2
 */
public class GameBoard {

    private final Field[] board = new Field[40];
    private final int maxHouses = 32;
    private final int maxHotels = 12;
    private int numberOfFields;
    private Shaker shaker;
    private ChanceDeck chanceDeck;

    /**
     * The constructor of the class GameBoard
     *
     * @param number The number of fields the board has.
     * @param shaker The Shaker the game should use.
     */
    public GameBoard(int number, Shaker shaker) {

        numberOfFields = number;
        this.shaker = shaker;
        chanceDeck = new ChanceDeck();

        board[0] = new Start("Start", 1, Color.red);
        board[1] = new Territory("Rødovervej", 2, Color.blue, 1200, new int[]{50, 250, 750, 2250, 4000, 600}, 1000);
        board[2] = new Chance("Prøv lykken", 3, Color.black);
        board[3] = new Territory("Hvidovervej", 2, Color.blue, 1200, new int[]{50, 250, 750, 2250, 4000, 600}, 1000);
        board[4] = new Tax("Indkomstskat", 4, Color.lightGray, 4000, 0.1f);
        board[5] = new Fleet("Scandlines", 5, Color.gray, 4000, new int[]{500, 1000, 2000, 400});
        board[6] = new Territory("Roskildevej", 6, Color.orange, 2000, new int[]{100, 600, 1800, 5400, 8000, 1100}, 1000);
        board[7] = new Chance("Prøv lykken", 3, Color.black);
        board[8] = new Territory("Valby Langgade", 6, Color.orange, 2000, new int[]{100, 600, 1800, 5400, 8000, 1100}, 1000);
        board[9] = new Territory("Allégade", 6, Color.orange, 2400, new int[]{150, 800, 2000, 6000, 9000, 1200}, 1000);
        board[10] = new Jail("Fængsel", 7, Color.black);
        board[11] = new Territory("Frederiksberg Allé", 8, Color.cyan, 2800, new int[]{200, 1000, 3000, 9000, 12500, 1500}, 2000);
        board[12] = new Brewery("Tuborg", 9, Color.green, 3000, 100);
        board[13] = new Territory("Büowsvej", 8, Color.cyan, 2800, new int[]{200, 1000, 3000, 9000, 12500, 1500}, 2000);
        board[14] = new Territory("Gl. Kongevej", 8, Color.cyan, 3200, new int[]{250, 1250, 3750, 10000, 14000, 1800}, 2000);
        board[15] = new Fleet("Mols-Linien", 5, Color.gray, 4000, new int[]{500, 1000, 2000, 400});
        board[16] = new Territory("Bernstorffsvej", 10, new Color(190, 123, 252), 3600, new int[]{300, 1400, 4000, 11000, 15000, 1900}, 2000);
        board[17] = new Chance("Prøv lykken", 3, Color.black);
        board[18] = new Territory("Hellerupvej", 10, new Color(190, 123, 252), 3600, new int[]{300, 1400, 4000, 11000, 15000, 1900}, 2000);
        board[19] = new Territory("Strandvejen", 10, new Color(190, 123, 252), 4000, new int[]{350, 1600, 4400, 12000, 16000, 2000}, 2000);
        board[20] = new FreeParking("Parkering", 11, Color.pink);
        board[21] = new Territory("Trianglen", 12, Color.red, 4400, new int[]{350, 1899, 5000, 14000, 17500, 2100}, 3000);
        board[22] = new Chance("Prøv lykken", 3, Color.black);
        board[23] = new Territory("Østerbrogade", 12, Color.red, 4400, new int[]{350, 1800, 5000, 14000, 17500, 2100}, 3000);
        board[24] = new Territory("Grønningen", 12, Color.red, 4800, new int[]{400, 2000, 6000, 15000, 18500, 2200}, 3000);
        board[25] = new Fleet("Scandlines", 5, Color.gray, 4000, new int[]{500, 1000, 2000, 400});
        board[26] = new Territory("Bredgade", 13, Color.white, 5200, new int[]{450, 2200, 6600, 16000, 19500, 2300}, 3000);
        board[27] = new Territory("Kgs. Nytorv", 13, Color.white, 5200, new int[]{450, 2200, 6600, 16000, 19500, 2300}, 3000);
        board[28] = new Brewery("CocaCola", 9, Color.green, 3000, 100);
        board[29] = new Territory("Østergade", 13, Color.white, 5600, new int[]{500, 2400, 7200, 17000, 20500, 2400}, 3000);
        board[30] = new GoToJail("De fængsles", 10, Color.black);
        board[31] = new Territory("Amagertorv", 14, Color.yellow, 6000, new int[]{550, 2600, 7800, 18000, 22000, 2500}, 4000);
        board[32] = new Territory("Vimmelskarftet", 14, Color.yellow, 6000, new int[]{550, 2600, 7800, 18000, 22000, 2500}, 4000);
        board[33] = new Chance("Prøv lykken", 3, Color.black);
        board[34] = new Territory("Nygade", 14, Color.yellow, 6400, new int[]{600, 3000, 9000, 2000, 24000, 2800}, 4000);
        board[35] = new Fleet("Scandlines", 5, Color.green, 4000, new int[]{500, 1000, 2000, 400});
        board[36] = new Chance("Prøv lykken", 3, Color.black);
        board[37] = new Territory("Frederiksberg gade", 15, Color.magenta, 7000, new int[]{700, 3500, 1000, 22000, 26000, 3000}, 4000);
        board[38] = new Tax("Indkomstskat", 4, Color.lightGray, 2000, 1.0f);
        board[39] = new Territory("Rådhuspladsen", 15, Color.magenta, 8000, new int[]{1000, 4000, 12000, 28000, 34000, 4000}, 4000);

        BoundaryController.showOnGui(board);
    }

    /**
     * Getter for property 'chanceDeck'.
     *
     * @return Value for property 'chanceDeck'.
     */
    public ChanceDeck getChanceDeck() {
        return chanceDeck;
    }

    /**
     * Getter for property 'shaker'.
     *
     * @return Value for property 'shaker'.
     */
    public Shaker getShaker() {
        return shaker;
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
     * Getter for property 'board'.
     *
     * @return Value for property 'board'.
     */
    public Field[] getBoard() {
        return board;
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

    /**
     * Get the number of fields a specific group has.
     *
     * @param groupID The ID of the group.
     * @return the number of fields in the group.
     */
    public int getNumberOfPropertiesInGroup(int groupID) {
        int num = 0;

        for (Field theField : board) {
            if (theField.getGroupID() == groupID) {
                num++;
            }
        }
        return num;
    }

    /**
     * Deletes the ownership of all fields owned by the player.
     *
     * @param player The player that should loose owner status of all fields.
     */
    public void deleteOwnership(Player player) {

        for (Field theField : board) {
            if (theField instanceof Ownable) {
                if (((Ownable) theField).getOwner() == player) {
                    ((Ownable) theField).removeOwner();
                }
            }
        }
    }

    /**
     * Get the position of any field on the Board.
     *
     * @param fieldToFind The field we want the position of.
     * @return The position of the field on the board.
     */
    public int getFieldPos(Field fieldToFind) {

        for (int i = 0; i < board.length; i++) {
            if (Objects.equals(fieldToFind, board[i])) {
                return i + 1;
            }
        }

        return 0;
    }

    /**
     * Gets the fields in the group.
     *
     * @param groupID The group the fields should be a part of.
     * @return The array of fields in the group.
     */
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

    /**
     * Calculates how many steps the player should move to get to a field position.
     *
     * @param thisPlayer The player we need to use as reference.
     * @param fieldNum   The field to move to.
     * @return
     */
    public int calStepsToMove(Player thisPlayer, int fieldNum) {
        int stepsToMove = fieldNum - thisPlayer.getOnField();

        if (stepsToMove <= 0) {
            stepsToMove = stepsToMove + 40;
        }

        return stepsToMove;
    }


    /**
     * Moves the player to a given position either relative or absolute.
     *
     * @param thisPlayer  The player that should be moved.
     * @param stepsToMove The amount to move.
     * @param absolute    If true, the player moves to a specific field number.
     *                    If false the player moves relative to where he is now.
     */
    public void movePlayer(Player thisPlayer, int stepsToMove, boolean absolute) {

        if (absolute == true) {
            stepsToMove = calStepsToMove(thisPlayer, stepsToMove);
        }

        if (stepsToMove > 0) {
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
        } else {
            // TODO: 13-01-2017 Program crashes when you try to move from the first chance field and 3 steps back.
            for (int i = 0; i > stepsToMove; i--) {
                thisPlayer.setOnField(thisPlayer.getOnField() - 1);

                BoundaryController.removeAllCars(thisPlayer.getName());
                BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());
            }
        }
    }

    /**
     * Hom many fields of a given type exist on the board.
     * @param fieldType The type of field to count.
     * @return The number of fields of a certain type in the gameboard.
     */
    public int getNumOfFieldsOfTypeX(Class<?> fieldType) {
        int numOfFieldOfTypeX = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i].getClass() == fieldType) {
                numOfFieldOfTypeX++;
            }
        }
        return numOfFieldOfTypeX;
    }

    /**
     * Get the amount of Houses and hotels owned by a player on the board.
     * @param user The owner to check.
     * @return Array of houses and hotels in the format: [houses, hotels]
     */
    public int[] getNumberOfOwnedHH(Player user) {
        int houses = 0;
        int hotels = 0;
        for (Field theField : board) {
            if (theField instanceof Territory) {
                int count = ((Territory) theField).getNumOfHouses();

                if (count >= 6) {
                    hotels++;
                } else {
                    houses += count;
                }

            }
        }
        return new int[]{houses, hotels};
    }

    /**
     * Gets an array of the fields of a given type on the board.
     * @param fieldType The type of fields to find.
     * @return A field array containing all fields of a certain type
     */
    public Field[] getArrayOfFieldsByType(Class<?> fieldType) {
        int numOfFields = getNumOfFieldsOfTypeX(fieldType);
        Field[] arrayOfFieldByType = new Field[numOfFields];
        int arrayIndex = 0;
        for (int i = 1; i <= board.length; i++) {
            if (getField(i).getClass() == fieldType) {
                arrayOfFieldByType[arrayIndex] = getField(i);
                arrayIndex++;
            }
        }
        return arrayOfFieldByType;
    }

    /**
     * Gets the number of owned fields by a specific player on the board.
     * @param player The owner of the fields.
     * @return The number of fields owned by the player on the board.
     */
    public int getNumOfOwnedFields(Player player) {
        int num = 0;
        for (Field theField : board) {
            if (theField instanceof Ownable) {
                if (Objects.equals(((Ownable) theField).getOwner(), player)) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GameBoard{" +
                "board=" + Arrays.toString(board) +
                ", numberOfFields=" + numberOfFields +
                ", shaker=" + shaker +
                ", chanceDeck=" + chanceDeck +
                '}';
    }


    /**
     * Finds the lowest number of houses on any fields in the group.
     * @param groupID the group.
     * @return The minimum number of houses in a group.
     */
    public int getLowestNumOfHousesOnFieldsInThisGroup(int groupID) {
        Field[] fieldsInGroup = getFieldsInGroup(groupID);
        int lovesNumOfHousesOnFieldsInThisGroup = 5;
        for (Field currentField : fieldsInGroup) {
            Territory currentTerritory = (Territory) currentField;
            if (currentTerritory.getNumOfHouses() < lovesNumOfHousesOnFieldsInThisGroup)
                lovesNumOfHousesOnFieldsInThisGroup = currentTerritory.getNumOfHouses();
        }
        return lovesNumOfHousesOnFieldsInThisGroup;
    }

    /**
     * If the player owns all territories in the group.
     * @param territory The reference territory.
     * @param player The player that owns it.
     * @return true if he own all.
     */
    public boolean playerOwnsAllInGroup(Territory territory, Player player) {
        int groupID = territory.getGroupID();
        if (getNumInGroupOwned(player, groupID) == getNumberOfPropertiesInGroup(groupID)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a player can buy a house on a territory.
     * @param territory The territory to check.
     * @return true if the player can buy a house og hotel on the territory in question.
     * needs to own all fields in group and houses have to bee disturbed evenly on all fields in group.
     */
    public boolean canBuyHouse(Territory territory) {
        int groupID = territory.getGroupID();
        int lowestNumHouses = getLowestNumOfHousesOnFieldsInThisGroup(groupID);
        if (playerOwnsAllInGroup(territory, territory.getOwner()) && territory.getNumOfHouses() == lowestNumHouses && territory.getNumOfHouses() <= 5) {
            return true;
        }
        return false;
    }

    /**
     * Gets the Territories which the player can actually buy.
     * @param groupID the group.
     * @return ArrayList of territories where the player can buy houses og hotels. only in the group the player have just landed on.
     */
    public ArrayList<Territory> getListOfBuyableHouseOptions(int groupID) {
        Field[] fieldArray = getFieldsInGroup(groupID);
        ArrayList<Territory> listOfBuyableFieldOptions = new ArrayList<>();
        for (Field currentField : fieldArray) {
            Territory currentTerritory = (Territory) currentField;
            if (canBuyHouse(currentTerritory)) {
                listOfBuyableFieldOptions.add(currentTerritory);
            }
        }
        return listOfBuyableFieldOptions;
    }

    /**
     * Gets the names of the fields you can buy.
     * @param groupID the group.
     * @return an array of the names of the fields you gan buy.
     */
    public String[] getStringOfBuyableFieldOptions(int groupID) {
        ArrayList<Territory> listOfBuyableFieldOptions;
        listOfBuyableFieldOptions = getListOfBuyableHouseOptions(groupID);
        String[] StringOfBuyableFieldOptions = new String[listOfBuyableFieldOptions.size() + 1];
        for (int i = 0; i < listOfBuyableFieldOptions.size(); i++) {
            StringOfBuyableFieldOptions[i] = listOfBuyableFieldOptions.get(i).getName();

        }
        return StringOfBuyableFieldOptions;
    }

    /**
     * Checks if there is houses or hotel available according to the max amount.
     *
     * @param groupID the groups.
     * @return true if there is houses available.
     */
    public boolean houseAvailable(int groupID) {
        Field[] territoryArray = getArrayOfFieldsByType(Territory.class);
        int numOfHouses = 0;
        int numOfHotels = 0;
        for (Field currentField : territoryArray) {
            Territory currentTerritory = (Territory) currentField;
            if (currentTerritory.getNumOfHouses() == 5) {
                numOfHotels++;
            } else {
                numOfHouses = numOfHouses + currentTerritory.getNumOfHouses();
            }
        }
        if (numOfHouses < maxHouses && getLowestNumOfHousesOnFieldsInThisGroup(groupID) < 4) {
            return true;
        } else if (numOfHotels < maxHotels && getLowestNumOfHousesOnFieldsInThisGroup(groupID) == 4) {
            return true;
        } else {
            return false;
        }

    }
}
