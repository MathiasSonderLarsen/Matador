package Game.ChanceCards;

import Game.Game;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Timothy Stoltzner Rasmussen
 * @version v.0.2
 */

public class ChanceDeck {

    private final Random rand = new Random();
    ArrayList<ChanceCard> ChanceCards = new ArrayList<>();


    public ChanceDeck() {

        // TODO: 11-01-2017 Implement FileReader
        //.FileReader fileReader = new FileReader("lol");
        //this.ChanceCards = fileReader.getCards(46);

    }

    public ChanceCard getCard() {

        int randomNumber = rand.nextInt(46);
        ChanceCard chosen = ChanceCards.get(randomNumber);

        if(chosen instanceof JailCard){

            removeJailCard(chosen);
        }

        return chosen;

    }


    private void removeJailCard(ChanceCard jailCard){ ChanceCards.remove(jailCard); }

    public void addJailCard(ChanceCard jailCard){ ChanceCards.add(jailCard); }

}


