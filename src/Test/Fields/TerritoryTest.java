package Test.Fields;

import Game.Fields.Territory;
import Game.BoundaryController;
import Game.GameBoard;
import Game.GameController;
import Game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Testes the Territory class
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.3
 */
public class TerritoryTest {

    private Player player;
    private Territory territory1, territory2, territory3;
    private GameBoard gameBoard;
    private int[] rentArrayT1, rentArrayT2, rentArrayT3;

    @BeforeClass
    public static void setUpBeforeClass() {

        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
    }

    @Before
    public void setUp() {

        rentArrayT1 = new int[]{100, 200, 300, 400, 500, 1000};
        rentArrayT2 = new int[]{100, 200, 300, 400, 500, 1000};
        rentArrayT3 = new int[]{200, 400, 500, 600, 700, 1500};

        this.player = new Player("Player1");

        this.territory1 = new Territory("Territory1", 1, Color.black, 1200, rentArrayT1, 500);
        this.territory2 = new Territory("Territory2", 1, Color.black, 1200, rentArrayT2, 500);
        this.territory3 = new Territory("Territory3", 2, Color.black, 2000, rentArrayT3, 600);
        
        GameBoard board = GameController.getGameBoard();

    }

    @After
    public void tearDown() throws Exception {

        //GameController.reset();

    }

    /**
     * Validates that: Entities have been created and are of the correct type
     */
    @Test
    public void entityTest() {

        assertNotNull(territory1);
        assertNotNull(territory2);
        assertNotNull(territory3);
        assertTrue(territory1 instanceof Territory);
        assertTrue(territory2 instanceof Territory);
        assertTrue(territory3 instanceof Territory);

    }

    /**
     * Validates that: Field name can be set and returned
     */
    @Test
    public void getName() {
        String actual, expected;

        actual = territory1.getName();
        expected = "Territory1";
        assertEquals(expected, actual);

        actual = territory2.getName();
        expected = "Territory2";
        assertEquals(expected, actual);

        actual = territory3.getName();
        expected = "Territory3";
        assertEquals(expected, actual);
    }

    /**
     * Validates that: Buying price can be returned
     * Validates that: Rent corresponds to the description in appendix XXX,
     * increments dependent on how many houses/hotels is on it and can be returned
     */
    @Test
    public void getRent() {
        int actual, expected;

        // Case: return rent with 0 houses on territory
        actual = territory1.getRent();
        expected = 100;
        assertEquals(expected, actual);

        actual = territory2.getRent();
        expected = 100;
        assertEquals(expected, actual);

        actual = territory3.getRent();
        expected = 200;
        assertEquals(expected, actual);

    }

    /**
     * Validates that: House price can be returned and corresponds
     * to the description in appendix XXX
     */
    @Test
    public void getHousePrice() {
        int actual, expected;

        actual = territory1.getHousePrice();
        expected = 500;
        assertEquals(expected, actual);

        actual = territory2.getHousePrice();
        expected = 500;
        assertEquals(expected, actual);

        actual = territory3.getHousePrice();
        expected = 600;
        assertEquals(expected, actual);

    }


    /**
     * Validates that: FieldID can be returned
     */
    @Test
    public void getGroupID() {
        int actual, expected;

        actual = territory1.getGroupID();
        expected = 1;
        assertEquals(actual, expected);

        actual = territory2.getGroupID();
        expected = 1;
        assertEquals(actual, expected);

        actual = territory3.getGroupID();
        expected = 2;
        assertEquals(actual, expected);

    }

}
