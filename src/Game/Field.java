package Game;

/**
 * Field defines common attribues and methods for all the Field types
 * <p>
 * Bugs: none known
 *
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public abstract class Field {

    private final int number;
    private String name;

    /**
     * Constructs a Field
     *
     * @param number the id of the Field
     * @param name   The name of the Field
     */
    public Field(int number, String name) {

        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a Field
     *
     * @param player The player that lands on the Field
     */
    public abstract void landOnField(Player player);

}
