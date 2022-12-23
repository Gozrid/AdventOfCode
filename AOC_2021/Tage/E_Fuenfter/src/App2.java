package Tage.E_Fuenfter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputR = new BufferedReader(new FileReader("./Tage/E_Fuenfter/src/input.txt"));
        ArrayList <int[]> input = new ArrayList<>();
        while(inputR.ready()) {
            input.add(returnIntegerArray(inputR.readLine()));
        }
        int size = searchMax(input);
        int [] [] map = new int[size+1] [size+1];       //+1, da Arrays die Laenge bekommen (1-x) und nicht die eigentlichen "Koordinaten" (0-x)
        filterInput(input);
        for (int i = 0; i < input.size(); i++) {
            int xLength = Integer.max(input.get(i)[0], input.get(i)[2]) - Integer.min(input.get(i)[0], input.get(i)[2]);    //Laenge berechnet auf x-Achse
            int yLength = Integer.max(input.get(i)[1], input.get(i)[3]) - Integer.min(input.get(i)[1], input.get(i)[3]);    //Laenge berechnet auf y-Achse
            int xIncrease = (input.get(i)[2] - input.get(i)[0]) / Integer.max(xLength, 1);                                  //Steigung auf x-Achse
            int yIncrease = (input.get(i)[3] - input.get(i)[1]) / Integer.max(yLength, 1);                                  //Steigung auf y-Achse
            for (int j = 0; j <= Integer.max(xLength, yLength); j++) {
                map[input.get(i)[0] + (xIncrease*j)] [input.get(i)[1] + (yIncrease*j)] += 1;
            }
        }
        //drawMap(map);
        System.out.println(calculateDangerousFields(map));
        inputR.close();
    }



    private static int calculateDangerousFields(int [] [] map) {
        int numDangerours = 0;
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 1) numDangerours++;
            }
        }
        return(numDangerours);
    }

    private static void filterInput(ArrayList <int[]> input) {
        for (int i = input.size()-1; i >= 0; i--) {
            if (input.get(i)[0] != input.get(i)[2] && input.get(i)[1] != input.get(i)[3]){
                int X = Integer.max(input.get(i)[0], input.get(i)[2]) - Integer.min(input.get(i)[0], input.get(i)[2]);
                int Y = Integer.max(input.get(i)[1], input.get(i)[3]) - Integer.min(input.get(i)[1], input.get(i)[3]);
                if (X != Y) input.remove(i);
            }
        }
    }
    
    private static int searchMax(ArrayList <int[]> input) {
        int maxNum = 0;
        for (int i = 0; i < input.size(); i++) {
            int [] temp = input.get(i);
            for (int integer : temp) {
                if (integer > maxNum) maxNum = integer;
            }
        }
        return(maxNum);
    }

    private static int[] returnIntegerArray(String input) {
        String [] inputArray = input.split("( -> )|(\\,)");     //split at " -> " and ","
        int [] returnI = new int [inputArray.length];
        for (int i = 0; i < returnI.length; i++) {
            returnI[i] = Integer.parseInt(inputArray[i]);
        }
        return(returnI);
    }

    /*private static void drawMap(int [] [] map) {
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[j][i] == 0) {
                    System.out.print(".");
                }else{
                    System.out.print(map[j][i]);
                }
            }
            System.out.println();
        }
    }*/
}


/*Notiz:
Integer != Integer --> nicht wie erwartet, da keine "echte" Nummer.
int != int --> wie erwartet, da "echte" Nummer.
*/