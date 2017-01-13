package Game.ChanceCards;

import Game.Player;

/**
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.2
 */
public abstract class ChanceCard {

    protected String description;

    public ChanceCard(String description) {
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public abstract void action(Player user);

    @Override
    public String toString() {
        return "ChanceCard{" +
                "description='" + description + '\'' +
                '}';
    }
}
