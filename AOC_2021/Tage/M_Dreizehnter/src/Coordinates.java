package Tage.M_Dreizehnter.src;

public class Coordinates {
    
    private int x;
    private int y;

    public Coordinates(String input []){
        this.x = Integer.parseInt(input[0]);
        this.y = Integer.parseInt(input[1]);
    }

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return(x);
    }

    public int getY() {
        return(y);
    }

    public void putX(int x) {
        this.x = x;
    }

    public void putY(int y) {
        this.y = y;
    }

    public boolean equals(Coordinates o) {
        if (this.x == o.getX() && this.y == o.getY()) return(true);
        return(false);
    }

    public String toString() {
        return(("x:" + x + ", y:" + y));
    }

}   

