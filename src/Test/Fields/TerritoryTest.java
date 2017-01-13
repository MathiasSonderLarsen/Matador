package Test.Fields;

import Game.Fields.Territory;
import Game.GameBoard;
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

        //Case: return rent with 1 house on territory
        territory1.setNumOfHouses(1);
        actual = territory1.getRent();
        expected = 200;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(1);
        actual = territory2.getRent();
        expected = 200;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(1);
        actual = territory3.getRent();
        expected = 400;
        assertEquals(expected, actual);

        //Case: return rent with 2 house on territory
        territory1.setNumOfHouses(2);
        actual = territory1.getRent();
        expected = 300;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(2);
        actual = territory2.getRent();
        expected = 300;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(2);
        actual = territory3.getRent();
        expected = 500;
        assertEquals(expected, actual);

        //Case: return rent with 3 house on territory
        territory1.setNumOfHouses(3);
        actual = territory1.getRent();
        expected = 400;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(3);
        actual = territory2.getRent();
        expected = 400;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(3);
        actual = territory3.getRent();
        expected = 600;
        assertEquals(expected, actual);

        //Case: return rent with 4 house on territory
        territory1.setNumOfHouses(4);
        actual = territory1.getRent();
        expected = 500;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(4);
        actual = territory2.getRent();
        expected = 500;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(4);
        actual = territory3.getRent();
        expected = 700;
        assertEquals(expected, actual);

        //Case: return rent with 5 house on territory
        territory1.setNumOfHouses(5);
        actual = territory1.getRent();
        expected = 1000;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(5);
        actual = territory2.getRent();
        expected = 1000;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(5);
        actual = territory3.getRent();
        expected = 1500;
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
     * Validates that: Owner can be set and returned
     */
    @Test
    public void setGetOwner() {
        Player actual, expected;

        // Case: No player owns the territory
        actual = territory1.getOwner();
        expected = null;
        assertEquals(actual, expected);

        actual = territory2.getOwner();
        expected = null;
        assertEquals(actual, expected);

        actual = territory3.getOwner();
        expected = null;
        assertEquals(actual, expected);

        // Case: player owns the territory
        territory1.setOwner(player);
        actual = territory1.getOwner();
        expected = player;
        assertEquals(expected, actual);

        territory2.setOwner(player);
        actual = territory2.getOwner();
        expected = player;
        assertEquals(expected, actual);

        territory3.setOwner(player);
        actual = territory3.getOwner();
        expected = player;
        assertEquals(expected, actual);

    }

    /**
     * Validates that: Number of houses can be set and returned
     */
    @Test
    public void setGetNumOfHouses() {
        int actual, expected;

        // Case: 0 number of houses
        actual = territory1.getNumOfHouses();
        expected = 0;
        assertEquals(expected, actual);

        actual = territory2.getNumOfHouses();
        expected = 0;
        assertEquals(expected, actual);

        actual = territory3.getNumOfHouses();
        expected = 0;
        assertEquals(expected, actual);

        // Case: 1 number of houses
        territory1.setNumOfHouses(1);
        actual = territory1.getNumOfHouses();
        expected = 1;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(1);
        actual = territory2.getNumOfHouses();
        expected = 1;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(1);
        actual = territory3.getNumOfHouses();
        expected = 1;
        assertEquals(expected, actual);

        // Case: 2 number of houses
        territory1.setNumOfHouses(2);
        actual = territory1.getNumOfHouses();
        expected = 2;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(2);
        actual = territory2.getNumOfHouses();
        expected = 2;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(2);
        actual = territory3.getNumOfHouses();
        expected = 2;
        assertEquals(expected, actual);

        // Case: 3 number of houses
        territory1.setNumOfHouses(3);
        actual = territory1.getNumOfHouses();
        expected = 3;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(3);
        actual = territory2.getNumOfHouses();
        expected = 3;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(3);
        actual = territory3.getNumOfHouses();
        expected = 3;
        assertEquals(expected, actual);

        // Case: 4 number of houses
        territory1.setNumOfHouses(4);
        actual = territory1.getNumOfHouses();
        expected = 4;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(4);
        actual = territory2.getNumOfHouses();
        expected = 4;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(4);
        actual = territory3.getNumOfHouses();
        expected = 4;
        assertEquals(expected, actual);

        // Case: 5 number of houses
        territory1.setNumOfHouses(5);
        actual = territory1.getNumOfHouses();
        expected = 5;
        assertEquals(expected, actual);

        territory2.setNumOfHouses(5);
        actual = territory2.getNumOfHouses();
        expected = 5;
        assertEquals(expected, actual);

        territory3.setNumOfHouses(5);
        actual = territory3.getNumOfHouses();
        expected = 5;
        assertEquals(expected, actual);

    }

    /**
     * Validates that: Pawn price can be calculated correctly
     * and is half of the buy price
     */
    @Test
    public void getPawnPrice() {
        int actual, expected;

        actual = territory1.getPawnPrice();
        expected = 600;
        assertEquals(expected, actual);

        actual = territory2.getPawnPrice();
        expected = 600;
        assertEquals(expected, actual);

        actual = territory3.getPawnPrice();
        expected = 1000;
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

    @Override
    public String toString() {
        return "TerritoryTest{" +
                "player=" + player +
                ", territory1=" + territory1 +
                ", territory2=" + territory2 +
                ", territory3=" + territory3 +
                ", gameBoard=" + gameBoard +
                ", rentArrayT1=" + Arrays.toString(rentArrayT1) +
                ", rentArrayT2=" + Arrays.toString(rentArrayT2) +
                ", rentArrayT3=" + Arrays.toString(rentArrayT3) +
                '}';
    }
}
