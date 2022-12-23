//-------------------------------------------------
//Important: Change path to your file !! (Line 14)
//-------------------------------------------------

package Tage.A_Erster.src;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/A_Erster/src/input.txt"));

        int inputI = Integer.parseInt(input.readLine());
        int inputLast = 0;
        int numIncreases = 0;

        do{
            inputLast = inputI;
            inputI = Integer.parseInt(input.readLine());
            if (inputI > inputLast) {
                numIncreases++;
            }
        }while(input.ready());
        System.out.println(numIncreases);
        input.close();
    }
}
