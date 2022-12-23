package Tage.F_Sechster.src;

import java.io.BufferedReader;
import java.io.FileReader;


public class App2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/F_Sechster/src/input.txt"));

        String [] inputArray = input.readLine().split(",");

        long fishes [] = new long [9];      //Da 9 Tage

        for (String string : inputArray) {
            fishes[Integer.parseInt(string)] += 1;
        }

        for (int i = 0; i < 256; i++) {     //Simulieren, geht aber bestimmt mit Formel oder so ?
            long copyArray [] = new long [fishes.length];
            for (int j = fishes.length - 1; j >= 0; j--) {
                if (j > 0) {
                    copyArray[j-1] += fishes [j];
                }else {
                    copyArray[6] += fishes [j];
                    copyArray[8] += fishes [j];
                }
            }
            fishes = copyArray;
        }

        long out = 0;
        for (long i : fishes) {     //Fische zaehlen
            out += i;
        }
        System.out.println(out);
        input.close();
    }
}


// Long muss benutzt werden, da die Zahl viel zu gross wird fuer int...
// int == 2 147 483 647 & (*-1)
// long == 9 223 372 036 854 775 807 & (*-1)