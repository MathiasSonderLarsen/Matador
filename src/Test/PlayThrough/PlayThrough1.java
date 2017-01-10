package Test.PlayThrough;

import Game.*;
import Game.Fields.Fleet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Matt_Lab on 10/01/2017.
 */
public class PlayThrough1 {

    Shaker shaker;
    Player player1;
    Player player2;
    GameBoard board;
    //CardDeck deck;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp(){
        this.board = GameController.getGameBoard();
        //this.deck = board.createDeck();
        this.player1 = new Player("player1");
        this.player2 = new Player("player2");
        this.shaker = new Shaker(2);

    }

    @Test
    public void playThrough(){
        shaker.setDice(2,4);
        GameController.movePlayerRelative(player1, sha);
    }
}
