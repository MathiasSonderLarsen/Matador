package Test;

import Game.Jail;
import desktop_codebehind.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the Jail class
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

public class JailTest {

    @Before
    public void setUp(){
        this.player1 = new Player("Player1", 30000);
        this.player2 = new Player("Player2", 30000);
        this.player3 = new Player("Player3", 30000);
        this.jail = new Jail();
    }

    @Test
    public void testEntities(){
        assertNotNull(this.player1);
        assertNotNull(this.player2);
        assertNotNull(this.player3);

        assertNotNull(this.jail);

        assertTrue(this.player1 instanceof Player);
        assertTrue(this.player2 instanceof Player);
        assertTrue(this.player3 instanceof Player);

        assertTrue(this.jail instanceof Jail);
    }

    @Test
    public void getIsJailed(){

    }
}