import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, NoSuchAlgorithmException, InvalidKeyException {
        while (true) {
            String variables = "";
            Rules rules = new Rules();
            for (String str : args) {
                variables = str + " ";
            }
            if (checkRepeats(variables)) {
                while (true) {
                    rules.startGame(variables);
                }
            } else {
                System.out.println("Incorrectly entered variables. Try again.\nExample:rock paper scissors or 1 2 3");
            }
        }
    }

    public static boolean checkRepeats(String s) {
        String[] arr = s.split(" ");
        Set<String> set = new HashSet<>();
        for (String str : arr) set.add(str);
        return set.size() == arr.length;
    }
}