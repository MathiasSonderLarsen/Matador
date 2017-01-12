package Game.ChanceCards;


import java.io.FileNotFoundException;
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
        //Game.FileReader fileReader = null;
        //fileReader = new FileReader("chanceCards.txt");
        //ChanceCards = fileReader.getLineStrings().;

        ChanceCards.add(new MoneyCard("eeeee", -3000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", -3000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 0, 500, 2000));
        ChanceCards.add(new MoneyCard("eeeee", -200, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", -1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", -1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", -2000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", -200, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 0, 800, 2300));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 200, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 3000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 3000, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 500, 0, 0));
        ChanceCards.add(new MoneyCard("eeeee", 1000, 0, 0));
        ChanceCards.add(new MoveCard("eeeee", 3, false));
        ChanceCards.add(new MoveCard("eeeee", -3, false));
        ChanceCards.add(new MoveCard("eeeee", 1, true));
        ChanceCards.add(new MoveCard("eeeee", 25, true));
        ChanceCards.add(new MoveCard("eeeee", 12, true));
        ChanceCards.add(new MoveCard("eeeee", 40, true));
        ChanceCards.add(new TotalValueCard("eeeee"));
        ChanceCards.add(new MoveCard("eeeee", 3, false));
        ChanceCards.add(new MoveCard("eeeee", -3, false));
        ChanceCards.add(new JailCard("eeeee"));
        ChanceCards.add(new JailCard("eeeee"));
        ChanceCards.add(new MoveCard("eeeee", -3, false));

    }

    public ChanceCard getCard() {

        int randomNumber = rand.nextInt(ChanceCards.size());
        ChanceCard chosen = ChanceCards.get(randomNumber);

        if (chosen instanceof JailCard) {

            removeJailCard(chosen);
        }

        return chosen;

    }


    private void removeJailCard(ChanceCard jailCard) {
        ChanceCards.remove(jailCard);
    }

    public void addJailCard(ChanceCard jailCard) {
        ChanceCards.add(jailCard);
    }

}


