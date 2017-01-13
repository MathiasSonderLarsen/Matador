package Test.PlayThrough;

import Game.BoundaryController;
import Game.GameController;
import Game.Language;
import Game.Shaker;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Matt_Lab on 10/01/2017.
 */
public class PlayThrough1 {

    Shaker shaker;
    GameController controller;
    //CardDeck deck;

    //test data

    String[] preAnwsers = {"2", "player1", "player2", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Pay 1000", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Yes", "Rødovervej", "Yes", "Hvidovervej", "Yes", "Rødovervej", "Yes", "No", "Yes", "Hvidovervej", "Yes", "Hvidovervej", "Yes", "Rødovervej", "Yes", "Roll two of the same dice", "Roll two of the same dice",};

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp() {
        this.shaker = new FakeShaker(2);
        this.controller = new GameController(shaker);

    }

    @Test
    public void playThrough() {
        BoundaryController.setPreDefinedAnswer(preAnwsers);
        controller.startGame();


    }


    @Override
    public String toString() {
        return "PlayThrough1{" +
                "shaker=" + shaker +
                ", controller=" + controller +
                ", preAnwsers=" + Arrays.toString(preAnwsers) +
                '}';
    }
}
