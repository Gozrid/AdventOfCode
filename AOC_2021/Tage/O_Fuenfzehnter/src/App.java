//Zu lange, algorithmus zu ineffizient...

package Tage.O_Fuenfzehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/O_Fuenfzehnter/src/input/input.txt"));

        char[] inputS = input.readLine().toCharArray();
        int [] [] map = new int [inputS.length] [inputS.length];
        for (int i = 0; i < inputS.length; i++) {
            map [0] [i] = Integer.parseInt(Character.toString(inputS[i]));
        }
        int counter = 1;
        while(input.ready()) {
            inputS = input.readLine().toCharArray();
            for (int i = 0; i < inputS.length; i++) {
                map [counter] [i] = Integer.parseInt(Character.toString(inputS[i]));
            }
            counter++;
        }
        
        System.out.println(searchShortestWayInInt(0, 0, map, 0, Integer.MAX_VALUE));
        
        /*for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();;
        }*/
        
        /*ArrayList <Integer> wayLengths = new ArrayList<>();
        ArrayList <Coordinates> wayTo = new ArrayList<>();
        wayTo.add(new Coordinates(0, 0, 0));
        int currentWayLength = 0;
        searchShortestWay(wayTo, map, wayLengths, currentWayLength);
        System.out.println(wayLengths.size());
        */
        input.close();
    }

    private static int searchShortestWayInInt(int x, int y, int [] [] map, int currentWayLength, int currentShortestWay) {
        if (currentWayLength >= currentShortestWay) {
            return(currentShortestWay);
        }else if (x == (map[0].length-1) && y == (map.length-1)){
            System.out.println("hi" + currentWayLength);
            return(currentWayLength);
        }else {
            int[] [] ways = new int [2][2];
            ways [0] [0] = x;
            ways [0] [1] = Integer.min(y+1, map.length-1);
            ways [1] [0] = Integer.min(x+1, map[0].length-1);
            ways [1] [1] = y;

            if (map[ways[0] [1]] [ways[0] [0]] - map[ways[1] [1]] [ways[1] [0]] > 3) {
                ways[0] [0] = x;
                ways[0] [1] = y;
            }
            if (map[ways[0] [1]] [ways[0] [0]] - map[ways[1] [1]] [ways[1] [0]] < -3) {
                ways[1] [0] = x;
                ways[1] [1] = y;
            }

            if (map[ways[0] [1]] [ways[0] [0]] > map[ways[1] [1]] [ways[1] [0]]){
                for (int i = 1; i >= 0; i--) {
                    if (ways[0+i] [0] != x || ways[0+i] [1] != y){
                        int currentWayLengthNew = currentWayLength + map[ways[0+i] [1]] [ways[0+i] [0]];
                        currentShortestWay = searchShortestWayInInt(ways[0+i] [0], ways[0+i] [1], map, currentWayLengthNew, currentShortestWay);
                    }
                }
            }else {
                for (int i = 0; i < 2; i++) {
                    if (ways[0+i] [0] != x || ways[0+i] [1] != y){
                        int currentWayLengthNew = currentWayLength + map[ways[0+i] [1]] [ways[0+i] [0]];
                        currentShortestWay = searchShortestWayInInt(ways[0+i] [0], ways[0+i] [1], map, currentWayLengthNew, currentShortestWay);
                    }
                }
            }
            return(currentShortestWay);
        }
    }

    /*private static void searchShortestWay(ArrayList<Coordinates> wayTo, int [] [] map, ArrayList<Integer> wayLengths, int currentWayLength) {
        int x = wayTo.get(wayTo.size()-1).getX();
        int y = wayTo.get(wayTo.size()-1).getY();
        if (wayTo.size() > (20) || ) {

        }else if ((wayTo.get(wayTo.size()-1).getX() == map[0].length-1) && (wayTo.get(wayTo.size()-1).getY() == map.length-1)) {
            //System.out.println("hi");
            wayLengths.add(currentWayLength);
        } else {
            Stack <Coordinates> ways = new Stack<>();
            ways.add(new Coordinates(x, Integer.min(y+1, map.length-1), map [Integer.min(y+1, map.length-1)] [x]));
            ways.add(new Coordinates(x, Integer.max(y-1, 0), map [Integer.max(y-1, 0)] [x]));
            ways.add(new Coordinates(Integer.min(x+1, map[0].length-1), y, map[y][Integer.min(x+1, map[0].length-1)]));
            ways.add(new Coordinates(Integer.max(x-1, 0), y, map[y] [Integer.max(x-1,0)]));
            //System.out.println(ways.size());
            for (Coordinates co : wayTo) {
                for (int i = ways.size()-1; i >= 0; i--) {
                    if (co.equals(ways.get(i))) ways.remove(ways.get(i));
                }
            }
            //for (Coordinates coordinates : ways) {
            //    System.out.println(coordinates.getX() + ":" + coordinates.getY());
            //}
            System.out.println("---");
            //System.out.println(ways.size());
            //System.out.println("-----");
            for (Coordinates coordinates : ways) {
                int currentWayLengthNew = currentWayLength + coordinates.getValue();
                ArrayList <Coordinates> wayToNew = new ArrayList<>();
                wayToNew.addAll(wayTo);
                wayToNew.add(coordinates);
                searchShortestWay(wayToNew, map, wayLengths, currentWayLengthNew);
            }
        }
    }*/

    /*private static ArrayList <ArrayList<Coordinates>> searchWays(ArrayList <ArrayList <Coordinates>> completeWay, int [] [] map, ArrayList <Coordinates> previousWay, Coordinates myCoordinates, int x, int y) {
        ArrayList < Coordinates> previousWay2 = new ArrayList<>(); 
        previousWay2.addAll(previousWay);
        previousWay2.add(myCoordinates);
        if (myCoordinates.getX() == map[0].length-1 && myCoordinates.getY() == map.length-1) {
            completeWay.add(previousWay2);
            return(completeWay);
        };
        Stack <Coordinates> ways = new Stack<>();
        ways.add(new Coordinates(x, Integer.min(y+1, map.length-1), map [Integer.min(y+1, map.length-1)] [x]));
        ways.add(new Coordinates(x, Integer.max(y-1, 0), map [Integer.max(y-1, 0)] [x]));
        ways.add(new Coordinates(Integer.min(x+1, map[0].length-1), y, map[y][Integer.min(x+1, map[0].length-1)]));
        ways.add(new Coordinates(Integer.max(x-1, 0), y, map[y] [Integer.max(x-1,0)]));
        for (int i = ways.size()-1; i >= 0; i--) {
            //System.out.println("myX: " + myCoordinates.getX() + "myY: " + myCoordinates.getY() + "X: " + ways.get(i).getX() + "Y: " + ways.get(i).getY());
            if (ways.get(i).equals(myCoordinates)) ways.remove(ways.get(i));
        }
        for (Coordinates co : previousWay2) {
            for (int i = ways.size()-1; i >= 0; i--) {
                if (co.equals(ways.get(i))) ways.remove(ways.get(i));
            }
        }
        //System.out.println(ways.size());
        for (Coordinates co : ways) {
            ArrayList <ArrayList <Coordinates>> t = searchWays(completeWay, map, previousWay2, co, co.getX(), co.getY());
            if (t != null) completeWay.add(previousWay2);
        }
        return(completeWay);
    }*/
}
