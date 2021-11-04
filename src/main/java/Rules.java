import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Rules {

    HmacAndKey hmac = new HmacAndKey();
    TableASCII table = new TableASCII();

    public void startGame(String s) throws NoSuchAlgorithmException, InvalidKeyException {
        int l = s.split(" ").length;
        int movePCint = movePC(l);
        String message = s.split(" ")[movePCint];
        hmac.generateHmacAndKey(message);
        System.out.println("HMAC: " + hmac.getHMAC());
        table.printMenu(s);
        makeMove(movePCint, l, s);
    }

    public void makeMove(int a, int l, String s) {
        System.out.print("Enter you move: ");
        String str = new Scanner(System.in).nextLine();
        String[] arr = s.split(" ");
        int count = 0;
        if (str.equals("0")) {
            System.exit(0);
        } else if (str.equals("?")) {
            table.printTable(s);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (Integer.parseInt(str) != (i + 1)) {
                    count++;
                }
            }
            if (arr.length != count) {
                int b = Integer.parseInt(str);
                if (a == b) {
                    System.out.println("DRAW");
                } else if (a - b < -l / 2 || (a - b <= l / 2 && a - b > 0)) {
                    System.out.println("WIN");
                } else {
                    System.out.println("LOSE");
                }
                System.out.println("HMAC key: " + hmac.getKey() + "\n");
            } else {
                System.out.println("Incorrectly entered variables.\n");
            }
        }
    }

    public int movePC(int l) {
        return new SecureRandom().nextInt(l);
    }

    public boolean checkRepeats(String s) {
        String[] arr = s.split(" ");
        Set<String> set = new HashSet<>();
        for (String str : arr) set.add(str);
        return set.size() == arr.length;
    }

    public boolean checkQuantity(String s) {
        if (s.split(" ").length % 2 != 0 && s.split(" ").length != 1) {
            return true;
        } else return false;
    }
}
