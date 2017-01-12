package Test;

import Game.Die;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Tests the Die class
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

public class DieTest {

    /**
     * Setting the private Die object die.
     */

    private Die die;

    /**
     * Creates the die object.
     */

    @Before
    public void setUp() {
        die = new Die();
    }


    // Declares variables
    @Test
    public void roll() {

        int value;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int wrongNumber = 0;

        /**
         * Rolls the die 60.000 times.
         * Counts how many times each value has been rolled.
         */

        for (int i = 0; i < 60000; i++) {
            die.roll();
            value = die.getFaceValue();
            // System.out.println(value + " ");
            switch (value) {
                case 1:
                    one++;
                    break;
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
                default:
                    wrongNumber++;
                    break;
            }

        }

        /**
         * Test of the program
         * Checks if all the values of the die (1-6), has been rolled and equal amount of times (10.000/60.000)
         * With a difference of 400 times.
         */

        assertEquals(0, wrongNumber);
        assertEquals(10000, one, 400);
        assertEquals(10000, two, 400);
        assertEquals(10000, three, 400);
        assertEquals(10000, four, 400);
        assertEquals(10000, five, 400);
        assertEquals(10000, six, 400);


    }

    @Test
    public void testEntities() {
        assertNotNull(die);
        assertTrue(die instanceof Die);
    }

    /**
     * Tests if setFaceValue and getFaceValue works.
     */
    @Test
    public void testFaceValue() {
        die.setFaceValue(5);
        assertEquals(5, die.getFaceValue());
    }


    @Override
    public String toString() {
        return "DieTest{" +
                "die=" + die +
                '}';
    }
}
