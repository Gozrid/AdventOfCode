package Tage.F_Sechster.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/F_Sechster/src/input.txt"));

        ArrayList <Lanternfish> list = new ArrayList<>();

        String [] inputArray = input.readLine().split(",");

        for (String string : inputArray) {
            list.add(new Lanternfish(Integer.parseInt(string)));
        }

        for (int i = 0; i < 80; i++) {
            int numNewFishes = 0;
            for (Lanternfish fish : list) {
                if (fish.cycle()) numNewFishes++;
            }
            for (int j = 0; j < numNewFishes; j++) {
                list.add(new Lanternfish(8));
            }
        }

        System.out.println(list.size());

        input.close();
    }
}
