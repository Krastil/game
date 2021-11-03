import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException {

        while (true) {

            String variables = new Scanner(System.in).nextLine();
//            if (s.equals("0")) {
//                break;
//            }

            if (checkRepeats(variables)) {
                startGame(variables);
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

    public static void startGame(String s) {
        TableASCII table = new TableASCII();
        table.printMenu(s);
    }


}
