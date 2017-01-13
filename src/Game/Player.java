package Game;


import Game.ChanceCards.JailCard;

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
    private int onField = 1;
    private int roundsInJail = 0;
    private ArrayList<JailCard> jailCards;
    private boolean extraTurn = false;

    //
    public Player(String playerName) {
        name = playerName;
        account = new Account();
        jailCards = new ArrayList<>();

    }

    /**
     * Getter for property 'realEstateValue'.
     *
     * @return Value for property 'realEstateValue'.
     */
    public int getRealEstateValue() {

        int[] ownedHH = GameController.getGameBoard().getNumberOfOwnedHH(this);

        return ownedHH[0] + ownedHH[1] +
                GameController.getGameBoard().getNumOfOwnedFields(this) +
                getBalance();
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for property 'onField'.
     *
     * @return Value for property 'onField'.
     */
    public int getOnField() {
        return onField;
    }

    /**
     * Setter for property 'onField'.
     *
     * @param onField Value to set for property 'onField'.
     */
    public void setOnField(int onField) {
        this.onField = onField;
    }

    public void addBalance(int balance) {

        account.addBalance(balance);
        BoundaryController.updateBalance(this);
    }

    /**
     * Getter for property 'balance'.
     *
     * @return Value for property 'balance'.
     */
    public int getBalance() {
        return account.getBalance();
    }

    /**
     * Getter for property 'outOfJailCards'.
     *
     * @return Value for property 'outOfJailCards'.
     */
    public int getOutOfJailCards() {
        return jailCards.size();
    }


    /**
     * Getter for property 'jailCardList'.
     *
     * @return Value for property 'jailCardList'.
     */
    public ArrayList<JailCard> getJailCardList() {
        return jailCards;
    }

    public void addOutOfJailCards(JailCard jailCard) {
        jailCards.add(jailCard);
    }

    public void removeOutOfJailCard() {
        jailCards.remove(0);
    }

    /**
     * Getter for property 'roundsInJail'.
     *
     * @return Value for property 'roundsInJail'.
     */
    public int getRoundsInJail() {
        return roundsInJail;
    }

    /**
     * Getter for property 'account'.
     *
     * @return Value for property 'account'.
     */
    public Account getAccount() {
        return this.account;
    }

    public void addRoundsInJail(int rounds) {
        roundsInJail += rounds;
    }

    /**
     * Getter for property 'extraTurn'.
     *
     * @return Value for property 'extraTurn'.
     */
    public boolean getExtraTurn() {
        return this.extraTurn;
    }

    /**
     * Setter for property 'extraTurn'.
     *
     * @param extraTurn Value to set for property 'extraTurn'.
     */
    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", onField=" + onField +
                ", roundsInJail=" + roundsInJail +
                ", jailCards=" + jailCards +
                ", extraTurn=" + extraTurn +
                '}';
    }
}
