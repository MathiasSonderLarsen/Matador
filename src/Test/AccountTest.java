package Test;

import Game.Account;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Account class
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
public class AccountTest {

    private Account account;


    @BeforeClass
    public static void setUpBeforeClass() {

    }

    @Before
    public void createAccount() {

        account = new Account();
    }

    @Test
    public void testEntities() {
        assertNotNull(account);
        assertTrue(account instanceof Account);
    }

    @Test
    public void startingBalance() {

        int balance = account.getBalance();

        assertEquals(30000, balance);
    }

    @Test
    public void changeBalance() {

        int balanceAdded = 1000;

        int oldBalance = account.getBalance();

        account.addBalance(1000);

        int newBalance = account.getBalance();

        assertEquals(balanceAdded + oldBalance, newBalance);

    }


}
