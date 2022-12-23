//Zu lange, algorithmus zu ineffizient...

/*package Tage.N_Vierzehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class App2 {
    private static Long max = 0l;
    private static Long min = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/N_Vierzehnter/src/input/testInput.txt"));
        HashMap <String, Character> moves = new HashMap<>();
        ArrayList <Character> start = new ArrayList<>();
        char [] e = input.readLine().toCharArray();
        start.add(e[0]);
        for (char c : e) {
            start.add(c);
        }
        int i = 0;
        input.readLine();
        while(input.ready()) {
            String [] in = input.readLine().split(" -> ");
            Character c = (in[1].toCharArray()[0]);
            moves.put(in[0], c);
        }
        
        for (int j = 0; j < 10; j++) {
            start = insertCharacters(start, moves);
        }
        System.out.println("hi");
        System.out.println(calculateDiff(start));
    }

    private static Long calculateDiff(ArrayList <Character> input) {
        HashMap <Character, Long> num= new HashMap<>();
        for (char c : input) {
            num.put(c, (num.getOrDefault(c, 0l)) + 1);
        }
        num.forEach((key, value) -> {
            if (value > max) max = value;
            if (value < min) min = value;
        });
        return((max-min));
    }

    public static ArrayList<Character> insertCharacters(ArrayList <Character> input, HashMap <String, Character> moves) {
        ArrayList <Character> out = new ArrayList<>();
        out.add(input.get(0));
        for(int i = (input.size()-1); i >= 1; i--) {
            String t = Character.toString(input.get(i-1)) + Character.toString(input.get(i));
            if (moves.containsKey(t)) {
                out.add(moves.get(t));
                out.add(input.get(i-1));
            }
        }
        return(out);
    }
}
*/