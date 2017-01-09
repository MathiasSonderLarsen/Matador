package Game;


import Game.Fields.Field;
import Game.Fields.Jail;
import desktop_codebehind.Car;
import desktop_resources.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * GameController controls the main flow of the game
 * <p>
 * Bugs: If a player gets bankrupt, the player before him get an extra turn.
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

    /**
     * Getter for property 'gameBoard'.
     *
     * @return Value for property 'gameBoard'.
     */
    public static GameBoard getGameBoard() {
        return gameBoard;
    }

    private static GameBoard gameBoard = new GameBoard(FIELD_COUNT);
    private static Shaker shaker = new Shaker(2);

    /**
     * Getter for property 'currentPlayer'.
     *
     * @return Value for property 'currentPlayer'.
     */
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    private static Player currentPlayer;
    private static ArrayList<Player> players = new ArrayList<Player>();


    private GameController() {
    }

    private static void initializePlayers() {


        String numberSelected = BoundaryController.getUserSelection(Language.getString("greeting"), "2", "3", "4", "5", "6");
        int numberOfPlayers = Integer.parseInt(numberSelected);
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = "Kurt" + i;//BoundaryController.getUserString(Language.getString("name1") + (i + 1) + Language.getString("name2")); //the + (i+1) changes the number so system prints player1 then player2...
            players.add(new Player(name)); //creates a new player object.

            Player thisPlayer = players.get(i);
            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            BoundaryController.addPlayer(thisPlayer.getName(), thisPlayer.getBalance(), new Car.Builder()
                    .primaryColor(randomColor())
                    .build());

            BoundaryController.setCar(1, thisPlayer.getName());

        }
    }

    public static void checkIfCanMove() {
        //if (shaker.DoublesInARow())
    }

    public static void movePlayer(Player thisPlayer, int moveFields) {

        int playerPos = thisPlayer.getOnField();

        //stores the players location on the gameBoard
        if (thisPlayer.getOnField() + moveFields <= FIELD_COUNT) {
            thisPlayer.setOnField(thisPlayer.getOnField() + moveFields);
        } else {
            thisPlayer.setOnField(thisPlayer.getOnField() + moveFields - FIELD_COUNT);
        }

        //"Moves" the car on the board by removing it in the previous location
        // and then set it to the new location.
//        for (int i = moveFields; i >= 0 ; i--) {
        BoundaryController.removeAllCars(thisPlayer.getName());
//           BoundaryController.setCar(thisPlayer.getOnField()-moveFields, thisPlayer.getName());

        BoundaryController.setCar(thisPlayer.getOnField(), thisPlayer.getName());

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }

    public static Shaker getShaker() {
        return shaker;
    }

    private static void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        BoundaryController.setDice(faceValue1, faceValue2);
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
        players = new ArrayList<Player>(); //creates an ArrayList that can contain Player objects

    }

    public static void playTurn(Player player) {

        //rolls the dice
        shaker.shake();

        //displays the dice in the GUI
        displayDice(shaker);

        if (Jail.isJailed(player) == false) {

            //moves the player's token on the gameBoard in the GUI
            movePlayer(player, shaker.getSum());

        } else {

            // Your options in jail
            // SKAL IND I LANGUAGE
            String answer;
            if (player.getOutOfJailCards() > 0) {
                answer = BoundaryController.getUserButtonPressed("Sådan kommer du ud af fængsel:",
                        "Rul 2 ens", "Betal 4000 points", "Brug ud af fængsel kort");
            } else {
                answer = BoundaryController.getUserButtonPressed("Sådan kommer du ud af fængsel:",
                        "Rul 2 ens", "Betal 4000 points");
            }

            switch (answer) {
                case "Rul 2 ens":
                    shaker.shake();
                    displayDice(shaker);

                    if (shaker.getDoublesInARow() > 0) {
                        Jail.removePlayer(player);
                    }
                    break;
                case "Betal 4000 points":
                    player.addBalance(-4000);
                    Jail.removePlayer(player);
                    break;
                case "Brug ud af fængsel kort":
                    player.setOutOfJailCards(-1);
                    Jail.removePlayer(player);
                    break;
                default:
                    System.out.println("Should never happen");

            }
            // Adds jailRound to the player if he still is in jail (Because he rolls dice)
            if (Jail.isJailed(player)) {
                player.addRoundsInJail(1);
            }

            // After 3 rounds in jail, the player must pay bail.
            if (player.getRoundsInJail() == 3) {

                player.addBalance(-1000);
                player.addRoundsInJail(-3);
                Jail.removePlayer(player);

            }

        }

        //controls what happens when the player lands on a specific field.
        Field currentField = gameBoard.getField(player.getOnField());
        BoundaryController.showMessage(player.getName() + " " + Language.getString("landed") + " " + currentField.getName());
        currentField.landOnField(player);

        //removes bankrupt players from the game
        if (player.getBalance() <= 0) {
            gameBoard.deleteOwnership(player);
            players.remove(player);
        }

    }


    public static void startGame() {

        // Adds players to the game
        initializePlayers();

        // While there is more than one person standing
        while (players.size() > 1) {

            // For every player in the game
            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);

                playTurn(currentPlayer);

                if (shaker.getDoublesInARow() > 0 && currentPlayer != null) {

                    playTurn(currentPlayer);
                }
            }

        }

        // Gets displayed when a winner has been found. SKAL OGSÅ IND I LANGUAGE
        BoundaryController.showMessage(players.get(0).getName() + " " + Language.getString("Vandt!"));

        BoundaryController.close();

    }
}
