package Game;


import desktop_codebehind.Car;
import org.junit.Ignore;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * GameController controls the main flow of the game
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.2
 */

public class GameController {
    private static int FIELD_COUNT = 40;
    private static GameBoard gameboard = new Gameboard(FIELD_COUNT);
    private static Shaker shaker = new Shaker(2);
    private static Player currentPlayer;
    private static int START_BALANCE = 30000;
    private static ArrayList<Player> players = new ArrayList<Player>();


    private GameController() {
    }

    private static void initializePlayers() {

        String numberSelected = InterfaceController.getUserSelection(Language.getString("greeting"), "2", "3", "4", "5", "6");
        int numberOfPlayers = Integer.parseInt(numberSelected);
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = InterfaceController.getUserString(Language.getString("name1") + (i + 1) + Language.getString("name2")); //the + (i+1) changes the number so system prints player1 then player2...
            players.add(new Player(name, START_BALANCE)); //creates a new player object.

            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            InterfaceController.addPlayer(players.get(i).getName(), START_BALANCE, new Car.Builder()
                    .primaryColor(randomColor())
                    .build());
        }
    }

    public void playTurn(){
        initializePlayers();

        //loop as long as more than one player is in the game (not bankrupt)
        while (players.size() > 1) {

            //go through all the players.

            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);

                //rolls the dice
                shaker.shake();

                //displays the dice in the GUI
                displayDice(shaker);

                if (Jail.getJailed(currentPlayer)==false) {
                    //moves the player's token on the gameboard in the GUI
                    movePlayer(currentPlayer, shaker.getSum());
                }

                if (shaker.DoublesInARow()>0){
                    movePlayer(currentPlayer, shaker.getSum());
                }

                //controls what happens when the player lands on a specific field.
                Field currentField = gameBoard.getField(currentPlayer.getOnField());
                InterfaceController.showMessage(currentPlayer.getName() + " " + Language.getString("landed") + " " + currentField.getName());
                currentField.landOnField(currentPlayer);

                //removes bankrupt players from the game
                if (currentPlayer.getBalance() <= 0) {
                    players.remove(currentPlayer);
                    gameBoard.deleteOwnership(currentPlayer);
                    // Gives the next person the turn, instead of resetting "i".
                    --i;
                }

            }

        }

        //gets displayed when a winner has been found.
        InterfaceController.showMessage(players.get(0).getName() + " " + Language.getString("won"));

        InterfaceController.close();
    }






    public static void checkIfCanMove(){
        if (shaker.DoublesInARow())
    }

    public static void movePlayer(Player thisPlayer, int moveFields) {

        //stores the players location on the gameboard
        if (thisPlayer.getOnField() + moveFields <= FIELD_COUNT) {
            thisPlayer.setOnField(thisPlayer.getOnField() + moveFields);
        } else {
            thisPlayer.setOnField(thisPlayer.getOnField() + moveFields - FIELD_COUNT);
        }

        //"Moves" the car on the board by removing it in the previous location
        // and then set it to the new location.
        InterfaceController.removeAllCars(thisPlayer.getName());
        InterfaceController.setCar(thisPlayer.getOnField(), thisPlayer.getName());

    }

    public static Shaker getShaker() {
        return shaker;
    }

    private static void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        InterfaceController.setDice(faceValue1, faceValue2);
    }

    private static Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static void reset() {
        FIELD_COUNT = 21;
        gameBoard = new GameBoard(FIELD_COUNT);
        shaker = new Shaker(2); //creates a shaker with 2 dice.
        currentPlayer = null;
        START_BALANCE = 30000;
        players = new ArrayList<Player>(); //creates an ArrayList that can contain Player objects

    }


}
