package Game.Fields;


import Game.Player;
import desktop_fields.Jail.Builder;

import java.awt.*;
import java.util.ArrayList;

/**
 * Keeps a list of the jailed players and removes any player who gets out of jail
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.4
 */


public class Jail extends Field {

    private static final ArrayList<Player> jailedPlayers = new ArrayList<>();


    public Jail(String name, int groupID,Color color) {
        super(name, groupID, color);
    }

    public static void addPlayer(Player player) {
        jailedPlayers.add(player);
    }

    public static void removePlayer(Player player) {
        jailedPlayers.remove(player);
    }

    public static boolean isJailed(Player player) {
        boolean a = jailedPlayers.contains(player);
        return a;
    }

    @Override
    public void landOnField(Player player) {
    }

    @Override

    public desktop_fields.Jail convertToGUI() {
        Builder a = new Builder()
                .setTitle(name)
                .setFgColor(Color.white)
                .setBgColor(color)
                .setSubText("");
        return a.build();
    }

}
