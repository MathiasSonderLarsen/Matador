package Game;

/**
 * Start class
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.2
 */
public class Start extends Field {

    static final int START_BONUS = 4000;

    public Start(String name) {
        super(name);
    }

    @Override
    public void landOnField(Player player) {

    }

    // TODO: 05-01-2017 Implement Start bonus.
}
