//-------------------------------------------------
//Important: Change path to your file !! (Line 14)
//-------------------------------------------------

package Tage.A_Erster.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App2{
    private static BufferedReader input;
    private static int [] inputIArray = new int [3];
    public static void main(String[] args) throws Exception {

        input = new BufferedReader(new FileReader("./Tage/A_Erster/src/input.txt"));

        int inputLast = 0;
        int numIncreases = 0;

        for (int i = 0; i < inputIArray.length; i++) {
            inputIArray[i] = Integer.parseInt(input.readLine());
        }

        do{
            int inputI = inputIArray[0] + inputIArray[1] + inputIArray[2];
            if (inputI > inputLast) {
                numIncreases++;
            }
            inputLast = inputI;
            updateArray();
        }while(input.ready());
        System.out.println(numIncreases);
        input.close();
    }

    private static void updateArray () throws NumberFormatException, IOException {
        for (int i = 0; i < inputIArray.length - 1; i++) {
            inputIArray[i] = inputIArray[i + 1];
        }
        inputIArray[2] = Integer.parseInt(input.readLine());
    }
}
