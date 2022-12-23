package Day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MainPart1 {

    private static final Stack<Character>[] crateStack = new Stack[9];

    public static void main(String[] args) throws FileNotFoundException {
        FileReader testInput = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day5/TestInput.list");
        FileReader input = new FileReader("/home/fabian/GIT/AOC-2022/AOC-2022/src/Day5/Input.list");
        ArrayList<String> inputArray = new ArrayList<>();

        BufferedReader inputReader = new BufferedReader(input);

        for (int i = 0; i < crateStack.length; i++) {
            crateStack[i] = new Stack<>();
        }
        inputReader.lines().forEach(inputArray::add);
        for (int j = 0; j < inputArray.size(); j++) {
            String string = inputArray.get(j);
            char[] stringCharacterArray = string.toCharArray();
            if (stringCharacterArray[1] == '1') {
                break;
            }
            for (int i = 0; i < stringCharacterArray.length; i++) {
                if (stringCharacterArray[i] != '[' &&
                        stringCharacterArray[i] != ']' &&
                        stringCharacterArray[i] != ' ') {
                    int currentStack = (i / 4);
                    crateStack[currentStack].add(stringCharacterArray[i]);
                }
            }
        }
        for (Stack<Character> stack : crateStack) {
            Collections.reverse(stack);
        }

        inputArray.forEach(string -> {
            if (!string.isEmpty() && string.charAt(0) == 'm') {
                String [] splitArray = string.split(" ");
                for (int i = 0; i < Integer.parseInt(splitArray[1]); i++) {
                    crateStack[(Integer.parseInt(splitArray[5])-1)].push(crateStack[(Integer.parseInt(splitArray[3])-1)].pop());
                }
            }
        });
        outputFirstElements();
    }

    private static void outputFirstElements() {
        for (Stack<Character> characters : crateStack) {
            System.out.print(characters.peek());
        }
    }

}
