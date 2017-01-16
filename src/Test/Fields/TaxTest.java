package Test.Fields;

import Game.Fields.Tax;
import Game.Player;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


/**
 * Tests the Tax class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.4
 */
public class TaxTest {

    private Player player;
    private Tax tax1;
    private Tax tax2;


    @Before
    public void setUp() throws Exception {
        this.player = new Player("Player");

        this.tax1 = new Tax("Tax1", 2, Color.black, 1000, 1.0f);
        this.tax2 = new Tax("Tax2", 2, Color.black, 4000, 0.1f);

    }

    @Test
    public void testEntities() {
        assertNotNull(this.player);
        assertNotNull(this.tax1);
        assertNotNull(this.tax2);

        assertTrue(this.player instanceof Player);

        assertTrue(this.tax1 instanceof Tax);
        assertTrue(this.tax2 instanceof Tax);
    }

    @Test
    public void testName() throws Exception {

        String expected = "Tax1";
        String actual = tax1.getName();
        assertEquals(expected, actual);

        expected = "Tax2";
        actual = tax2.getName();
        assertEquals(expected, actual);

        tax1.setName("Change");
        expected = "Change";
        actual = tax1.getName();
        assertEquals(expected, actual);

        tax2.setName("BigTax");
        expected = "BigTax";
        actual = tax2.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void testTaxRelativTax() {
        int expected = -1000;
        int actual = tax1.calculateRelativeTax(1000);
        assertEquals(expected, actual);

        expected = -100;
        actual = tax2.calculateRelativeTax(1000);
        assertEquals(expected, actual);


    }

    @Override
    public String toString() {
        return "TaxTest{" +
                "player=" + player +
                ", tax1=" + tax1 +
                ", tax2=" + tax2 +
                '}';
    }
}