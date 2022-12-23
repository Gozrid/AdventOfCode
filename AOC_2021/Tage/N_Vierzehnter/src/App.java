package Tage.N_Vierzehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class App {
    private static int max = 0;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/N_Vierzehnter/src/input/input.txt"));
        HashMap <String, String> moves = new HashMap<>();
        String start = input.readLine();
        input.readLine();
        while(input.ready()) {
            String [] in = input.readLine().split(" -> ");
            moves.put(in[0], in[1]);
        }
        
        for (int j = 0; j < 10; j++) {
            start = insertCharacters(start, moves);
        }
        System.out.println(start.length());
        System.out.println(calculateDiff(start));
        input.close();
    }

    private static int calculateDiff(String input) {
        char [] in = input.toCharArray();
        HashMap <Character, Integer> num= new HashMap<>();
        for (char c : in) {
            num.put(c, (num.getOrDefault(c, 0)) + 1);
        }
        num.forEach((key, value) -> {
            if (value > max) max = value;
            if (value < min) min = value;
        });
        return((max-min));
    }

    public static String insertCharacters(String input, HashMap <String, String> moves) {
        char [] in = input.toCharArray();
        String out = Character.toString(in[input.length()-1]);
        for(int i = (input.length()-1); i >= 1; i--) {
            String t = Character.toString(in[i-1]) + Character.toString(in[i]);
            if (moves.containsKey(t)) {
                out += moves.get(t) + Character.toString(in[i-1]);
            }
        }
        StringBuilder t = new StringBuilder(out);
        t.reverse();
        return(t.toString());
    }
}
