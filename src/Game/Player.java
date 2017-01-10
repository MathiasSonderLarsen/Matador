package Game;


/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */

public class Player {

    private final String name;
    private final Account account;
    private int realEstateValue = 0;
    private int onField = 1;
    private int outOfJailCards = 0;
    private int roundsInJail = 0;

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

    }

    public int getRealEstateValue() {
        return realEstateValue;
    }

    public void addRealEstateValue(int newRealEstateValue) {
        this.realEstateValue = realEstateValue + newRealEstateValue;
    }

    // Returns the name
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
        return outOfJailCards;
    }

    public void setOutOfJailCards(int cardAmount) {
        this.outOfJailCards = outOfJailCards + cardAmount;
    }

    public Account getAccount() {
        return this.account;
    }

    public int getRoundsInJail() {
        return roundsInJail;
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
