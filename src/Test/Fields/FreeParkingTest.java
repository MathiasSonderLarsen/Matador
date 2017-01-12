package Test.Fields;

import Game.Fields.FreeParking;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

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
        this.freeParking = new FreeParking("P-Plads", 0, Color.black);
    }

    @Test
    public void entityTest() {
        assertNotNull(freeParking);
        assertTrue(freeParking instanceof FreeParking);
        assertTrue(Objects.equals(freeParking.getName(), "P-Plads"));
    }


    @Override
    public String toString() {
        return "FreeParkingTest{" +
                "freeParking=" + freeParking +
                '}';
    }
}
