package Test;

import Game.Field;
import Game.GameController;
import Game.Territory;
import Game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the Territory class
 * <p>
 * Bugs: none known
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class TerritoryTest {

    private Player player;
    private Territory territory1, territory2, territory3;
    private GameBoard gameBoard;

    @BeforeClass
    public void setUpBeforeClass(){}

    @Before
    public void setUp(){

        this.player = new Player("Player1");
        this.territory1 = (Territory) gameBoard.getField(2);
        this.territory2 = (Territory) gameBoard.getField(4);
        this.territory3 = (Territory) gameBoard.getField(7);

    }

    @After
    public void tearDown() throws Exception {

        GameController.reset();

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
    public void getName(){
        String actual, expected;

        actual = territory1.getName();
        expected = "Territory1";
        assertEquals(expected, actual);

        actual = territory2.getName();
        expected = "Territory1";
        assertEquals(expected, actual);

        actual = territory3.getName();
        expected = "Territory1";
        assertEquals(expected, actual);
    }

    /**
     * Validates that: Buying price can be returned
     * Validates that: Rent corresponds to the description in appendix XXX,
     * increments dependent on how many houses/hotels is on it and can be returned
     */
    @Test
    public void getRent(){ //RET MED RIGTIG RENT
        int actual, expected;

        // Case: return rent with 0 houses on territory
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

        //Case: return rent with 1 house on territory
        territory1.setNumOfHouse(1);
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory2.setNumOfHouse(1);
        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory3.setNumOfHouse(1);
        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

        //Case: return rent with 2 house on territory
        territory1.setNumOfHouse(2);
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory2.setNumOfHouse(2);
        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory3.setNumOfHouse(2);
        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

        //Case: return rent with 3 house on territory
        territory1.setNumOfHouse(3);
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory2.setNumOfHouse(3);
        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory3.setNumOfHouse(3);
        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

        //Case: return rent with 4 house on territory
        territory1.setNumOfHouse(4);
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory2.setNumOfHouse(4);
        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory3.setNumOfHouse(4);
        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

        //Case: return rent with 5 house on territory
        territory1.setNumOfHouse(5);
        actual = territory1.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory2.setNumOfHouse(5);
        actual = territory2.getRent();
        expected = 1200;
        assertEquals(expected, actual);

        territory3.setNumOfHouse(5);
        actual = territory3.getRent();
        expected = 7000;
        assertEquals(expected, actual);

    }

    /**
     * Validates that: House price can be returned and corresponds
     * to the description in appendix XXX
     */
    @Test
    public void getHousePrice(){ //RET MED HUSPRISER
        int actual, expected;

        actual = territory1.getHousePrice();
        expected = 1000;
        assertEquals(expected, actual);

        actual = territory2.getHousePrice();
        expected = 1000;
        assertEquals(expected, actual);

        actual = territory3.getHousePrice();
        expected = 1000;
        assertEquals(expected, actual);

    }

    /**
     * Validates that: Owner can be set and returned
     */
    @Test
    public void setGetOwner(){
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
    public void setGetNumOfHouses(){
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
    public void getPawnPrice(){
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
    public void getGroupID(){
        int actual, expected;

        actual = territory1.getGroupID();
        expected = 1;
        assertEquals(actual, expected);

        actual = territory1.getGroupID();
        expected = 1;
        assertEquals(actual, expected);

        actual = territory1.getGroupID();
        expected = 2;
        assertEquals(actual, expected);

    }







}
