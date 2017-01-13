package Game.Fields;


import Game.BoundaryController;
import Game.Language;
import Game.Player;
import desktop_fields.Tax.Builder;

import java.awt.*;
import java.util.Objects;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Casper Bodskov
 * @version v.0.3
 */

public class Tax extends Field {

    private final int taxAmount;
    private final float taxRate;
    private int relativeTax;

    /**
     * @param name      The name of the Field
     * @param taxAmount The permanent tax on the Field
     */
    public Tax(String name, int groupID, Color color, int taxAmount, float taxRate) {
        super(name, groupID, color );
        this.taxAmount = taxAmount;
        this.taxRate = taxRate;
    }

    /**
     * Gets the permanent amount of tax the player needs to pay
     */
    public int getTaxAmount() {
        return this.taxAmount;
    }

    /**
     * Calculates the tax the player needs to pay
     *
     * @param totalValue The total value of the player
     * @return The amount of money the player needs to pay
     */
    public int calculateRelativeTax(int totalValue) {
        return (int) (totalValue * -taxRate);
    }


    public float getTaxRate() {
        return this.taxRate;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a field
     *
     * @param player The player that lands on the field
     */
    @Override
    public void landOnField(Player player) {

        int tax = calculateRelativeTax(player.getRealEstateValue() + player.getBalance());

        String question = Language.getString("paytax1") + " " + this.taxAmount + " " + Language.getString("paytax2") + " " + "10% (" + tax + ")";
        String answer1 = taxAmount + "";
        String answer2 = "10%";

        if (taxRate != 1.0f && Game.BoundaryController.getUserSelection(question, answer1, answer2) == answer2) {
            player.addBalance(calculateRelativeTax(player.getRealEstateValue()+player.getBalance()));

        } else {
            player.addBalance(-this.taxAmount);
        }
    }



    @Override
    public desktop_fields.Tax convertToGUI() {
        Builder a = new Builder()
                .setTitle(name)
                .setFgColor(Color.black)
                .setBgColor(color)
                .setSubText(taxAmount + "");
        return a.build();
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxAmount=" + taxAmount +
                ", taxRate=" + taxRate +
                ", relativeTax=" + relativeTax +
                '}';
    }
}
