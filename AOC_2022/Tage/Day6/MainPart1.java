package Day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainPart1 {

    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day6/Input.list");
        FileReader testInput = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day6/TestInput.list");

        BufferedReader bufferedReader = new BufferedReader(testInput);

        String inputString = bufferedReader.readLine();

        int startOfPacked = 0;
        int counter = 0;

        for (int i = 3; i < inputString.length(); i++) {
            for (int i1 = 1; i1 < 5; i1++) {
                if (inputString.charAt(i-i1) != inputString.charAt(i)) {
                    counter++;
                }
            }
            if (counter == 4) {
                startOfPacked = i;
                break;
            }
            counter = 0;
        }

        System.out.println(startOfPacked);
    }

}
