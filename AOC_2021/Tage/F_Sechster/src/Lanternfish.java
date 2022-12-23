package Tage.F_Sechster.src;

public class Lanternfish {
    
    private int days;

    public Lanternfish (int days) {
        this.days = days;
    }

    public boolean cycle() {
        if (days == 0) {
            days = 6;
            return(true);
        }else {
            days--;
            return(false);
        }
    }

}
