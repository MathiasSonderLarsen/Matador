package Game.Fields;


/**
 * Handles the chance card pile
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
public class Chance extends Field {
    private String name;

    public Chance(String name, int groupID) {

        super(name, groupID);

    }

    public String getName() {
        return this.name;
    }

    @Override
    public void landOnField(Game.Player player) {
        // TODO: 05-01-2017 implement
    }
}
