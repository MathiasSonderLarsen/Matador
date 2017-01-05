package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Keeps a list of the jailed players and removes any player who gets out of jail
 * <p>
 * Bugs: none known
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.3
 */


public class Jail{
    public Jail(String name){
        super(name);
    }
    private ArrayList<Player> jailedPlayers;

    public void landOnField(Player player) {
    }

    private void isJailed(){
        jailedPlayer.push(player)
    }

    public boolean getIsJailed(Player player){
        return jailedPlayers.contains(player);
    }
}
