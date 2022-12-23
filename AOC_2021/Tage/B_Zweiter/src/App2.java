package Tage.B_Zweiter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class App2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/B_Zweiter/src/input.txt"));

        HashMap <String, Integer> list = new HashMap<>();

        list.put("forward", 0);
        list.put("aim", 0);
        list.put("depth", 0);

        while(input.ready()) {
            String in [] = input.readLine().split(" ");
            switch (in [0]) {
                case "down":
                    list.put("aim", list.get("aim")+Integer.parseInt(in[1]));
                    break;
                case "up":
                    list.put("aim", list.get("aim")-Integer.parseInt(in[1]));
                    break;
                case "forward":
                    list.put("depth", list.get("depth") + (list.get("aim")*Integer.parseInt(in[1])));
                    list.put("forward", list.get("forward") + Integer.parseInt(in[1]));
                    break;
                default:
                    break;
            }
        }

        int output = list.get("forward") * list.get("depth");
        System.out.println(output);
        input.close();
    }
}
