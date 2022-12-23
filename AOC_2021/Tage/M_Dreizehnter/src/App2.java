package Tage.M_Dreizehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App2 {
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

        for (String s : foldAt) {
            String [] todo = s.split("=");
            switch (todo[0]) {
                case "x":
                    coordinates = Mirror_x(coordinates, Integer.parseInt(todo[1]));
                    break;
                case "y":
                    coordinates = Mirror_y(coordinates, Integer.parseInt(todo[1]));
                    break;
                default:
                    break;
            }
        }
        System.out.println(coordinates.size());
        displayNumbers(coordinates);
        input.close();
    }

    private static void displayNumbers(ArrayList <Coordinates> coordinates) {
        int maxX = 0;
        int maxY = 0;
        for (Coordinates c : coordinates) {
            if (c.getX() > maxX) maxX = c.getX();
            if (c.getY() > maxY) maxY = c.getY();
        }
        boolean [] [] display = new boolean[maxX+1] [maxY+1];

        for (Coordinates c : coordinates) {
            display[c.getX()] [c.getY()] = true;
        }

        for(int i = 0; i < display[0].length; i++) {
            for (int j = 0; j < display.length; j++) {
                System.out.print(display[j][i] ? '#' : '.');
            }
            System.out.println();
        }
    }

    private static ArrayList <Coordinates> Mirror_x(ArrayList <Coordinates> coordinates, int xAt) {
        for (Coordinates c : coordinates) {
            if (c.getX() > xAt) {
                c.putX((xAt - (c.getX() - xAt)));
            }
        }
        return(cleanCoordinates(coordinates));
    }
    
    private static ArrayList <Coordinates> Mirror_y(ArrayList <Coordinates> coordinates, int yAt) {
        for (Coordinates c : coordinates) {
            if (c.getY() > yAt) {
                c.putY((yAt - (c.getY() - yAt)));
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
