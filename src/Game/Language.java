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
 * @version v.0.2
 */
public class Language {

    private static ResourceBundle language;


    /** Do not instantiate Language. */
    private Language() {
    }

    /**
     * Setter for property 'language'.
     *
     * @param selectLanguage Value to set for property 'language'.
     */
    public static void setLanguage(String selectLanguage) {

        // Selects the language through the String variable "inputString"
        switch (selectLanguage) {
            case "english":
                language = ResourceBundle.getBundle("Language", new Locale("en", "US"));
                break;
            case "English":
                language = ResourceBundle.getBundle("Language", new Locale("en", "US"));
                break;
            case "danish":
                language = ResourceBundle.getBundle("Language", new Locale("da", "DK"));
                break;
            case "Danish":
                language = ResourceBundle.getBundle("Language", new Locale("da", "DK"));
                break;
            default:
                language = null;
        }

    }

    /**
     * Gets the string from the resource file in the chosen language.
     * @param inputString the string identifier in the resource file.
     * @return The translated string.
     */
    public static String getString(String inputString) {


        // If an available language is not selected
        if (language == null) {

            throw new RuntimeErrorException(new Error("No language was set!"));
        }

        // Returns the string in the selected language
        return language.getString(inputString);
    }
}
