package Game.Fields;


import Game.BoundaryController;
import Game.GameController;
import Game.Language;
import Game.Player;

import java.awt.*;
import java.util.Objects;

/**
 * Ownable class
 * <p>
 * Bugs: none known
 *
 * @author Timothy Rasmussen
 * @author Lasse Dyrsted
 * @version v.0.2
 */
public abstract class Ownable extends Field {

    protected final int price;
    protected Player owner;

    /**
     * The constructor of the Ownable type
     *
     * @param name  The name of the Field
     * @param color
     * @param price The price of the Field
     */
    public Ownable(String name, int groupID, Color color, int price) {
        super(name, groupID, color);
        this.price = price;

    }

    /**
     * Calculated the Prawn value
     *
     * @return the money amount you get for prawning the ownable.
     */
    private int calculatePawnValue() {
        return price / 2;
    }

    public int getPawnPrice() {
        return calculatePawnValue();
    }

    /**
     * Gets the price of the Field
     *
     * @return the price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Make sure all subclasses implement this method
     */
    protected abstract int getRent();

    /**
     * Gets the owner of an ownable Field
     *
     * @return returns the owner.
     */
    public Game.Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of an ownable field
     *
     * @param owner The new owner
     */
    public void setOwner(Game.Player owner) {
        this.owner = owner;
        BoundaryController.setOwner(GameController.getGameBoard().getFieldPos(this), owner.getName());
    }

    public void removeOwner() {
        BoundaryController.removeOwner(GameController.getGameBoard().getFieldPos(this));
    }

    /**
     * Runs when a player lands on the Field
     *
     * @param player The player that lands on the Field
     */
    public void landOnField(Game.Player player) {
        // TODO: 05-01-2017 add code

        // No one owns the field and the player has the money to buy it
        if ((owner == null) && (price <= player.getBalance())) {


            final String question = player.getName() + (Language.getString("turn1") + " " +
                    Language.getString("buy1") + " " + getName() + " " + Language.getString("buy2") + " " + price + " " + Language.getString("point") + " ?");

            final String answer1 = Language.getString("no");
            final String answer2 = Language.getString("yes");

            String stringA = BoundaryController.getUserButtonPressed(question, answer1, answer2);
            // Checks whether the player wants to buy
            if (Objects.equals(stringA, answer2)) {

                player.addBalance(-price);
                this.setOwner(player);
                BoundaryController.showMessage(player.getName() + " " + Language.getString("bought") + " " + getName());

            }
        }
        //Someone else owns the field
        if ((!Objects.equals(owner, player)) && (owner != null) && !Jail.isJailed(owner)) {

            if ((this instanceof Territory) && GameController.getGameBoard().playerOwensAllInGroup((Territory) this, player)) {

                player.addBalance(-getRent()*2);
                owner.addBalance(getRent()*2);
            }else {
                player.addBalance(-getRent());
                owner.addBalance(getRent());
            }
        }

    }

    @Override
    public String toString() {
        return "Ownable{" +
                "price=" + price +
                ", owner=" + owner +
                '}';
    }
}
