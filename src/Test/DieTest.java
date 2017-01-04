package Test;

import Game.Die;
import Game.InterfaceController;
import Game.Language;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests the Die class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen, Timothy Rasmussen.
 * @version v.0.2
 */

public class DieTest {

    /**
     * Setting the private Die object die.
     */

    private Die die;

    /**
     * Setup for test.
     */

    @BeforeClass
    public static void setUpBeforeClass() {

        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);

        Language.setLanguage("english");

    }

    /**
     * Creates the die object.
     */

    @Before
    public void createDice() {

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

}
