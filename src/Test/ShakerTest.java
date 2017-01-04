package Test;

import Game.Die;
import Game.Shaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Shaker class
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.3
 */

// Tests the Shaker class
public class ShakerTest {

    // Declares object of the "Shaker" class in the folder "game".
    private Shaker shaker;

    @Before
    public void setUp() {
        this.shaker = new Shaker(2);
    }

    @Test
    public void testEntities() {
        assertNotNull(this.shaker);

        assertNotNull(shaker.getDice()[0]);
        assertNotNull(shaker.getDice()[1]);

        assertTrue(this.shaker instanceof Shaker);
        assertTrue(shaker.getDice()[0] instanceof Die);
        assertTrue(shaker.getDice()[1] instanceof Die);

    }

    @Test
    public void probTest() {
        int value;

        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        int eleven = 0;
        int twelve = 0;
        int error = 0;

        // Rolling the die 60000 times.
        // Counts the values a specific value has been rolled.

        for (int i = 0; i < 60000; i++) {

            shaker.shake();

            value = shaker.getSum();

            switch (value) {
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                case 10:
                    ten++;
                    break;
                case 11:
                    eleven++;
                    break;
                case 12:
                    twelve++;
                    break;
                default:
                    error++;
                    break;
            }

        }

        // Tests the program.
        // Checks if all values, of the die (2-12), has been rolled and equal amount of times
        // with a deviation of 593 times.
        assertEquals(0, error);
        assertEquals(1667, two, 593);
        assertEquals(3334, three, 593);
        assertEquals(5000, four, 593);
        assertEquals(6666, five, 593);
        assertEquals(8333, six, 593);
        assertEquals(10000, seven, 593);
        assertEquals(8333, eight, 593);
        assertEquals(6666, nine, 593);
        assertEquals(5000, ten, 593);
        assertEquals(3334, eleven, 593);
        assertEquals(1667, twelve, 593);

    }

    /**
     * Tests if the getSum() method works in the Shaker class
     */
    @Test
    public void getSumTest() throws Exception {

        // Calls the Shake() method in the class Shaker, through the object "shake".
        shaker.shake();

        // Checks if the sum given by the Shaker class is between 2 and 12.
        // Returns a boolean whether it works.
        int expected = shaker.getDice()[0].getFaceValue() + shaker.getDice()[1].getFaceValue();
        int actual = shaker.getSum();

        assertEquals(expected, actual);
    }

    /**
     * Tests if the Die objects can be returned
     */
    @Test
    public void getDiceTest(){
        for (Die thisDie:shaker.getDice()) {
            assertNotNull(thisDie);
        }
    }

    @Test
    public void doubleIncrement(){
        shaker.getDice()[0].setFaceValue(1);
        shaker.getDice()[1].setFaceValue(1);
        shaker.incrementDoublesInARow();
        assertEquals(shaker.getDoublesInARow(),1);
    }




}