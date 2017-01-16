package Test;

import Game.Account;
import Game.BoundaryController;
import Game.Player;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Player class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.4
 */
public class PlayerTest {

    private Player player;
    @BeforeClass
    public static void setUpBeforeClass() {

        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
    }
    @Before
    public void setUp() {
        player = new Player("Player1");
    }

    /**
     * validates that the entities have been created and is of the correct type.
     */
    @Test
    public void testEntities() {
        assertNotNull(this.player);
        assertNotNull(this.player.getAccount());

        assertTrue(this.player instanceof Player);
        assertTrue(this.player.getAccount() instanceof Account);
    }

    /**
     * validates that the account balance can be changed and returned.
     * also validates that the start balance of the account is 30,000 points.
     *
     * @throws Exception
     */
    @Test
    public void testBallance() throws Exception {

        int expected = 30000;
        int actual = player.getBalance();
        assertEquals(expected, actual);

        player.addBalance(5000);

        expected = 35000;
        actual = player.getBalance();
        assertEquals(expected, actual);

        player.addBalance(-10000);

        expected = 25000;
        actual = player.getBalance();
        assertEquals(expected, actual);

        player.addBalance(0);

        expected = 25000;
        actual = player.getBalance();
        assertEquals(expected, actual);
    }

    @Test
    public void testName() throws Exception {

        String expected = "Player1";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testOnField() throws Exception {

        player.setOnField(20);

        int expected = 20;
        int actual = player.getOnField();
        assertEquals(expected, actual);


        player.setOnField(5);
        expected = 5;
        actual = player.getOnField();
        assertEquals(expected, actual);
    }

    @Override
    public String toString() {
        return "PlayerTest{" +
                "player=" + player +
                '}';
    }
}