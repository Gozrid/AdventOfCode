package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final File inputList = new File("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day1/Input.list");
    private static int counter = -1;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(inputList);
        ArrayList<Integer> elfTops = new ArrayList<>();
        ArrayList<Integer> elfCalories = new ArrayList<>();

        while (sc.hasNextLine()) {
            String nextLine = sc.nextLine();
            if (nextLine.equals("")) {
                counter++;
                elfCalories.add(0);
            } else {
                elfCalories.set(counter,
                        (elfCalories.get(counter) + Integer.parseInt(nextLine)));
            }
        }

        int newMax;
        elfTops.add(0);
        for (int i = 0; i < 3; i++) {
            newMax = 0;
            elfTops.add(0);
            for (Integer elfCalory : elfCalories) {
                if (!elfTops.contains(elfCalory) && elfCalory > newMax) {
                    newMax = elfCalory;
                }
            }
            elfTops.set(i, newMax);
        }

        int result = elfTops.get(0) +
                elfTops.get(1) +
                elfTops.get(2);

        System.out.println(elfTops.get(0));
        System.out.println(result);
    }

}
