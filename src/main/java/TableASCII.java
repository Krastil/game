import com.github.freva.asciitable.AsciiTable;
import java.util.ArrayList;
import java.util.List;

public class TableASCII {

    public void printTable(String s) {
        String[] arr = s.split(" ");
        int i = arr.length;
        String[] header = new String[i + 1];
        String[][] data = new String[i][i + 1];
        header[0] = "PC \\ User";
        for (int j = 0; j < i; j++) {
            header[j + 1] = data[j][0] = arr[j];
            for (int k = 0; k < i; k++) {
                if (j == k) {
                    data[j][k + 1] = "DRAW";
                } else if (j - k < -i / 2 || (j - k <= i / 2 && j - k > 0)) {
                    data[j][k + 1] = "WIN";
                } else {
                    data[j][k + 1] = "LOSE";
                }
            }
        }
        System.out.println(AsciiTable.getTable(header, data));
    }

    public void printMenu(String s) {
        String[] arr = s.split(" ");
        int i = arr.length;
        List<String> str = new ArrayList<>();
        str.add("Available moves");
        for (int k = 0; k < i; k++) {
            str.add((k + 1) + " - " + arr[k]);
        }
        str.add("0 - exit");
        str.add("? - help");
        for (String st : str) {
            System.out.println(st);
        }
    }
}
