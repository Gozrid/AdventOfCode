//Doofe Aufgabe, viel fleiß arbeit...

/*package Tage.P_Sechszehnter.src;

import java.util.HashMap;

public class App2 {
    public static void main(String[] args) throws Exception {
        System.out.println();
    }

    
    public static int calcExpression(String input) {
        String completeText = toBits(input);

        int sum = returnVersionNumberSum(completeText)[1];

        return(sum);
    }

    private static int [] returnCalc(int typeID, String input) {
        switch (typeID) {
            case 0:
                int [] t = returnVersionNumberSum(input.substring(beginIndex))
                for(int i = 1; i < )
                break;
        
            case 1:
                
                break;
        
            case 2:
                
                break;
        
            case 3:
                
                break;
        
            case 4:
                
                break;
        
            case 5:
                
                break;
        
            case 6:
                
                break;
        
            case 7:
                
                break;
        
            default:
                break;
        }
    }

    private static int[] returnVersionNumberSum(String input) {
        int [] outVersionEndAt = new int [2];
        int version = 0;
        int endAt = 0;
        if (input.length() > 11) {
            version = Integer.parseInt(input.substring(0,3), 2);
            int typeID = Integer.parseInt(input.substring(3,6), 2);

            if (typeID == 4) {
                int out [] = type4(input);
                return(out);
            }else{
                int lengthHeader = Integer.parseInt(input.substring(6,7), 2);
                int t [];
                switch (lengthHeader) {
                    case 0:
                        int length = Integer.parseInt(input.substring(7, 22), 2);
                        endAt = 22;
                        while((endAt - 21) < length) {
                            t = returnVersionNumberSum(input.substring(endAt));
                            endAt += t[1];
                            version += t[0];
                        }
                        t= returnVersionNumberSum(input.substring(endAt));
                        version += t[0];
                        endAt += t[1];
                        break;
    
                    case 1:
                        int numPackets = Integer.parseInt(input.substring(7,18), 2);
                        endAt = 18;
                        for(int i = 0; i < numPackets; i++) {
                            t = returnVersionNumberSum(input.substring(endAt));
                            endAt += t[1];
                            version += t[0];
                        }
                        t = returnVersionNumberSum(input.substring(endAt));
                        version += t[0];
                        endAt += t[1];
                        break;
    
                    default:
                        break;
                }
            }
        }
        outVersionEndAt[0] = version;
        outVersionEndAt[1] = endAt;
        return(outVersionEndAt);
    }

    private static int[] type4(String input) {
        int out [] = new int [2];
        String buildS = "";
        String sub = input.substring(6,11);
        int endAt = 11;
        while(sub.charAt(0) != '0') {
            buildS += Integer.parseInt(sub.substring(1,5), 2);
            sub = input.substring(endAt, endAt+5);
            endAt += 5;
        }
        out[0] = endAt;
        out[1] = Integer.parseInt(buildS);
        return(out);
    }







    private static String toBits(String input) {
        HashMap <Character, String> hexToBin = new HashMap<>();
        hexToBin.put('0', "0000");
        hexToBin.put('1', "0001");
        hexToBin.put('2', "0010");
        hexToBin.put('3', "0011");
        hexToBin.put('4', "0100");
        hexToBin.put('5', "0101");
        hexToBin.put('6', "0110");
        hexToBin.put('7', "0111");
        hexToBin.put('8', "1000");
        hexToBin.put('9', "1001");
        hexToBin.put('A', "1010");
        hexToBin.put('B', "1011");
        hexToBin.put('C', "1100");
        hexToBin.put('D', "1101");
        hexToBin.put('E', "1110");
        hexToBin.put('F', "1111");
        
        String out = "";
        for (char c : input.toCharArray()) {
            out += hexToBin.get(c);
        }
        return(out);
    }
}
*/