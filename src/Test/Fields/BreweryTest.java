package Test.Fields;

import Game.Fields.Brewery;
import Game.GameBoard;
import Game.GameController;
import Game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by razze on 05-01-2017.
 * <p>
 * Validate that the...
 * entity have been created and are of the correct type (x)
 * Field name can be set and returned (x)
 * Buying price can be returned (x)
 * Owner can be set and returned (x)
 * Base rent can be returned (x)
 * Rent can be calculated correctly (x)
 * Pawn price can be calculated correctly and is half of the buy price (x)
 */
public class BreweryTest {

    private Brewery brewery1, brewery2;
    private Player player;
    private GameBoard gameBoard;
    private int price;
    private int baseRent;
    private int groupID;

    @BeforeClass
    public static void setUpBeforeClass() {

    }

    @Before
    public void setUp() {

        this.player = new Player("Test1");
        this.player = new Player("Test2");

        this.brewery1 = new Brewery("BrewTest1", 3000, baseRent, 6);
        this.brewery2 = new Brewery("BrewTest2", 3000, baseRent, 6);

        gameBoard = GameController.getGameBoard();

    }

    @After
    public void tearDown() throws Exception {
        //GameController.reset();
    }

    @Test
    public void entityTest() {

        assertNotNull(brewery1);
        assertNotNull(brewery2);
        assertTrue(brewery1 instanceof Brewery);
        assertTrue(brewery2 instanceof Brewery);

    }

    @Test
    public void nameTest() {

        String name = brewery1.getName();
        assertEquals("BrewTest", name);

    }

    @Test
    public void ownerTest() {

        brewery1.setOwner(player);
        Player owner = brewery1.getOwner();

        assertEquals(player, owner);

    }

    @Test
    public void getPawnPrice() {

        int pawnPrice = brewery1.getPawnPrice();
        assertEquals(1500, pawnPrice);

    }

    @Test
    public void rentTest() {


        int rent = brewery1.getRent();
        int expectedRent = gameBoard.getShaker().getSum() * 100;

        assertEquals(expectedRent, rent);

        brewery1.setOwner(player);
        brewery2.setOwner(player);

        rent = brewery1.getRent();

        if (brewery1.getOwner().equals(player) && brewery2.getOwner().equals(player)) {

            expectedRent = gameBoard.getShaker().getSum() * 200;

            assertEquals(expectedRent, rent);
        }


    }

    @Test
    public void priceTest() {

        int price = brewery1.getPrice();

        assertEquals(3000, price);

        price = brewery2.getPrice();

        assertEquals(3000, price);

    }
}
