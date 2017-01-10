package Test;

import Game.Shaker;

/**
 * Created by Matt_Lab on 10/01/2017.
 */
public class FakeShaker extends Shaker {
    int[] d1 = {2,2,2,2,2,2,2,2};
    int[] d2 = {1,1,1,1,1,1,1,1};
    int i = 0;

    public FakeShaker(int dieCount){
        super(dieCount);
    }

    @Override
    public void shake(){
        getDice()[0].setFaceValue(d1[i]);
        getDice()[1].setFaceValue(d2[i++]);
    }
}
