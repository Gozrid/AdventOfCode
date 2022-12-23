package Tage.I_Neunter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/I_Neunter/src/input.txt"));
        ArrayList <Coordinates> list = new ArrayList<>();

        char [] in = input.readLine().toCharArray();
        int [] [] map = new int [in.length] [in.length];
        for (int i = 0; i < in.length; i++) {
            map[0] [i] = Integer.parseInt(Character.toString(in[i]));
        }
        int counter = 1;
        do {
            in = input.readLine().toCharArray();
            for (int i = 0; i < in.length; i++) {
                map[counter] [i] = Integer.parseInt(Character.toString(in[i]));
            }
            counter++;
        } while(input.ready());

        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isTiniest(map, i, j)) {
                    Coordinates temp = new Coordinates(i, j, map[i][j]);
                    if (!containsCoordinate(temp.X(), temp.Y(), list)) list.add(temp);
                }
            }
        }

        int sum = 0;
        for (Coordinates coordinates : list) {
            sum += (coordinates.value()+1);
        }
        System.out.println(sum);
        input.close();
    }

    private static boolean containsCoordinate(int x, int y, ArrayList <Coordinates> list) {
        for (Coordinates coordinates : list) {
            if (coordinates.X() == x && coordinates.Y() == y) return(true);
        }
        return(false);
    }

    private static boolean isTiniest(int [] [] map, int x, int y) {
        int allTrue = 0;
        if (map[Integer.min(x + 1, map.length - 1)] [y] > map [x] [y] || (map.length -1) < x+1) {
            allTrue++;
        }
        if (map[Integer.max(x - 1, 0)] [y] > map [x] [y] || 0 > x-1) {
            allTrue++;
        }
        if (map[x] [Integer.max(y - 1, 0)] > map [x] [y] || 0 > y-1) {
            allTrue++;
        }
        if (map[x] [Integer.min(y + 1, map[0].length - 1)] > map [x] [y] || (map[0].length -1)< y+1) {
            allTrue++;
        }
        if (allTrue == 4) {
            return(true);
        }else {
            return(false);
        }
    }
}
