package Test.PlayThrough;

import Game.*;
import Game.Fields.Fleet;
import Game.Fields.Ownable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        //player1 1 turn
        //player roles 2,4 = 6
        shaker.setDice(2,4);

        //validate that the player is on the right field before moving
        int expected = 1;
        int actual = player1.getOnField();
        assertEquals(expected,actual);

        //moves player and validates that the player is on the right field
        //player moves to 7
        GameController.movePlayerRelative(player1, shaker.getSum());
        expected = 7;
        actual = player1.getOnField();
        assertEquals(expected,actual);

        //activates what happens when the player lands on the field
        //player buy field
        board.getField(5).landOnField(player1);//køb

        //validates that action have been preformed
        expected = 26000;
        actual = player1.getBalance();
        assertEquals(expected,actual);

        Player ownerActual = ((Fleet) board.getField(5)).getOwner();
        Player ownerExpected = player1;
        assertEquals(ownerExpected,ownerActual);


        //player2 1 turn
        //player roles 2,4 = 6
        shaker.setDice(2,4);

        //validate that the player is on the right field before moving
        int expected = 1;
        int actual = player1.getOnField();
        assertEquals(expected,actual);

        //moves player and validates that the player is on the right field
        //player moves to 7
        GameController.movePlayerRelative(player1, shaker.getSum());
        expected = 7;
        actual = player1.getOnField();
        assertEquals(expected,actual);

        //activates what happens when the player lands on the field
        //player buy field
        board.getField(5).landOnField(player1);//køb

        //validates that action have been preformed
        expected = 26000;
        actual = player1.getBalance();
        assertEquals(expected,actual);

        Player ownerActual = ((Fleet) board.getField(5)).getOwner();
        Player ownerExpected = player1;
        assertEquals(ownerExpected,ownerActual);
    }


}
