package Tage.K_Elfter.src;

import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/K_Elfter/src/input.txt"));

        char [] in = input.readLine().toCharArray();
        int [] [] map = new int [in.length] [in.length];
        for (int j = 0; j < map[0].length; j++) {
            map[0][j] = Integer.parseInt(Character.toString(in[j]));
        }
        while(input.ready()){
            for (int i = 1; i < map.length; i++) {
                in = input.readLine().toCharArray();
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = Integer.parseInt(Character.toString(in[j]));
                }
            }
        }

        
        int flash = 0;
        for (int i = 0; i < 100; i++) {
            step(map);
            flash += flashing(map);
        }
        System.out.println(flash);

        
        /*for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/
        input.close();
    }   

    private static void step(int [] [] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] += 1;
            }
        }
    }

    private static int flashing(int [] [] map) {
        boolean onceAgain = false;
        int flash = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] > 9){
                    map[y][x] = 0;
                    flash++;

                    for (int y2 = Integer.max(0, (y-1)); y2 <= Integer.min((map.length-1), (y+1)); y2++) {
                        for (int x2 = Integer.max(0, (x-1)); x2 <= Integer.min((map[0].length-1), (x+1)); x2++) {
                            if (map[y2][x2] != 0) {
                                map[y2][x2] += 1;
                                if (map[y2][x2] > 9) {
                                    onceAgain = true;
                                }
                            }
                        }
                    }

                }
            }
        }
        if (onceAgain) {
            onceAgain = false;
            flash += flashing(map);
        }
        return(flash);
    }
}
