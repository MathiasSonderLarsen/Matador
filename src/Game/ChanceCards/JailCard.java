package Game.ChanceCards;

import Game.Player;

/**
 * Get-out-of-jail-free card
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
public class JailCard extends ChanceCard {

    public JailCard(String description) {
        super(description);

    }

    /** {@inheritDoc} */
    @Override
    public void action(Player user) {
        user.addOutOfJailCards(this);
    }
}
