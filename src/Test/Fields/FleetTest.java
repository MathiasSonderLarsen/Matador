package Test.Fields;

import Game.*;
import Game.Fields.Fleet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the Fleet class
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.5
 */
public class FleetTest {

    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Fleet fleet1;
    private Fleet fleet2;
    private Fleet fleet3;
    private Fleet fleet4;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp() {

        new GameController(new Shaker(2));

        this.player1 = new Player("Player1");
        this.player2 = new Player("Player2");
        //this.gameBoard = new GameBoard(21);
        this.gameBoard = GameController.getGameBoard();


        this.fleet1 = (Fleet) gameBoard.getField(6);
        this.fleet2 = (Fleet) gameBoard.getField(16);
        this.fleet3 = (Fleet) gameBoard.getField(26);
        this.fleet4 = (Fleet) gameBoard.getField(36);


    }

    @After
    public void tearDown() throws Exception {
        //GameController.reset();
    }

    @Test
    public void testEntities() {
        assertNotNull(player1);
        assertNotNull(player2);

        assertNotNull(fleet1);
        assertNotNull(fleet2);
        assertNotNull(fleet3);
        assertNotNull(fleet4);

        assertTrue(player1 instanceof Player);
        assertTrue(player2 instanceof Player);

        assertTrue(gameBoard instanceof GameBoard);

        assertTrue(fleet1 instanceof Fleet);
        assertTrue(fleet2 instanceof Fleet);
        assertTrue(fleet3 instanceof Fleet);
        assertTrue(fleet4 instanceof Fleet);
    }

    @Test
    public void getName() throws Exception {

        String expected = "Scandlines";
        String actual = fleet1.getName();
        assertEquals(expected, actual);

        expected = "Mols-Linien";
        actual = fleet2.getName();
        assertEquals(expected, actual);

        expected = "Scandlines";
        actual = fleet3.getName();
        assertEquals(expected, actual);

        expected = "Scandlines";
        actual = fleet4.getName();
        assertEquals(expected, actual);

        fleet1.setName("Change Name");
        expected = "Change Name";
        actual = fleet1.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void getOwner() throws Exception {

        assertTrue(fleet1.getOwner() == null);
        assertTrue(fleet2.getOwner() == null);
        assertTrue(fleet3.getOwner() == null);
        assertTrue(fleet4.getOwner() == null);

        fleet1.setOwner(player1);
        fleet2.setOwner(player1);
        fleet3.setOwner(player1);
        fleet4.setOwner(player1);

        Player expected = player1;
        Player actual = fleet1.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet2.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet3.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet4.getOwner();
        assertEquals(expected, actual);
    }


    @Test
    public void landOnField() throws Exception {

        /**
         * ownership of 1 fleet
         */
        // testes that that start balance i correct.
        int expected = 30000;
        int actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //player1 buys fleet 1
        BoundaryController.setPreDefinedAnswer(new String[]{Language.getString("yes")});
        this.fleet1.landOnField(this.player1);

        //tests that the price of the field have been transferred.
        expected = 26000;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been transferred.
        Player expectedOwner = player1;
        Player actualOwner = fleet1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 30000;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        expected = 26000;
        actual = player1.getBalance();
        assertEquals(expected, actual);


        /**
         * owner ship of 2 fleets
         */
        //player1 buys fleet 1
        BoundaryController.setPreDefinedAnswer(new String[]{Language.getString("yes")});
        this.fleet2.landOnField(this.player1);

        //tests that the price of the field have been transferred.
        expected = 22000;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been transferred
        expectedOwner = player1;
        actualOwner = fleet2.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet2.landOnField(player2);
        expected = 30000;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        expected = 22000;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        /**
         * owner ship of 3 fleets
         */
        //player1 buys fleet 1
        BoundaryController.setPreDefinedAnswer(new String[]{Language.getString("yes")});
        this.fleet3.landOnField(this.player1);

        //tests that the price of the field have been transferred.
        expected = 18000;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been transferred.
        expectedOwner = player1;
        actualOwner = fleet3.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet3.landOnField(player2);
        expected = 30000;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        expected = 18000;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        /**
         * owner ship of 4 fleets
         */
        //player1 buys fleet 1
        BoundaryController.setPreDefinedAnswer(new String[]{Language.getString("yes")});
        this.fleet4.landOnField(this.player1);

        //tests that the price of the field have been transferred.
        expected = 14000;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been transferred.
        expectedOwner = player1;
        actualOwner = fleet4.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 30000;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        expected = 14000;
        actual = player1.getBalance();
        assertEquals(expected, actual);
    }

    @Override
    public String toString() {
        return "FleetTest{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", gameBoard=" + gameBoard +
                ", fleet1=" + fleet1 +
                ", fleet2=" + fleet2 +
                ", fleet3=" + fleet3 +
                ", fleet4=" + fleet4 +
                '}';
    }
}