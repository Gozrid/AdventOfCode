package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainPart2 {
    private static int numberOfOverlaps = 0;

    public static void main(String[] args) throws FileNotFoundException {
        @SuppressWarnings("unused")
        FileReader testInput = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day4/TestInput.list");
        FileReader input = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day4/Input.list");
        BufferedReader bufferedReader = new BufferedReader(input);


        bufferedReader.lines().forEach(string -> {
            String[] ranges = string.split(",");

            if (parseIntAndSplitInString(ranges, 0,0) <= parseIntAndSplitInString(ranges,1,0)
            && parseIntAndSplitInString(ranges,0,1) >= parseIntAndSplitInString(ranges,1,0)) {
                numberOfOverlaps++;
            }else if(parseIntAndSplitInString(ranges,1,0) <= parseIntAndSplitInString(ranges,0,0)
            && parseIntAndSplitInString(ranges,1,1) >= parseIntAndSplitInString(ranges,0,0)) {
                numberOfOverlaps++;
            }
        });

        System.out.println("Number of Array fully contained: " + numberOfOverlaps);
    }

    private static int parseIntAndSplitInString(String[] inputString, int positionInArray, int positionInSplitArray) {
        return Integer.parseInt(inputString[positionInArray].split("-")[positionInSplitArray]);
    }

}
