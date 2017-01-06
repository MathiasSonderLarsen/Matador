package Game;

/**
 * MoveField does....blabla
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class MoveField extends ChanceCard{

    private int moveAmount;

    public MoveField(String name, String description, int moveAmount){
        super(name, description);
    }

    public int getMoveAmount() {
        return moveAmount;
    }
}
