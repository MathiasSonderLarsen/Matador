package Game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by timot on 06-01-2017.
 */
public class FileReader {

    String fileName;

    FileReader(String fileName) {

        fileName = this.fileName;

    }


    public void loadfromFile(fileName) {

    }
}







    public Field[] loadBoardFromFile(fileName) {

        try {
            Gson g = new Gson();

            Field[] loadedFields = new Field[21];

            Path relativePath = Paths.get("resources\\" + fileName);
            String absolutePath = relativePath.toAbsolutePath().toString();

            BufferedReader fileReader = new BufferedReader(new java.io.FileReader(absolutePath));

            String line;
            int i = 0;
            while ((line = fileReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                loadedFields[i] = g.fromJson(lineSplit[1], (Type) Class.forName("Game." + lineSplit[0]));
                loadedFields[i].setName(Language.getString(loadedFields[i].getName()));
                i++;

            }
        }
    }