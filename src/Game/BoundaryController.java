package Game;

import Game.Fields.Field;
import desktop_codebehind.Car;
import desktop_resources.GUI;


/**
 * Chooses whether we run a console version of the program or the GUI
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted, Timothy Rasmussen
 * @version v.0.3
 */
public class BoundaryController {

    /**
     * Setting variables for BoundaryController.
     */

    private static Mode mode;
    private static String preDefinedAnswer;
    private BoundaryController() {
    }

    /**
     * A method for the fields in the testCases.
     *
     * @param newPreDefinedAnswer The predefined answer.
     */

    public static void setPreDefinedAnswer(String newPreDefinedAnswer) {
        preDefinedAnswer = newPreDefinedAnswer;
    }

    /**
     * The method for setting the interface mode.
     *
     * @param newMode Sets the mode for the Mode type.
     */

    public static void setInterfaceMode(Mode newMode) {

        mode = newMode;

    }

    /**
     * The method to add a player to the game, with exception if the program runs in test mode.
     *
     * @param name          The players name.
     * @param start_balance The players starting balance.
     * @param car           The players car object.
     */

    public static void addPlayer(String name,int start_balance, Car car) {
        switch (mode) {

            case GUI:
                GUI.addPlayer(name, start_balance, car);
                break;

            case Test:
                break;

            default:
                break;
        }

    }

    /**
     * The method asks a player a question.
     *
     * @param question shall take a question.
     * @return the players answer.
     */

    public static String getUserString(String question) {

        switch (mode) {

            case GUI:
                return GUI.getUserString(question);
            case Test:
                System.out.println(question);
                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static void setDice(int faceValue1, int faceValue2) {
        switch (mode) {

            case GUI:
                GUI.setDice(faceValue1, faceValue2);
                break;
            case Test:
                break;
        }
    }

    public static void removeAllCars(String name) {
        switch (mode) {

            case GUI:
                GUI.removeAllCars(name);
                break;
            case Test:
                break;
        }

    }

    public static void setCar(int onField, String name) {
        switch (mode) {

            case GUI:
                GUI.setCar(onField, name);
                break;
            case Test:
                break;
        }

    }

    public static void showMessage(String message) {
        switch (mode) {

            case GUI:
                GUI.showMessage(message);
                break;
            case Test:
                System.out.println(message);
                break;
        }

    }

    public static void close() {
        switch (mode) {

            case GUI:
                GUI.close();
                break;
            case Test:
                break;
        }

    }

    public static String getUserSelection(String questionToUser, String... possibleAnswers) {
        switch (mode) {
            case GUI:
                return GUI.getUserSelection(questionToUser, possibleAnswers);
            case Test:
                System.out.print(questionToUser);
                System.out.print(" [");

                for (String item : possibleAnswers) {
                    System.out.print(item + " ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static String getUserButtonPressed(String questionToUser, String... possibleAnswers) {

        switch (mode) {
            case GUI:
                return GUI.getUserButtonPressed(questionToUser, possibleAnswers);
            case Test:
                System.out.print(questionToUser);
                System.out.print(" [");

                for (String item : possibleAnswers) {
                    System.out.print(item + " ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static void updateBalance(Player player) {

        int balance = player.getBalance();

        switch (mode) {

            case GUI:
                GUI.setBalance(player.getName(), balance);
                break;
            case Test:
                System.out.println("The players balance was set to " + balance);
                break;
        }
    }

    public static void buyHouse(int field, int numberOfHouses){

        GUI.setHouses(field, numberOfHouses);

    }

    public static void buyHotel(int field, boolean hasHotel){
        GUI.setHotel(field, hasHotel);
    }

    /**
     * Creates the GUI based on field array.
     */
    public static void showOnGui(Field[] board) {

        switch (mode) {

            case GUI:
                desktop_fields.Field[] tempField = new desktop_fields.Field[40];

                for (int i = 0; i < board.length; i++) {
                    tempField[i] = board[i].convertToGUI();
                }

                // Creates the GUI with the fieldarray
                GUI.create(tempField);
                break;
            case Test:
                System.out.println("Create GUI call");
                break;
        }


    }

    public static void setOwner(int fieldNumber, String name) {
        GUI.setOwner(fieldNumber, name);
    }

    public static void removeOwner(int fieldNumber) {
        GUI.removeOwner(fieldNumber);
    }


    /**
     * Creating new variable type "Mode".
     */
    public enum Mode {

        //Two types of modes

        GUI,
        Test

    }

}
