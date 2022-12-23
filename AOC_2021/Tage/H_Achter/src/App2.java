/*Idee:
Man kann die obere Seite festlegen, wenn man die Buchstaben der Eins von den Buchstaben der Sieben abzieht.
Die untere Seite kann man festlegen durch die fuenf minus die sieben und die vier.
unten links kann man festlegen durch die 6 minus unten, oben und 4.
mitte kann man festlegen durch oben, unten, oben links und die 1.

oben links kann man festlegen durch die 0 minus durch 7 unten und links unten.  -> Nö

oben rechts kann man festlegen durch die 2 minus die festgelegten außer oben links.
unten rechts kann man festlegen durch die 1 minus die festgelegten.
*/

/* 2. Idee:
Direkt die Nummern herausfinden, anstatt nur wo welcher Strich der nummer hingehoert...
*/


package Tage.H_Achter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/H_Achter/src/input.txt"));
        int sum = 0;
        
        while(input.ready()) {
            String temp [] = toArray(input.readLine());
            HashMap <Character, Character> compareList = new HashMap<>();
            String threeGuesses [] = filterThree(temp);
            
            compareList.put('a', stringDifference(threeGuesses[0], threeGuesses[1]));
            compareList.put('g', findCharacter(5, temp, threeGuesses[1] + threeGuesses[2]));
            compareList.put('e', findCharacter(6, temp, compareList.get('a') + threeGuesses[2] + compareList.get('g')));
            compareList.put('d', findCharacter(5, temp, compareList.get('a') + threeGuesses[0] + compareList.get('g')));
            compareList.put('c', findCharacter(5, temp, Character.toString(compareList.get('g')) + Character.toString(compareList.get('e')) + Character.toString(compareList.get('d')) + Character.toString(compareList.get('a'))));
            compareList.put('f', stringDifference(Character.toString(compareList.get('c')), threeGuesses[0]));
            compareList.put('b', findCharacter(7, temp, Character.toString(compareList.get('a')) + Character.toString(compareList.get('c')) + Character.toString(compareList.get('d')) + Character.toString(compareList.get('e')) + Character.toString(compareList.get('f')) + Character.toString(compareList.get('g'))));
            sum += getNumber(compareList, temp);
        }
        System.out.println(sum);
        input.close();
    }

    private static int getNumber(HashMap <Character, Character> map, String [] input) {
        String [] temp = buildStrings(map);
        int [] number = new int [4];
        for (int i = 10; i < input.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (numDifferencesBoth(temp[j], input[i]) == false) {
                    number [i - 10] = j;
                    break;
                }
            }
        }
        return(Integer.parseInt(Integer.toString(number[0]) + Integer.toString(number[1]) + Integer.toString(number[2]) + Integer.toString(number[3])));
    }

    private static boolean numDifferencesBoth(String in1, String in2) {
        boolean difference = true;
        if (numDifferences(in1, in2) == 0) {
            if (numDifferences(in2, in1) == 0) difference = false;
        }
        return(difference);
    }

    private static char findCharacter(int length, String [] temp, String compare1) {
        char returnChar = ' ';
        for (String string : getSegmentsLength(length, temp)) {
            if (numDifferences(compare1, string) == 1) {
                returnChar = stringDifference(compare1, string);
                break;
            }
        }
        return(returnChar);
    }

    private static String[] filterThree(String [] input) {
        String returnThree [] = new String [3];
        for (int i = 0; i < 10; i++) {
            switch (input[i].length()) {      //347
                case 2:
                    returnThree[0] = input[i];
                    break;
                case 3:
                    returnThree[1] = input[i];
                    break;
                case 4:
                    returnThree[2] = input[i];
                    break;
                default:
                    break;
            }
        }
        return(returnThree);
    }

    private static String[] toArray(String input) {
        String returnSArray [] = input.split("( )");
        returnSArray[10] = returnSArray[10].replace("|", "");
        String returnSArrayOut [] = new String [14];
        System.arraycopy(returnSArray, 0, returnSArrayOut, 0, 10);
        System.arraycopy(returnSArray, 11, returnSArrayOut, 10, 4);
        return(returnSArrayOut);
    }

    private static int numDifferences(String in1, String in2) {
        char [] temp = in1.toCharArray();
        int numDifferences = 0;
        int numFalse = temp.length;
        for (char c : in2.toCharArray()) {
            for (char d : temp) {
                if (c != d) {
                    numFalse--;
                }
            }
            if (numFalse == 0) {
                numDifferences++;
                numFalse = temp.length;
            }else {
                numFalse = temp.length;
            }
        }
        return(numDifferences);
    }

    private static char stringDifference(String in1, String in2) {      //(Suche, in)
        char [] temp = in1.toCharArray();
        char returnChar = ' ';
        int numFalse = temp.length;
        for (char c : in2.toCharArray()) {
            for (char d : temp) {
                if (c != d) {
                    numFalse--;
                }
            }
            if (numFalse == 0) {
                returnChar = c;
                break;
            }else {
                numFalse = temp.length;
            }
        }
        return(returnChar);
    }

    private static String[] getSegmentsLength(int length, String [] input) {
        ArrayList <String> out = new ArrayList<>();
        String [] returnS;
        for (String string : input) {
            if (string.length() == length) {
                out.add(string);
            }
        }
        returnS = new String [out.size()];
        for (int i = 0; i < out.size(); i++) {
            returnS[i] = out.get(i);
        }
        return(returnS);
    }

    private static String[] buildStrings(HashMap <Character, Character> map) {
        String [] out = new String [10];

        out[0] = Character.toString(map.get('a')) + Character.toString(map.get('b')) + Character.toString(map.get('c')) + Character.toString(map.get('e')) + Character.toString(map.get('f')) + Character.toString(map.get('g'));
        out[1] = Character.toString(map.get('c')) + Character.toString(map.get('f'));
        out[2] = Character.toString(map.get('a')) + Character.toString(map.get('c')) + Character.toString(map.get('d')) + Character.toString(map.get('e')) + Character.toString(map.get('g'));
        out[3] = Character.toString(map.get('a')) + Character.toString(map.get('c')) + Character.toString(map.get('d')) + Character.toString(map.get('f')) + Character.toString(map.get('g'));
        out[4] = Character.toString(map.get('b')) + Character.toString(map.get('c')) + Character.toString(map.get('d')) + Character.toString(map.get('f'));
        out[5] = Character.toString(map.get('a')) + Character.toString(map.get('b')) + Character.toString(map.get('d')) + Character.toString(map.get('f')) + Character.toString(map.get('g'));
        out[6] = Character.toString(map.get('a')) + Character.toString(map.get('b')) + Character.toString(map.get('d')) + Character.toString(map.get('f')) + Character.toString(map.get('g')) + Character.toString(map.get('e'));
        out[7] = Character.toString(map.get('c')) + Character.toString(map.get('f')) + Character.toString(map.get('a'));
        out[8] = Character.toString(map.get('a')) + Character.toString(map.get('b')) + Character.toString(map.get('c')) + Character.toString(map.get('e')) + Character.toString(map.get('f')) + Character.toString(map.get('g')) + Character.toString(map.get('d'));
        out[9] = Character.toString(map.get('a')) + Character.toString(map.get('b')) + Character.toString(map.get('c')) + Character.toString(map.get('f')) + Character.toString(map.get('g')) + Character.toString(map.get('d'));
        return(out);
    }
}
