package Test;

import Game.Shaker;

import java.util.Arrays;

/**
 * Created by Matt_Lab on 10/01/2017.
 */
public class FakeShaker extends Shaker {
    int[] die1 = {1, 4, 6, 3, 5, 1, 5, 6, 3,};
    int[] die2 = {2, 2, 6, 2, 6, 3, 5, 6, 1,};

    int i = 0;

    public FakeShaker(int dieCount) {
        super(dieCount);
    }

    @Override
    public void shake() {
        if (i < die1.length) {
            getDice()[0].setFaceValue(die1[i]);
            getDice()[1].setFaceValue(die2[i++]);
            incrementDoublesInARow();

        }else {
            super.shake();
        }
    }

    @Override
    public String toString() {
        return "FakeShaker{" +
                "die1=" + Arrays.toString(die1) +
                ", die2=" + Arrays.toString(die2) +
                ", i=" + i +
                '}';
    }
}
