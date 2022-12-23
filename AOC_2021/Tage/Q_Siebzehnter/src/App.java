//Basierend auf Annahmen, da mir keine Abbruchbedingung eingefallen ist
//-> s. Zeile 14

package Tage.Q_Siebzehnter.src;

public class App {
    public static void main(String[] args) throws Exception {
        //Input aus input.txt herausgeschrieben
        System.out.println(calcHighestPoint(20,30,-134,-162));
    }

    public static int calcHighestPoint(int xFrom, int xTo, int yFrom, int yTo) {
        int maxY = 0;
        for (int j = 0; j < 1000; j++) {
            int currentY = 0;
            int ySpeed = j;
            int tHeight = 0;
            int lastY = 0;
            while(currentY >= yTo) {
                if (ySpeed == 0) tHeight = currentY;
                lastY = currentY;
                currentY += ySpeed;
                ySpeed--;
            }
            if (lastY >= yTo && lastY <= yFrom) if (maxY < tHeight) {
                maxY = tHeight;
            }
        }
        return(maxY);
    }
}
