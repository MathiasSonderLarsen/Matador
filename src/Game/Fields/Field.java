package Game.Fields;


import Game.Player;

import java.awt.*;

/**
 * Field defines common attribues and methods for all the Field types
 * <p>
 * Bugs: none known
 *
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public abstract class Field {

    protected final int groupID;
    protected final Color color;
    protected String name;

    /**
     * Constructs a Field
     *
     * @param name  The name of the Field
     * @param color
     */
    public Field(String name, int groupID, Color color) {

        this.name = name;
        this.groupID = groupID;
        this.color = color;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param newName Value to set for property 'name'.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Getter for property 'groupID'.
     *
     * @return Value for property 'groupID'.
     */
    public int getGroupID() {
        return groupID;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a Field
     *
     * @param player The player that lands on the Field
     */
    public abstract void landOnField(Player player);

    /**
     * Converts the field to a fieldtype the GUI can interact with.
     * @return the UI field.
     */
    public abstract desktop_fields.Field convertToGUI();

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Field{" +
                "groupID=" + this.groupID +
                ", name='" + this.name + '\'' +
                '}';
    }
}
