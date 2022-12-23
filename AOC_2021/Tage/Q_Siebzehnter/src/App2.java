//Basierend auf annahmen, da mir keine abbruch bedingung für x eingefallen ist...
//-> s. Zeile 39

package Tage.Q_Siebzehnter.src;

import java.util.ArrayList;

public class App2 {
    public static void main(String[] args) throws Exception {
        //Input aus input.txt herausgeschrieben
        System.out.println(numVelocity(56,76,-134,-162));
    }

    
    public static int numVelocity(int xFrom, int xTo, int yFrom, int yTo) {
        ArrayList <String> list = new ArrayList<>();
        
        int sum = 0;

        int latestX = 0;
        int currentX = 0;
        int j = 0;
        while(currentX < xFrom) {
            latestX = currentX;
            currentX = (j*(j+1)/2);
            if (currentX > xFrom && latestX < xFrom) {
                break;
            }
            j++;
        }

        currentX = 0;
        int currentY = 0;
        while(j <= xTo) {
            for(int i = yTo; i < 1000; i++) {
                int currentXSpeed = j;
                int currentYSpeed = i;
                currentX = 0;
                currentY = 0;
                while(!(currentX >= xFrom && currentX <= xTo && currentY <= yFrom && currentY >= yTo)) {
                    currentX += currentXSpeed;
                    currentY += currentYSpeed;
                    if (currentXSpeed != 0) currentXSpeed--;
                    currentYSpeed--;
                    if (currentX > xTo || currentY < yTo) {
                        break;
                    }
                }
                if (currentX <= xTo && currentY >= yTo) {
                    list.add((j + "," + i));
                    sum++;
                }
            }
            j++;
        }
        return(sum);
    }
    
    //Zum testen welche werte fehlten --> Es waren die randwerte von x...
    /*private static ArrayList<String> showOnlyNon(ArrayList <String> input) {
        ArrayList <String> list = new ArrayList<>();
        list.add("23,-10");
        list.add("20,-10");
        list.add("29,-10");
        list.add("30,-10");
        list.add("26,-10");
        list.add("25,-10");
        list.add("22,-10");
        list.add("24,-10");
        list.add("28,-10");
        list.add("21,-10");
        list.add("27,-10");
        list.add("25,-9");
        list.add("27,-5");
        list.add("29,-6");
        list.add("22,-6");
        list.add("21,-7");
        list.add("27,-7");
        list.add("24,-5");
        list.add("25,-7");
        list.add("26,-6");
        list.add("25,-5");
        list.add("11,-2");
        list.add("20,-5");
        list.add("28,-7");
        list.add("30,-6");
        list.add("29,-8");
        list.add("14,-4");
        list.add("21,-6");
        list.add("21,-9");
        list.add("14,-3");
        list.add("20,-8");
        list.add("13,-2");
        list.add("20,-7");
        list.add("28,-8");
        list.add("29,-9");
        list.add("15,-3");
        list.add("22,-5");
        list.add("26,-8");
        list.add("25,-8");
        list.add("25,-6");
        list.add("15,-4");
        list.add("15,-2");
        list.add("12,-2");
        list.add("28,-9");
        list.add("12,-3");
        list.add("24,-6");
        list.add("23,-7");
        list.add("11,-3");
        list.add("26,-7");
        list.add("23,-9");
        list.add("27,-6");
        list.add("22,-8");
        list.add("13,-4");
        list.add("28,-6");
        list.add("11,-4");
        list.add("12,-4");
        list.add("26,-9");
        list.add("10,-2");
        list.add("23,-8");
        list.add("30,-8");
        list.add("10,-1");
        list.add("26,-5");
        list.add("22,-9");
        list.add("11,-1");
        list.add("20,-9");
        list.add("14,-2");
        list.add("29,-7");
        list.add("13,-3");
        list.add("23,-5");
        list.add("24,-8");
        list.add("27,-9");
        list.add("30,-7");
        list.add("28,-5");
        list.add("21,-5");
        list.add("30,-9");
        list.add("21,-8");
        list.add("22,-7");
        list.add("24,-9");
        list.add("20,-6");
        list.add("29,-5");
        list.add("27,-8");
        list.add("30,-5");
        list.add("24,-7");
        list.add("23,-6");
        list.add("8,-2");
        list.add("9,-1");
        list.add("9,-2");
        list.add("8,-1");
        list.add("7,-1");
        list.add("8,0");
        list.add("6,8");
        list.add("9,0");
        list.add("6,7");
        list.add("6,3");
        list.add("6,4");
        list.add("6,1");
        list.add("7,7");
        list.add("6,2");
        list.add("7,3");
        list.add("7,8");
        list.add("7,1");
        list.add("6,0");
        list.add("8,1");
        list.add("6,5");
        list.add("7,6");
        list.add("7,4");
        list.add("7,5");
        list.add("7,0");
        list.add("7,9");
        list.add("6,6");
        list.add("6,9");
        list.add("7,2");
        
        ArrayList <String> out = new ArrayList<>();

        for (String string : list) {
            if (!input.contains(string)) out.add(string);
        }
        return(out);
    }*/
}