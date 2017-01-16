package Game.ChanceCards;

import Game.Player;

/**
 * Created by ldylab on 11-01-2017.
 */
public class TotalValueCard extends ChanceCard {


    public TotalValueCard(String description) {
        super(description);
    }

    /** {@inheritDoc} */
    @Override
    public void action(Player user) {
        if (user.getRealEstateValue() >= 15000) {
            user.addBalance(40000);
        }
    }
}
