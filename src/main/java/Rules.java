import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;

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
        if (str.equals("0")) {
            System.exit(0);
        } else if (str.equals("?")) {
            table.printTable(s);
        } else {
            int b = Integer.parseInt(str);
            if (a == b) {
                System.out.println("DRAW");
            } else if (a - b < -l / 2 || (a - b <= l / 2 && a - b > 0)) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
            System.out.println(hmac.getKey());
        }
    }

    public int movePC(int l) {
        return new SecureRandom().nextInt(l);
    }
}
