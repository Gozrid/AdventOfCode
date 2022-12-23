package Tage.D_Vierter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App2 {
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


        boolean breakk = false;
        int lastNum = 0;
        for(int i = 0; i < numbers.length; i++) {
            for (int j = list.size()-1; j > -1; j--) {
                if (list.size() == 1) {
                    if (list.get(j).markAndCheck(numbers[i])) {
                        lastNum = numbers[i];
                        breakk = true;
                        break;
                    }
                }else {
                    if (list.get(j).markAndCheck(numbers[i])) list.remove(j);
                }
            }
            if (breakk == true) break;
        }

        //list.get(0).output();
        //System.out.println(list.size());
        //System.out.println(lastNum);
        System.out.println(list.get(0).calculateSumOfUnmarked()*lastNum);
        input.close();
    }
}
