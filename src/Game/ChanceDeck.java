package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author Timothy Stoltzner Rasmussen
 * @version v.0.1
 */

public class ChanceDeck {

    int cardsTotal = 46;
    ChanceCard[] ChanceCards;

    ChanceDeck() {

        FileReader fileReader = new FileReader("lol");
        this.ChanceCards = fileReader.getCards(46);

    }

    //Adding The function to add the card

    public void getCard() {

        

    }

}


