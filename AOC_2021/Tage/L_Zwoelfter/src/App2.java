//Richtiges Ergebnis beim quiz input aber falsche beim "slightly larger"???
//WTF
//Sonst alle anderen auch richtig???

package Tage.L_Zwoelfter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class App2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/L_Zwoelfter/src/input.txt"));
        HashMap <String, ArrayList<String>> lookup = new HashMap<>();
        ArrayList <String> lookupTiny = new ArrayList<>();

        while(input.ready()) {
            String [] in = input.readLine().split("-");
            lookup.putIfAbsent(in[0], new ArrayList<String>());
            lookup.get(in[0]).add(in[1]);
            if (in[0].compareTo("start") != 0 && in[1].compareTo("end") != 0) {
                lookup.putIfAbsent(in[1], new ArrayList<String>());
                lookup.get(in[1]).add(in[0]);
            }
        }

        lookup.forEach((key, value) -> {
            if (key.equals(key.toLowerCase())) {
                lookupTiny.add(key);
            }
        });

        ArrayList <String> start = new ArrayList<>();
        start.add("start");
        System.out.println(createPaths("start", lookup, start, lookupTiny));
        input.close();
    }

    private static int createPaths(String start, HashMap <String, ArrayList<String>> lookup, ArrayList <String> pathTo, ArrayList <String> lookupTiny) {
        int returnInt = 0;
        if (start.compareTo("end") == 0) {
            return(1);
        }
        if (lookup.containsKey(start)){
            for (int i = 0; i < lookup.get(start).size(); i++) {
                String value = lookup.get(start).get(i);
                if (value.equals(value.toLowerCase()) == true && pathTo.contains(value)) {
                    if (!isLowerCaseUsed(lookupTiny, pathTo)) {
                        ArrayList <String> t = new ArrayList<>();
                        t.addAll(pathTo);
                        t.add(value);
                        returnInt += createPaths(lookup.get(start).get(i), lookup, t,lookupTiny);
                    }
                }else if(!(value.equals(value.toLowerCase()) && pathTo.contains(value))){
                    ArrayList <String> t = new ArrayList<>();
                    t.addAll(pathTo);
                    t.add(value);
                    returnInt += createPaths(lookup.get(start).get(i), lookup, t,lookupTiny);
                }
            }
        }
        return(returnInt);
    }

    private static boolean isLowerCaseUsed(ArrayList <String> lookupTiny, ArrayList <String> pathTo) {
        int numUsed = 0;
        for (int i = 0; i < lookupTiny.size(); i++) {
            int checkTwice = 2;
            for (int j = 0; j < pathTo.size(); j++) {
                if (pathTo.get(j).equals(lookupTiny.get(i))) checkTwice--;
            }
            if (checkTwice == 0) {numUsed++;};
        }
        if (numUsed > 0) return(true);
        return(false);
    }
}
