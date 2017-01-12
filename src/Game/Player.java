package Game;


import Game.ChanceCards.ChanceCard;

import java.util.ArrayList;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.2
 */

public class Player {

    private final String name;
    private final Account account;
    private int realEstateValue = 0;
    private int onField = 1;
    private int outOfJailCards = 0;
    private int roundsInJail = 0;
    private ArrayList<ChanceCard> jailCards;

    /**
     * Setter for property 'extraTurn'.
     *
     * @param extraTurn Value to set for property 'extraTurn'.
     */
    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    private boolean extraTurn = false;

    //
    public Player(String playerName) {
        name = playerName;
        account = new Account();
        jailCards = new ArrayList<>();

    }

    public int getRealEstateValue() {

        int[] ownedHH = GameController.getGameBoard().getNumberOfOwnedHH(this);

        return ownedHH[0] + ownedHH[1] +
                GameController.getGameBoard().getNumOfOwnedFields(this) +
                getBalance();
    }


    public String getName() {
        return name;
    }

    public int getOnField() {
        return onField;
    }

    public void setOnField(int onField) {
        this.onField = onField;
    }

    public void addBalance(int balance) {

        account.addBalance(balance);
        BoundaryController.updateBalance(this);
    }

    public int getBalance() {
        return account.getBalance();
    }

    public int getOutOfJailCards() {
        return jailCards.size();
    }

    public ArrayList<ChanceCard> getJailCardList() {
        return jailCards;
    }

    public void addOutOfJailCards(ChanceCard jailCard) {
        jailCards.add(jailCard);
    }

    public void removeOutOfJailCard() {
        jailCards.remove(0);
    }

    public int getRoundsInJail() {
        return roundsInJail;
    }

    public Account getAccount() {
        return this.account;
    }

    public void addRoundsInJail(int rounds) {
        roundsInJail = roundsInJail + rounds;
    }

    public boolean getExtraTurn() {
        return this.extraTurn;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", realEstateValue=" + realEstateValue +
                ", onField=" + onField +
                ", outOfJailCards=" + outOfJailCards +
                ", roundsInJail=" + roundsInJail +
                ", extraTurn=" + extraTurn +
                '}';
    }
}
