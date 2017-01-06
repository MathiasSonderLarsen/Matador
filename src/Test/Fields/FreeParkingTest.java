package Test.Fields;

import Game.Fields.FreeParking;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


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
        this.freeParking = new FreeParking("P-Plads",0);
    }

    @Test
    public void entityTest() {
        assertNotNull(freeParking);
        assertTrue(freeParking instanceof FreeParking);
        assertTrue(freeParking.getName() == "P-Plads");
    }


}
