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

    public Start(String name, int groupID,Color color) {
        super(name, groupID,color );
    }

    @Override
    public void landOnField(Game.Player player) {

    }

    public int getStartBonus() {
        return START_BONUS;
    }

    public desktop_fields.Start convertToGUI() {
        desktop_fields.Start.Builder a = new desktop_fields.Start.Builder()
                .setTitle(name)
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText(START_BONUS + "");
        return a.build();
    }
}
