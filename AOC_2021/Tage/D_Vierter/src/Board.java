package Tage.D_Vierter.src;

public class Board {

    int [] [] boardInt = new int [5] [5];
    boolean [] [] boardBoolean = new boolean [boardInt.length] [boardInt[0].length];       //Marks on board

    public Board (String [] input){
        for (int i = 0; i < boardInt.length; i++) {
            String [] rows = splitStringToStringArray(input[i]);
            for (int j = 0; j < boardInt[0].length; j++) {
                boardInt[i] [j] = Integer.parseInt(rows [j]);
                boardBoolean[i] [j] = false;
            }
        }
    }

    public int calculateSumOfUnmarked() {
        int sum = 0;
        for (int i = 0; i < boardInt.length; i++) {
            for (int j = 0; j < boardInt[0].length; j++) {
                if (boardBoolean[i][j] != true) sum += boardInt[i][j];
            }
        }
        return(sum);
    }

    public boolean markAndCheck(int input) {
        mark(input);
        return(check(input));
    }

    public void mark(int input) {
        for (int i = 0; i < boardInt.length; i++) {
            for (int j = 0; j < boardInt[0].length; j++) {
                if (input == boardInt[i] [j]) {
                    boardBoolean[i][j] = true;
                    break;
                }
            }
        }
    }

    public boolean check(int input) {
        int X = 0;
        int Y = 0;
        for (int i = 0; i < boardInt.length; i++) {
            for (int j = 0; j < boardInt[0].length; j++) {
                if (input == boardInt[i] [j]){
                    X = i;
                    Y = j;
                    break;
                }
            }
        }

        int counterX = 0;
        int counterY = 0;
        for (int i = 0; i < boardInt.length; i++) {
            if (boardBoolean[i][Y]) counterX++;
            if (boardBoolean[X][i]) counterY++; 
        }
        if (counterX - 5 == 0 || counterY - 5 == 0) {
            return(true);
        }else{
            return(false);
        }
    }

    private String [] splitStringToStringArray (String input) {
        String [] in = input.split("(?<=\\G...)");
        for (int i = 0; i < in.length; i++) {
            in[i] = in[i].replaceAll("\\s", "");
        }
        return(in);
    }

    public void output () {
        for (int i = 0; i < boardInt.length; i++) {
            for (int j = 0; j < boardInt[0].length; j++) {
                System.out.print(boardInt[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < boardInt.length; i++) {
            for (int j = 0; j < boardInt[0].length; j++) {
                System.out.print(boardBoolean[i][j] ? 1 : 0);
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
