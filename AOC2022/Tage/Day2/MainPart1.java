package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class MainPart1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day2/Input.list");
        @SuppressWarnings("unused")
        FileReader testInputFile = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day2/TestInput.list");
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        int result = 0;
        ArrayList<String[]> input = new ArrayList<>();

        bufferedReader.lines().forEach(string -> input.add(string.split(" ")));


        for (String[] strings : input) {
            int oponentSymbol = calculateOponentSymbolValue(strings[0]);
            int mySymbol = calculateMySymbolValue(strings[1]);
            switch (oponentSymbol - mySymbol) {
                case 0 -> result += mySymbol + 3;
                case 1 -> result += mySymbol;
                case 2 -> result += mySymbol + 6;
                case -1 -> result += mySymbol + 6;
                case -2 -> result += mySymbol;
            }
        }

        System.out.println(result);
    }

    private static int calculateMySymbolValue(String input) {
        return ((((int) input.toCharArray()[0]) - 1) % 3) + 1;
    }

    private static int calculateOponentSymbolValue(String input) {
        return ((((int) input.toCharArray()[0]) - 2) % 3) + 1;
    }

}
