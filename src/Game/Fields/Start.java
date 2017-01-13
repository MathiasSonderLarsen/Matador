package Game.Fields;


import java.awt.*;

/**
 * Start class
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.3
 */
public class Start extends Field {

    private final static int START_BONUS = 4000;

    public Start(String name, int groupID, Color color) {
        super(name, groupID, color);
    }

    /**
     * Getter for property 'startBonus'.
     *
     * @return Value for property 'startBonus'.
     */
    public static int getStartBonus() {
        return START_BONUS;
    }

    /** {@inheritDoc} */
    @Override
    public void landOnField(Game.Player player) {

    }

    /** {@inheritDoc} */
    public desktop_fields.Start convertToGUI() {
        desktop_fields.Start.Builder a = new desktop_fields.Start.Builder()
                .setTitle(name)
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText(Start.START_BONUS + "");
        return a.build();
    }
}
