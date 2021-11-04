import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, NoSuchAlgorithmException, InvalidKeyException {
        String variables = "";
        Rules rules = new Rules();
        for (String str : args) {
            variables += str + " ";
        }
        if (rules.checkRepeats(variables) && rules.checkQuantity(variables)) {
            while (true) {
                rules.startGame(variables);
            }
        } else {
            System.out.println("Incorrectly entered variables. Variables must be >=3. Try again.\nExample:rock paper scissors or 1 2 3");
        }
    }
}