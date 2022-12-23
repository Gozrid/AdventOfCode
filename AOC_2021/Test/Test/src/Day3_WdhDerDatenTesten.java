package Test.Test.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Day3_WdhDerDatenTesten {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("C:/Users/fabia/Desktop/Brockhaus_AG/Programmierrunde/Workspace/Git/AOC/FabianS/Test/src/input.txt"));

        ArrayList <String> list = new ArrayList<>();

        while(input.ready()) {
            list.add(input.readLine());
        }

        HashMap <String, Integer> hMap = new HashMap<>();

        for (String string : list) {
            if (hMap.containsKey(string)) {
                hMap.put(string, (hMap.get(string) + 1));
            }else {
                hMap.put(string, 1);
            }
            
        }
        
        hMap.forEach((key, value) -> {
            if (value > 1) {
            System.out.println(key + " kommt " + value + " mal vor.");
            }
        });

        System.out.println(list.get(0).length());
        input.close();
    }
}
