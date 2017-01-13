package Game.ChanceCards;


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


    /** Constructs a new ChanceDeck. */
    public ChanceDeck() {

        // TODO: 11-01-2017 Implement FileReader
        //Game.FileReader fileReader = null;
        //fileReader = new FileReader("chanceCards.txt");
        //ChanceCards = fileReader.getLineStrings().;

        ChanceCards.add(new MoneyCard("pay3000car1", -3000, 0, 0));
        ChanceCards.add(new MoneyCard("pay3000car2", -3000, 0, 0));
        ChanceCards.add(new MoneyCard("payperhousehotel1", 0, 500, 2000));
        ChanceCards.add(new MoneyCard("pay200parking", -200, 0, 0));
        ChanceCards.add(new MoneyCard("pay1000carinsurance", -1000, 0, 0));
        ChanceCards.add(new MoneyCard("pay1000redlight", -1000, 0, 0));
        ChanceCards.add(new MoneyCard("pay2000dentist", -2000, 0, 0));
        ChanceCards.add(new MoneyCard("pay200cigarette", -200, 0, 0));
        ChanceCards.add(new MoneyCard("payperhouhotel2", 0, 800, 2300));
        ChanceCards.add(new MoneyCard("get1000stock1", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get1000stock2", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get1000stock3", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get1000raise", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get200produce", 200, 0, 0));
        ChanceCards.add(new MoneyCard("get1000premium1", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get1000premium2", 1000, 0, 0));
        ChanceCards.add(new MoneyCard("get3000quarterlytax", 3000, 0, 0));
        ChanceCards.add(new MoneyCard("get500lottery", 500, 0, 0));
        ChanceCards.add(new MoneyCard("get1000tip", 1000, 0, 0));
        ChanceCards.add(new MoveCard("move3forward", 3, false));
        ChanceCards.add(new MoveCard("move3backwards", -3, false));
        ChanceCards.add(new MoveCard("movetostart", 1, true));
        ChanceCards.add(new MoveCard("movetogroeningen", 25, true));
        ChanceCards.add(new MoveCard("movetoalle", 12, true));
        ChanceCards.add(new MoveCard("movetoraadshuspladsen", 40, true));
        ChanceCards.add(new TotalValueCard("legate"));
        ChanceCards.add(new JailCard("getoutofjail"));
        ChanceCards.add(new JailCard("getoutofjail"));
        ChanceCards.add(new ToJailCard("gotojail"));
        ChanceCards.add(new ToJailCard("gotojail"));
        ChanceCards.add(new GoToNearestFleet("nearestfleet"));
        ChanceCards.add(new GoToNearestFleet("nearestfleet"));



    }

    /**
     * Getter for property 'card'.
     *
     * @return Value for property 'card'.
     */
    public ChanceCard getCard() {

        int randomNumber = rand.nextInt(ChanceCards.size());
        ChanceCard chosen = ChanceCards.get(randomNumber);

        if (chosen instanceof JailCard) {

            removeJailCard(chosen);
        }

        return chosen;

    }

    /**
     * Remove jailcard from the deck of cards.
     * @param jailCard
     */
    private void removeJailCard(ChanceCard jailCard) {
        ChanceCards.remove(jailCard);
    }

    /**
     * Add a jailcard to the deck of cards.
     * @param jailCard
     */
    public void addJailCard(ChanceCard jailCard) {
        ChanceCards.add(jailCard);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ChanceDeck{" +
                ", ChanceCards=" + ChanceCards +
                '}';
    }
}


