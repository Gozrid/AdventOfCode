package Tage.C_Dritter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/C_Dritter/src/input.txt"));

        ArrayList <String> list = new ArrayList<>();
        int [] outputInt;
        boolean [] output;
        int inputFileLength = 0;
        String outputSG = "";
        String outputSE = "";

        while(input.ready()) {
            inputFileLength++;
            list.add(input.readLine());
        }

        outputInt = toIntArray(list.get(0).toCharArray());
        output = new boolean [outputInt.length];
        for (int i = 1; i < list.size(); i++) {
            int [] iterableInt = toIntArray(list.get(i).toCharArray());
            for (int j = 0; j < outputInt.length; j++) {
                outputInt[j] += iterableInt[j];
            }
        }

        for (int i = 0; i < output.length; i++) {
            if (outputInt[i] < (inputFileLength/2)) {
                output[i] = false;
            }else {
                output[i] = true;
            }
        }

        for (boolean b : output) {
            outputSG += b ? "1" : "0";
            outputSE += b ? "0" : "1";
        }

        System.out.println((Integer.parseInt(outputSE, 2) * Integer.parseInt(outputSG, 2)));
        input.close();
    }

    private static int [] toIntArray(char [] input) {
        int [] returnInt = new int [input.length];
        for (int i = 0; i < input.length; i++) {
            returnInt[i] = Integer.parseInt(Character.toString(input [i]));
        }
        return(returnInt);
    }
}
