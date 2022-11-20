package helper;

import java.util.Locale;

public class InputHelper {
    public static boolean isTagsValid(String[] tags) {
        if (tags.length == 0) {
            System.out.println("Tag is empty");
            return false;
        }
        for (String tag : tags) {
            if(!tag.matches("[a-zA-Z]+")) {
                System.out.println("Tag is invalid :: " + tag);
                return false;
            }
        }
        return true;
    }

    public static String[] convertCommaSeperatedStringToArray(String s) {
        return s.toUpperCase(Locale.ROOT).split(",");
    }
}
