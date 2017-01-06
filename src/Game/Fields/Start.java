package Game.Fields;


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

    public Start(String name, int groupID) {
        super(name, groupID);
    }

    @Override
    public void landOnField(Game.Player player) {

    }

    public int getStartBonus() {
        return START_BONUS;
    }
}
