package Game.Fields;


import java.awt.*;

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

    public desktop_fields.Chance convertToGUI() {
        desktop_fields.Chance.Builder a = new desktop_fields.Chance.Builder()
                .setBgColor(Color.black)
                .setFgColor(Color.green);
        return a.build();
    }
}
