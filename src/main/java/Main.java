import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, NoSuchAlgorithmException, InvalidKeyException {

        // переделать под массив args

        Rules rules = new Rules();
        while (true) {

            String variables = new Scanner(System.in).nextLine();
//            if (s.equals("0")) {
//                break;
//            }

            if (checkRepeats(variables)) {
                while (true) {
                    rules.startGame(variables);
                }
            } else {
                System.out.println("Incorrectly entered variables. Try again.\nExample:rock paper scissors");
            }

        }

    }

    public static boolean checkRepeats(String s) {
        String[] arr = s.split(" ");
        Set<String> set = new HashSet<String>();
        for (String str : arr) set.add(str);
        return set.size() == arr.length;
    }


}
