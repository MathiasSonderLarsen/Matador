package Test;

import Game.Fields.GoToJail;
import Game.Fields.Jail;
import Game.Player;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Matt_Lab on 05/01/2017.
 */
public class GoToJailTest {

    private Player player;
    private GoToJail goTo;
    private Jail jail;

    @Before
    public void setUp() {
        goTo = new GoToJail("GoToJail", 4, Color.black);
    }

    @Test
    public void testEntities() {
        assertNotNull(this.goTo);

        assertTrue(this.goTo instanceof GoToJail);
    }

    @Test
    public void testName() {
        String expected = "GoToJail";
        String actual = goTo.getName();
        assertEquals(expected, actual);

        goTo.setName("Change");
        expected = "Change";
        actual = goTo.getName();
        assertEquals(expected, actual);


    }

    @Override
    public String toString() {
        return "GoToJailTest{" +
                "player=" + player +
                ", goTo=" + goTo +
                ", jail=" + jail +
                '}';
    }
}
