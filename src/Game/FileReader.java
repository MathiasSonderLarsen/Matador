package Game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Timothy Stoltzner Rasmussen
 * @version v.0.1
 */

public class FileReader {


    private Gson gson = new Gson();
    private BufferedReader bufferedReader;


    FileReader(String fileName) {

        try {
            this.bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Field[] getBoard(int AmountOfFields) {

        Field[] loadedFields = new Field[AmountOfFields];

        try {

            String line;
            int i = 0;


            while ((line = bufferedReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                loadedFields[i] = gson.fromJson(lineSplit[1], (Type) Class.forName("Game." + lineSplit[0]));
                i++;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return loadedFields;

    }

    public ChanceCard[] getCards(int AmountOfCards) {

        ChanceCard[] Cards = new ChanceCard [AmountOfCards];

        try {

            String line;
            int i = 0;


            while ((line = bufferedReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                Cards[i] = gson.fromJson(lineSplit[1], (Type) Class.forName("Game." + lineSplit[0]));
                i++;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return Cards;

    }

}