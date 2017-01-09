package Game;


/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeld
 * @version v.0.2
 */
public class Game {


    public static void main(String[] args) {

        // Selects the language
        Language.setLanguage("danish");

        BoundaryController.setInterfaceMode(BoundaryController.Mode.GUI);

        // The startGame() method is called to startGame the game
        GameController.startGame();

    }
}
