package Game.ChanceCards;

import Game.Player;

/**
 * MoneyTransfer does....blabla
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
public class MoneyTransfer extends ChanceCard {

    private int amount;

    public MoneyTransfer(String name, String description, int amount) {
        super(name, description);
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public void action(Player user) {

    }
}
