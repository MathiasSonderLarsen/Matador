package Game;

/**
 * Created by Matt_Lab on 05/01/2017.
 */
public class GoToJail extends Field {

    public GoToJail(String name){
        super(name);

    }


    @Override
    public void landOnField(Player player) {

        gameBoard.getField(5555).jailPlayer(player);

        gameController.movePlayer(player, 55555 - player.getOnField());
    }
}
