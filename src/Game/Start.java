package Game;

/**
 * Start class
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.3
 */
public class Start extends Field {

    final static int START_BONUS = 4000;

    public Start(String name) {
        super(name);
    }

    @Override
    public void landOnField(Player player) {

    }

    public int getStartBonus() {
        return START_BONUS;
    }
}
