package Game.ChanceCards;

import java.util.Random;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Timothy Stoltzner Rasmussen
 * @version v.0.1
 */

public class ChanceDeck {

    private final Random rand = new Random();
    ChanceCard[] ChanceCards;

    ChanceDeck() {

        //.FileReader fileReader = new FileReader("lol");
        //this.ChanceCards = fileReader.getCards(46);

    }

    //Adding The function to add the card

    public ChanceCard getCard() {

        int randomNumber = rand.nextInt(46);

        return ChanceCards[randomNumber];

    }

}


