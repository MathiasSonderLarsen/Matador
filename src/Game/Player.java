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
    private int onField = 0;
    private int outOfJailCards = 0;
    private int roundsInJail = 0;

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

    public int getRoundsInJail(){ return roundsInJail;
    }

    public void addRoundsInJail(int rounds){ roundsInJail = roundsInJail + rounds; }

}
