package Game.ChanceCards;

import Game.Fields.Jail;
import Game.Player;

/**
 * goToJail does....blabla
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
public class goToJail extends ChanceCard {

    public goToJail(String description) {
        super(description);
    }

    @Override
    public void action(Player user) {
        Jail.addPlayer(user);
    }
}