package Test;

import Game.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

        this.tax1 = new Tax("Tax1",1000,1.0f);
        this.tax2 = new Tax("Tax2",4000,0.1f);

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
        actual = tax1.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void testTaxAmount() {
        int expected = 1000;
        int actual = tax1.getTaxAmount();
        assertEquals(expected, actual);

        expected = 4000;
        actual = tax2.getTaxAmount();
        assertEquals(expected, actual);
    }

    @Test
    public void testTaxRate() {
        float expected = 1.0f;
        float actual = tax1.getTaxRate();
        assertEquals(expected, actual, 0.001);

        expected = 0.1f;
        actual = tax2.getTaxRate();
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testTaxRelativTax() {
        player.addRealEstateValue(1000);
        int expected = 1000;
        int actual = tax1.getRelativTax();
        assertEquals(expected, actual);

        expected = 100;
        actual = tax2.getRelativeTax();
        assertEquals(expected, actual);

        player.addRealEstateValue(2001);
        expected = 300;
        actual = tax2.getRelativeTax;
        assertEquals(expected,actual);

        player.addRealEstateValue(8);
        expected = 300;
        assertEquals(expected, actual);
    }
}