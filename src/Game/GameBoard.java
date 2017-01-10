package Game;

import Game.Fields.Field;
import Game.Fields.Ownable;
import Game.Fields.Territory;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GameBoard encapsulates all the Fields used in the game
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class GameBoard {

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
        return i + 1;
    }

    public Territory[] getBuyableArray(int groupID, int numberOfFields) {

        Territory[] houseBuyableFields = new Territory[numberOfFields];
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


    public  void movePlayerRelative(Player thisPlayer, int stepsToMove) {
        int playerPos = thisPlayer.getOnField();


        //stores the players location on the gameBoard
        if (thisPlayer.getOnField() + stepsToMove <= numberOfFields) {
            thisPlayer.setOnField(thisPlayer.getOnField() + stepsToMove);
        } else {
            thisPlayer.setOnField(thisPlayer.getOnField() + stepsToMove - numberOfFields);
        }

        BoundaryController.removeAllCars(thisPlayer.getName());
        BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());
    }


    public  void movePlayerAbsolute(Player thisPlayer, int newPos) {

        thisPlayer.setOnField(newPos);
        BoundaryController.removeAllCars(thisPlayer.getName());
        BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());

    }

    public  void movePlayerAnim(Player thisPlayer, int moveToField, boolean AbsolutePos) {

        if (AbsolutePos) {
            movePlayerAbsolute(thisPlayer, moveToField);
        } else {
            for (int i = 0; i < moveToField; i++) {
                movePlayerRelative(thisPlayer, 1);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
