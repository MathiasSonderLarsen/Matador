package Test;

import Game.Fleet;
import Game.FreeParking;
import Game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * FreeParkingTest class
 * <p>
 * Bugs: none known
 *
 * @author Timothy Rasmussen
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class FreeParkingTest {

    FreeParking freeParking;

    @Before
    public void setUp() {
    this.freeParking  = new FreeParking("P-Plads");
    }

    @Test
    public void entityTest(){
        assertNotNull(freeParking);
        assertTrue(freeParking instanceof FreeParking);
        assertTrue(freeParking.getName() == "P-Plads");
    }



}
