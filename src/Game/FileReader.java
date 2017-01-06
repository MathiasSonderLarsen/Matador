package Game;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Timothy Stoltzner Rasmussen
 * @version v.0.1
 */

public class FileReader {

    private String fileName;
    Gson gson = new Gson();
    BufferedReader bufferedReader;

    FileReader(String fileName) {

        this.fileName = fileName;

        try {
            this.bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void readFile() {


    }

}