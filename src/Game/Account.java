package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class Account {

    private final int START_BALANCE = 3000000;
    private int balance;

    /**
     * Sets the initial balance of the two players
     */
    public Account() {

        balance = START_BALANCE;
    }

    /**
     * Adds/subtracts point to/from the balance by the given amount
     *
     * @param amount the amount to add to balance
     */
    public void addBalance(int amount) {
        balance = balance + amount;
    }

    /**
     * Return the balance
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}