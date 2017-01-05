package Game;


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
    public Tax(String name, int taxAmount, float taxRate) {
        super(name);
        this.taxAmount = taxAmount;
        this.taxRate = taxRate;
    }

    /**
     * Gets the permanent amount of tax the player needs to pay
     */
    public int getTaxAmount() {
        return taxAmount;
    }

    /**
     * Calculates the tax the player needs to pay
     *
     * @param totalValue The total value of the player
     * @return The amount of money the player needs to pay
     */
    private calcuateRelativeTax(int totalValue) {
        relativeTax = (int) (totalValue * -taxRate);
    }



    public float getTaxRate() {
        return taxRate;
    }

    /**
     * Handles the stuff that needs to happen when a player lands on a field
     *
     * @param player The player that lands on the field
     */
    public void landOnField(Player player) {

        calcuateRelativeTax(player.getRealEstateValue() + player.getBalance());

        final String question = (Language.getString("paytax1") + " " + taxAmount + " " + Language.getString("paytax2") + " " + "10% (" + calculatedTax + ")");
        final String answer1 = taxAmount + "";
        final String answer2 = "10%";

        if (taxRate != 1.0f && InterfaceController.getUserSelection(question, answer1, answer2) == answer2) {
            player.addBalance(relativeTax);

        } else {
            player.addBalance(-taxAmount);
        }

        //InterfaceController.showMessage(Language.getString("landed") + getName());

    }
}



/* Percent tax calculation
int tax = (int) value*(10.0f/100.0f)
where 10.0f is the percentage, value is the amount of points the player has
and tax is the final calculated tax.
Then
taxRate = -1
taxRate*tax= finalTaxation
- that with the player's points either here or in another class. (eg. account)
 */