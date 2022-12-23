package Tage.M_Dreizehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/M_Dreizehnter/src/input/input.txt"));
        ArrayList <String> foldAt = new ArrayList<>();
        ArrayList <Coordinates> coordinates= new ArrayList<>();

        while(input.ready()) {
            String nextLine = input.readLine();
            while (!(nextLine.equals(""))) {
                coordinates.add(new Coordinates(nextLine.split(",")));
                nextLine = input.readLine();
            }
            while(input.ready()) {
                foldAt.add(input.readLine().split(" ")[2]);
            }
        }
        coordinates = Mirror_x(coordinates, Integer.parseInt(foldAt.get(0).split("=")[1]));
        System.out.println(coordinates.size());
        input.close();
    }

    private static ArrayList <Coordinates> Mirror_x(ArrayList <Coordinates> coordinates, int xAt) {
        for (Coordinates c : coordinates) {
            if (c.getX() > xAt) {
                c.putX((xAt - (c.getX() - xAt)));
            }
        }
        return(cleanCoordinates(coordinates));
    }

    public static ArrayList <Coordinates> cleanCoordinates(ArrayList <Coordinates> coordinates) {
        ArrayList <Coordinates> out = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            int notIn = 0;
            for (int j = 0; j < out.size(); j++) {
                if (!(coordinates.get(i).equals(out.get(j)))){
                    notIn++;
                } 
            }
            if (notIn == out.size()) {
                out.add(coordinates.get(i));
            }
            notIn = 0;
        }
        return(out);
    }
}
