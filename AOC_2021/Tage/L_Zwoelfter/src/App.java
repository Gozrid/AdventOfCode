package Tage.L_Zwoelfter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/L_Zwoelfter/src/input.txt"));
        HashMap <String, ArrayList<String>> lookup = new HashMap<>();

        while(input.ready()) {
            String [] in = input.readLine().split("-");
            lookup.putIfAbsent(in[0], new ArrayList<String>());
            lookup.get(in[0]).add(in[1]);
            if (in[0].compareTo("start") != 0 && in[1].compareTo("end") != 0) {
                lookup.putIfAbsent(in[1], new ArrayList<String>());
                lookup.get(in[1]).add(in[0]);
            }
        }

        ArrayList <String> start = new ArrayList<>();
        start.add("start");
        System.out.println(createPaths("start", lookup, start));
        input.close();
    }

    private static int createPaths(String start, HashMap <String, ArrayList<String>> lookup, ArrayList <String> pathTo) {
        int returnInt = 0;
        if (start.compareTo("end") == 0) {
            return(1);
        }
        if (lookup.containsKey(start)){
            for (int i = 0; i < lookup.get(start).size(); i++) {
                String value = lookup.get(start).get(i);
                if (!(value.equals(value.toLowerCase()) && pathTo.contains(value))) {
                    ArrayList <String> t = new ArrayList<>();
                    t.addAll(pathTo);
                    t.add(lookup.get(start).get(i));
                    returnInt += createPaths(lookup.get(start).get(i), lookup, t);
                }
            }
        }
        return(returnInt);
    }
}
