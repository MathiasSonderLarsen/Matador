package Game;

/**
 * Shaker class, contains the Die objects
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.4
 */
public class Shaker {

    private final Die[] dice;
    //Initializing variables
    private int sum;
    private int doublesInARow = 0;


    /**
     * Creates the Dice in the shaker
     *
     * @param dieCount Amount of Dice to create
     */
    public Shaker(int dieCount) {
        dice = new Die[dieCount];
        for (int i = 0; i < dieCount; i++) {
            dice[i] = new Die();
        }
    }

    /**
     * Rolls all the Dice
     */
    public void shake() {
        sum = 0;
        for (Die die : this.dice) {
            die.roll();
            sum += die.getFaceValue();
        }
        incrementDoublesInARow();
    }

    /**
     * Gets the sum of the rolled Dice
     */
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * Gets the Dice objects in the Shaker.
     */
    public Die[] getDice() {
        return dice;
    }

    /**
     * Checks how many times in a row the Die results in doubles (1-1,2-2,3-3...)
     */

    public int getDoublesInARow() {
        return doublesInARow;
    }

    /**
     * Increments the doubles in a row counter
     */

    public void incrementDoublesInARow() {

            if (dice[0].getFaceValue() == dice[1].getFaceValue()) {

                doublesInARow++;
            }
            else {
                doublesInARow=0;
            }

        }



    }




