package Tage.H_Achter.src;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/H_Achter/src/input.txt"));
        int numUnique = 0;

        while(input.ready()) {
            String temp [] = filterInput(input.readLine());
            for (String string : temp) {
                switch (string.length()) {      //347
                    case 2:
                        numUnique++;
                        break;
                    case 3:
                        numUnique++;
                        break;
                    case 4:
                        numUnique++;
                        break;
                    case 7:
                        numUnique++;
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println(numUnique);
        input.close();
    }

    private static String[] filterInput(String input) {
        String returnSArray [] = input.split("( )");
        returnSArray[10] = returnSArray[10].replace("|", "");
        String returnSArrayOut [] = new String [4];
        System.arraycopy(returnSArray, 11, returnSArrayOut, 0, 4);
        return(returnSArrayOut);
    }

}
