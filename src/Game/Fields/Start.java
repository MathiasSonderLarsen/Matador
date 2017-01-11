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

    final static int START_BONUS = 4000;

    public Start(String name, int groupID) {
        super(name, groupID);
    }

    @Override
    public void landOnField(Game.Player player) {

    }

    public static int getStartBonus() {
        return START_BONUS;
    }

    public desktop_fields.Start convertToGUI() {
        desktop_fields.Start.Builder a = new desktop_fields.Start.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                //.setFgColor(Color.red)
                .setSubText(getStartBonus() + "");
        return a.build();
    }
}
