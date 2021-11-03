//import com.bethecoder.ascii_table.*;
//import com.github.*;
import com.github.freva.asciitable.AsciiTable;

public class TableASCII {

//    public void printTable(String s) {
//        String[] arr = s.split(" ");
//        int i = arr.length;
//        String[] header = new String[i + 1];
//        String[][] data = new String[i][i + 1];
//        header[0] = "PC \\ User";
//        for (int j = 0; j < i; j++) {
//            header[j + 1] = data[j][0] = arr[j];
//            for (int k = 0; k < i; k++) {
//                if (j == k) {
//                    data[j][k + 1] = "DRAW";
//                } else if (j - k < -i / 2 || (j - k <= i / 2 && j - k > 0)) {
//                    data[j][k + 1] = "WIN";
//                } else {
//                    data[j][k + 1] = "LOSE";
//                }
//            }
//        }
//        ASCIITable.getInstance().printTable(header, data);
//    }

    public void printMenu(String s){
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
        Character[] borderStyle = AsciiTable.NO_BORDERS;
        String[] footer = {};

        System.out.println(AsciiTable.getTable(borderStyle,header, footer, data));

    }
}
