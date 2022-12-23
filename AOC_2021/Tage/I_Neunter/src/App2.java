//478224 ist zu klein

package Tage.I_Neunter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class App2 {
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

        ArrayList <Basin> basins = new ArrayList<>();
        for (Coordinates coordinates : list) {
            Basin basin = new Basin(coordinates);
            follow(coordinates, map, basin);
            basins.add(basin);
        }

        basins.forEach(basin -> {
            basin.filter();
        });
        Collections.sort(basins);
        Basin [] basinsLast = getBasins(basins);
        int output = basinsLast[0].size()*basinsLast[1].size()*basinsLast[2].size();
        System.out.println(output);
        input.close();
    }

    private static Basin[] getBasins(ArrayList <Basin> basins) {
        Basin [] basinsOut = new Basin [3];
        basinsOut[0] = basins.get(0);
        for (int i = 1; i < basins.size(); i++) {
            int num = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (basins.get(i).compareMe(basins.get(j))) {
                    break;
                }
                num++;
            }
            if (num == i) {
                if (basinsOut[1] == null) {
                    basinsOut[1] = basins.get(i);
                }else if (basinsOut[2] == null) {
                    basinsOut[2] = basins.get(i);
                }else {
                    break;
                }
            }
        }
        return(basinsOut);
    }

    private static void follow(Coordinates coordinates, int [] [] map, Basin basin) {
        if (map [Integer.min(coordinates.X()+ 1, map.length - 1)] [coordinates.Y()] > (map[coordinates.X()] [coordinates.Y()]) && map [Integer.min(coordinates.X()+ 1, map.length - 1)] [coordinates.Y()] != 9) {
            Coordinates coordinate = new Coordinates(Integer.min(coordinates.X()+ 1, map.length - 1), coordinates.Y(), 0);
            basin.addCoordinate(coordinate);
            follow(coordinate, map, basin);
        }
        if (map [Integer.max(coordinates.X()- 1, 0)] [coordinates.Y()] > (map[coordinates.X()] [coordinates.Y()]) && map [Integer.max(coordinates.X()- 1, 0)] [coordinates.Y()] != 9) {
            Coordinates coordinate = new Coordinates(Integer.max(coordinates.X()- 1, 0), coordinates.Y(), 0);
            basin.addCoordinate(coordinate);
            follow(coordinate, map, basin);
        }
        if (map [coordinates.X()] [Integer.min(coordinates.Y()+ 1, map[0].length - 1)] > (map[coordinates.X()] [coordinates.Y()]) && map [coordinates.X()] [Integer.min(coordinates.Y()+ 1, map[0].length - 1)] != 9) {
            Coordinates coordinate = new Coordinates(coordinates.X(), Integer.min(coordinates.Y()+ 1, map[0].length - 1), 0);
            basin.addCoordinate(coordinate);
            follow(coordinate, map, basin);
        }
        if (map [coordinates.X()] [Integer.max(coordinates.Y()- 1, 0)] > (map[coordinates.X()] [coordinates.Y()]) && map [coordinates.X()] [Integer.max(coordinates.Y()- 1, 0)] != 9) {
            Coordinates coordinate = new Coordinates(coordinates.X(), Integer.max(coordinates.Y()- 1, 0), 0);
            basin.addCoordinate(coordinate);
            follow(coordinate, map, basin);
        }
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
