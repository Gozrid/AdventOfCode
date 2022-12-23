package Tage.I_Neunter.src;

public class Coordinates {
    
    private int x;
    private int y;
    private int value;

    public Coordinates (int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int X() {
        return(x);
    }

    public int Y() {
        return(y);
    }

    public int value() {
        return(value);
    }

    public boolean compare(Coordinates coordinates) {
        int numTrue = 0;
        if (coordinates.X() == this.x) {
            numTrue++;
        }
        if (coordinates.Y() == this.y) {
            numTrue++;
        }
        if (numTrue == 2) {
            return(true);
        }else {
            return(false);
        }
    }

}
