package Tage.G_Siebter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class App2 {
    private static int maxNum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/G_Siebter/src/input.txt"));
        String inputS [] = input.readLine().split(",");
        Stream <String> stream = Arrays.stream(inputS);
        stream.forEach(str -> {
            if (Integer.parseInt(str) > maxNum) maxNum = Integer.parseInt(str);
        });

        int [] crabs = new int [maxNum + 1];

        for (String string : inputS) {
            crabs[Integer.parseInt(string)] += 1;   // Anzahl der Krabben an dieser Stelle 
        }

        int [] crabsFuel = new int [crabs.length];

        for (int i = 0; i < crabs.length; i++) {
            for (int j = 0; j < crabs.length; j++) {
                int steps = Integer.max(j, i) - Integer.min(j, i);
                crabsFuel[i] += ((steps*(steps+1))/2) * crabs[j];   // Gausssche Summenformel * Anzahl der Krabben an dieser Stelle :)
            }
        }

        int minCrabFuel = Integer.MAX_VALUE;
        for (int i = 0; i < crabsFuel.length; i++) {
            if (crabsFuel[i] < minCrabFuel) {
                minCrabFuel = crabsFuel[i];
            }
        }

        System.out.println(minCrabFuel);
        input.close();
    }
}
