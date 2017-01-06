package Game;

/**
 *
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.2
 */
public class ChanceCard {

    protected String name;
    protected String description;

    public ChanceCard(String name, String description){
        this.name=name;
        this.description=description;
    }
    public String getDescription(){

        return description;
    }

    public String getName(){

        return name;
    }
}
