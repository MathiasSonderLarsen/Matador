package Game;


import Game.Fields.Field;
import Game.Fields.Jail;
import desktop_codebehind.Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
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
 * @version v.0.4
 */

public class GameController {

    private final int FIELD_COUNT = 40;

    /**
     * Getter for property 'gameBoard'.
     *
     * @return Value for property 'gameBoard'.
     */
    public static GameBoard getGameBoard() {
        return gameBoard;
    }

    private static GameBoard gameBoard;


    /**
     * Getter for property 'currentPlayer'.
     *
     * @return Value for property 'currentPlayer'.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList<Player>();


    public GameController(Shaker shaker) {
        gameBoard = new GameBoard(FIELD_COUNT, shaker);
    }

    private void initializePlayers() {


        String numberSelected = BoundaryController.getUserSelection(Language.getString("greeting"), "2", "3", "4", "5", "6");
        int numberOfPlayers = Integer.parseInt(numberSelected);
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = BoundaryController.getUserString(Language.getString("name1") + (i + 1) + Language.getString("name2")); //the + (i+1) changes the number so system prints player1 then player2...
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

    public void checkIfCanMove() {
        //if (shaker.DoublesInARow())
    }


    private void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        BoundaryController.setDice(faceValue1, faceValue2);
    }

    private Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    /*
        public  void reset() {
            FIELD_COUNT = 21;
            //gameBoard = new GameBoard(FIELD_COUNT);
            //TODO fix shaker
            currentPlayer = null;
            players = new ArrayList<Player>(); //creates an ArrayList that can contain Player objects

        }
    */
    public void playTurn(Player player) {

        System.out.println("Before move" + player.toString());
        //rolls the dice
        gameBoard.getShaker().shake();

        //displays the dice in the GUI
        displayDice(gameBoard.getShaker());

        if (Jail.isJailed(player) == false) {

            //moves the player's token on the gameBoard in the GUI
            gameBoard.movePlayerAnim(player, gameBoard.getShaker().getSum(), false);

        } else {

            // Your options in jail
            // SKAL IND I LANGUAGE
            String answer;
            final String question = Language.getString("methodOutOfJail");
            final String answer1 = Language.getString("rollTwoOfTheSame");
            final String answer2 = Language.getString("pay4000");
            final String answer3 = Language.getString("useChanceCard");

            if (player.getOutOfJailCards() > 0) {
                answer = BoundaryController.getUserButtonPressed(question, answer1, answer2, answer3);
            } else {
                answer = BoundaryController.getUserButtonPressed(question, answer1, answer2);

                if (Objects.equals(answer1, answer)) {
                    gameBoard.getShaker().shake();
                    displayDice(gameBoard.getShaker());

                    if (gameBoard.getShaker().getDoublesInARow() > 0) {
                        Jail.removePlayer(player);
                    }
                } else if (Objects.equals(answer2, answer)) {
                    player.addBalance(-4000);
                    Jail.removePlayer(player);
                } else if (Objects.equals(answer3, answer)) {
                    player.setOutOfJailCards(-1);
                    Jail.removePlayer(player);
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

        System.out.println("After move" + player.toString());
    }


    public void startGame() {

        // Adds players to the game
        initializePlayers();

        // While there is more than one person standing
        while (players.size() > 1) {

            // For every player in the game
            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);

                playTurn(currentPlayer);

                if (gameBoard.getShaker().getDoublesInARow() > 0 && gameBoard.getShaker().getDoublesInARow() != 3 && currentPlayer != null) {

                    playTurn(currentPlayer);
                }

                if (gameBoard.getShaker().getDoublesInARow() == 3 && currentPlayer != null) {

                    Jail theJailField = ((Jail) GameController.getGameBoard().getField(11));

                    theJailField.addPlayer(currentPlayer);

                    gameBoard.movePlayerAnim(currentPlayer, 11, true);
                }

                if (currentPlayer.getExtraTurn()) {
                    currentPlayer.setExtraTurn(false);
                    i--;
                }
            }

        }

        // Gets displayed when a winner has been found. SKAL OGSÅ IND I LANGUAGE
        BoundaryController.showMessage(players.get(0).getName() + " " + Language.getString("won"));

        BoundaryController.close();

    }
}
