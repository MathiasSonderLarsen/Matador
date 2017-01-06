package Game.Fields;


import Game.Player;

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

    private static ArrayList<Player> jailedPlayers = new ArrayList<Player>();


    public Jail(String name, int groupID) {
        super(name, groupID);
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

    public void landOnField(Player player) {
    }

    public desktop_fields.Street convertToGUI() {
        desktop_fields.Street.Builder a = new desktop_fields.Street.Builder()
                .setTitle(this.getName())
                .setBgColor(Color.red)
                .setSubText("");
        return a.build();
    }

}
