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

    /**
     * The Jail constructor.
     * @param name The name of the Jail.
     * @param groupID The groipID.
     * @param color The Color.
     */
    public Jail(String name, int groupID, Color color) {
        super(name, groupID, color);
    }

    /**
     * Add player to jail.
     * @param player The player to add.
     */
    public static void addPlayer(Player player) {
        jailedPlayers.add(player);
    }

    /**
     * Remove player from jail.
     * @param player The player to remove.
     */
    public static void removePlayer(Player player) {
        jailedPlayers.remove(player);
    }

    /**
     * Check if player is jailed.
     * @param player The player to check.
     * @return is he jailed?
     */
    public static boolean isJailed(Player player) {
        return jailedPlayers.contains(player);
    }

    /** {@inheritDoc} */
    @Override
    public void landOnField(Player player) {
    }

    /** {@inheritDoc} */
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
