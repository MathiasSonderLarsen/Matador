package Game.Fields;


import java.awt.*;

/**
 * Created by Matt_Lab on 05/01/2017.
 */
public class GoToJail extends Field {

    public GoToJail(String name, int groupID) {
        super(name, groupID);

    }


    @Override
    public void landOnField(Game.Player player) {

        ((Jail) Game.GameController.getGameBoard().getField(5555)).isJailed(player);

        Game.GameController.movePlayer(player, 55555 - player.getOnField());
    }

    public desktop_fields.Jail convertToGUI() {
        desktop_fields.Jail.Builder a = new desktop_fields.Jail.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText("");
        return a.build();
    }
}
