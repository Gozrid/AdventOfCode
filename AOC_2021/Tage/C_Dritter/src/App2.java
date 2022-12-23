package Tage.C_Dritter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App2 {
    private static BufferedReader input;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new FileReader("./Tage/C_Dritter/src/input.txt"));
        ArrayList <String> mostList = new ArrayList<>();
        ArrayList <String> leastList = new ArrayList<>();
        fillArrayList(mostList);
        copyArrayList(mostList, leastList);

        for(int i = 0; i < mostList.get(0).length(); i++) {
            boolean mostCommon = getMostCommonAt(mostList, i);
            for (int j = mostList.size() - 1; j >= 0; j--) {
                if (mostList.size() == 1) {
                    break;
                }else if (mostCommon != charToBoolean(mostList.get(j).toCharArray()[i])){
                    mostList.remove(j);
                }
            }
        }

        for(int i = 0; i < leastList.get(0).length(); i++) {
            boolean leastCommon = getLeastCommonAt(leastList, i);
            for(int j = leastList.size() - 1; j >= 0; j--) {
                if (leastList.size() == 1) {
                    break;
                }
                if (leastCommon != charToBoolean(leastList.get(j).toCharArray()[i])) {
                    leastList.remove(j);
                }
            }
        }

        System.out.println(mostList.get(0));
        System.out.println(leastList.get(0));

        System.out.println(calculateProductFromBinary(mostList.get(0), leastList.get(0)));

        input.close();
    }

    public static boolean getMostCommonAt(ArrayList <String> list, int index) {
        boolean returnMost;
        int numOfOnes = 0;
        int numOfZeros = 0;
        for (int i = 0; i < list.size(); i++) {
            switch (Integer.parseInt(Character.toString(list.get(i).toCharArray()[index]))) {
                case 0:
                    numOfZeros++;
                    break;
                case 1:
                    numOfOnes++;
                    break;
                default:
                    break;
            }            
        }
        System.out.println(numOfOnes);
        if (numOfOnes == numOfZeros) {
            returnMost = true;
        }else if (numOfOnes > numOfZeros) {
            returnMost = true;
        }else{
            returnMost = false;
        }
        return(returnMost);
    }

    public static boolean getLeastCommonAt(ArrayList <String> list, int index) {
        boolean returnLeast;
        int numOfOnes = 0;
        int numOfZeros = 0;
        for (int i = 0; i < list.size(); i++) {
            switch (Integer.parseInt(Character.toString(list.get(i).toCharArray()[index]))) {
                case 0:
                    numOfZeros++;
                    break;
                case 1:
                    numOfOnes++;
                    break;
                default:
                    break;
            }            
        }
        if (numOfOnes == numOfZeros) {
            returnLeast = false;
        }else if (numOfOnes > numOfZeros) {
            returnLeast = false;
        }else {
            returnLeast = true;
        }
        return(returnLeast);
    }

    private static void copyArrayList(ArrayList <String> source, ArrayList <String> destination) {
        source.forEach((value) -> {
            destination.add(value);
        });
    }

    private static void fillArrayList(ArrayList <String> list) throws IOException {
        while(input.ready()) {
            list.add(input.readLine());
        }
    }

    public static boolean charToBoolean(char input) {
        boolean returnBool;
        switch (input) {
            case '0':
                returnBool = false;
                break;
            case '1':
                returnBool = true;
                break;
            default:
                returnBool = true;
                System.exit(0);
                break;
        }
        return(returnBool);
    }

    public static int calculateProductFromBinary(String multOne, String multTwo) {
        int returnCalcProduct = 0;
        int multOneInt = Integer.parseInt(multOne, 2);
        int multTwoInt = Integer.parseInt(multTwo, 2);
        returnCalcProduct = multOneInt * multTwoInt;
        return(returnCalcProduct);
    }
}