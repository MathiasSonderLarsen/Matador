package Test;

import Game.Shaker;

import java.util.Arrays;

/**
 * Created by Matt_Lab on 10/01/2017.
 */
public class FakeShaker extends Shaker {
    int[] die1 = {2, 3, 6, 2, 1, 1, 3, 6, 3, 6, 2, 4, 5, 4, 1, 4, 5, 1, 4, 6, 5, 6, 5, 6, 1, 5, 2, 2, 4, 5, 6, 6, 2, 3, 6, 3, 5, 1, 2, 2, 6};
    int[] die2 = {4, 4, 4, 2, 2, 3, 2, 6, 1, 3, 1, 6, 6, 2, 3, 3, 5, 2, 6, 5, 3, 6, 6, 6, 3, 3, 1, 2, 6, 6, 6, 6, 2, 3, 3, 6, 6, 1, 3, 2, 6};

    int i = 0;

    public FakeShaker(int dieCount) {
        super(dieCount);
    }

    @Override
    public void shake() {
        getDice()[0].setFaceValue(die1[i]);
        getDice()[1].setFaceValue(die2[i++]);
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
