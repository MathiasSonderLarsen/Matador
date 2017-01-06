package Game;

import javax.management.RuntimeErrorException;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Fetches the selected language
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt
 * @version v.0.1
 */
public class Language {

    private static ResourceBundle language;


    private Language() {
    }

    public static void setLanguage(String selectLanguage) {

        // Selects the language through the String variable "inputString"
        switch (selectLanguage) {
            case "english":
                language = ResourceBundle.getBundle("Language", new Locale("en","US"));
                break;
            case "English":
                language = ResourceBundle.getBundle("Language");
                break;
            default:
                language = null;
        }

    }

    public static String getString(String inputString) {


        // If an available language is not selected
        if (language == null) {

            throw new RuntimeErrorException(new Error("No language was set!"));
        }

        // Returns the string in the selected language
        return language.getString(inputString);


    }


}
