package Test;

import Game.*;
import Game.Fields.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.smartcardio.Card;

import static org.junit.Assert.*;

/**
 * Created by Matt_Lab on 06012017.
 v.0.1
 */


public class GameBoardTest {

    Player player1;
    Player player2;
    GameBoard board;
    //CardDeck deck;

    @BeforeClass
    public static void setUpBeforeClass() {

        BoundaryController.setInterfaceMode(BoundaryController.Mode.Test);
    }
    @Before
    public void setUp() throws Exception {

        player1 = new Player("player1");
        player2 = new Player("player2");
        board = GameController.getGameBoard();
        //deck = new CardDeck();
    }

    @Test
    public void testEntities() throws Exception {

        /**
         * test data
         */


        Class[] type = {Start.class, Territory.class, Chance.class, Territory.class, Tax.class, Fleet.class, Territory.class,
                Chance.class, Territory.class, Territory.class, Jail.class, Territory.class, Brewery.class, Territory.class,
                Territory.class, Fleet.class, Territory.class, Chance.class, Territory.class, Territory.class, FreeParking.class,
                Territory.class, Chance.class, Territory.class, Territory.class, Fleet.class, Territory.class, Territory.class,
                Brewery.class, Territory.class, GoToJail.class, Territory.class, Territory.class, Chance.class, Territory.class,
                Fleet.class, Chance.class, Territory.class, Tax.class, Territory.class};

        String[] name = {"Start", "Rødovervej","Prøv lykken","Hvidovervej","Indkomstskat","Scandlines","Roskildevej","Prøv lykken",
                "Valby Langgade","Allégade","Fængsel","Frederiksberg Allé","Tuborg","Büowsvej","Gl. Kongevej","Mols-Linien",
                "Bernstorffsvej","Prøv lykken","Hellerupvej","Strandvejen","Parkering","Trianglen","Prøv lykken","Østerbrogade",
                "Grønningen","Scandlines","Bredgade","Kgs. Nytorv","CocaCola","Østergade","De fængsles","Amagertorv2","Vimmelskarftet",
                "Prøv lykken","Nygade","Scandlines","Prøv lykken","Frederiksberg gade","Indkomstskat","Rådhuspladsen"};

        int[] group = {1,2,3,2,4,5,6,3,6,6,7,8,9,8,8,5,10,3,10,10,11,12,3,12,12,5,13,13,9,13,10,14,14,3,14,5,3,15,4,15};

        int[] price = {1200,1200,2000,2000,2400,2800,2800,3200,3600,3600,4000,4400,4400,4800,5200,5200,5600,6000,6000,6400,7000,8000};
        /**
         * the tests
         */

        assertNotNull(player1);
        assertNotNull(player2);
        assertNotNull(player1.getAccount());
        assertNotNull(player2.getAccount());
        assertNotNull(board);
        //assertNotNull(deck);


        for (int i=1 ; i <= board.getBoard().length ; i++){
            System.out.println(i);
            assertNotNull(board.getField(i));
            assertTrue(board.getField(i) instanceof Field);

            assertEquals(true, board.getField(i).getClass() == type[i-1]);

            System.out.println(board.getField(i).getName());
            System.out.println(name[i-1]);

            String actual = board.getField(i).getName();
            String expected = name[i-1];
            assertEquals(expected,actual);

            System.out.println(board.getField(i).getGroupID());
            System.out.println(group[i-1]);

            int actualint = board.getField(i).getGroupID();
            int expectedint = group[i-1];
            assertEquals(expectedint,actualint);

            if(board.getField(i) instanceof Territory){
                actualint = ((Territory) board.getField(i)).getPrice();
                expectedint = price[i-1];
                assertEquals(expectedint,actualint);
            }

            if(board.getField(i) instanceof Fleet){
                expectedint = 4000;
                actualint = ((Fleet) board.getField(i)).getPrice();
                assertEquals(expectedint,actualint);
            }

//            if(type[i-1] == Territory.class){
//                System.out.println("hej");
//            }

        }

//        for(int i=0 ; i= deck.getCardDeck().length ; i++){
//            assertNotNull(deck.getCard(i));
//            assertTrue(deck.getCard(i) instanceof Card);
//            System.out.println(i);
//        }

        assertTrue(player1 instanceof Player);
        assertTrue(player2 instanceof Player);
        assertTrue(player1.getAccount() instanceof Account);
        assertTrue(player2.getAccount() instanceof Account);



    }



    @Test
    public void getBoard() throws Exception {

    }

    @Test
    public void loadBoardFromFile() throws Exception {

    }

    @Test
    public void getField() throws Exception {

    }

    @Test
    public void getNumInGroupOwned() throws Exception {

    }

    @Test
    public void getNumberOfPropertiesInGroup() throws Exception {

    }

    @Test
    public void deleteOwnership() throws Exception {

    }

    @Test
    public void playerOwnsAllInGroup() throws Exception {

    }

}