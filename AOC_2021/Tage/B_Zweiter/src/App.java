package Tage.B_Zweiter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/B_Zweiter/src/input.txt"));

        HashMap <String, Integer> list = new HashMap<>();

        list.put("forward", 0);
        list.put("down", 0);
        list.put("up", 0);

        while(input.ready()) {
            String in [] = input.readLine().split(" ");
            list.put(in[0], (list.get(in[0])+Integer.parseInt(in[1])));
        }

        list.put("height", list.get("down") - list.get("up"));

        System.out.print( list.get("height") * list.get("forward"));
        input.close();
    }
}
