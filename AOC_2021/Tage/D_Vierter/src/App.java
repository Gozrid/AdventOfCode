package Tage.D_Vierter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/D_Vierter/src/input.txt"));

        ArrayList <Board> list = new ArrayList<>();

        String sp [] = input.readLine().split(",");
        int numbers [] = new int [sp.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers [i] = Integer.parseInt(sp[i]);
        }

        input.readLine();
        String iter = "";
        String [] boardIn = new String [5];
        while (input.ready()) {
            for (int i = 0; i < boardIn.length; i++) {
                iter = input.readLine();
                boardIn[i] = iter;
            }
            iter = input.readLine();
            list.add(new Board(boardIn));
        }

        int boardNum = 0;
        int lastNum = 0;
        boolean breakk = false;
        for (int i : numbers) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).markAndCheck(i) == true) {
                    boardNum = j;
                    lastNum = i;
                    breakk = true;
                    break;
                }
            }
            if (breakk == true) break;
        }

        System.out.println(list.get(boardNum).calculateSumOfUnmarked()*lastNum);
        input.close();
    }
}
