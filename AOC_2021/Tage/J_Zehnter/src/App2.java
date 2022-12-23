package Tage.J_Zehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class App2 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/J_Zehnter/src/input.txt"));
        HashMap <Character, Character> controlMap = new HashMap<>();
        ArrayList <String> list = new ArrayList<>();
        controlMap.put('(', ')');
        controlMap.put('{', '}');
        controlMap.put('[', ']');
        controlMap.put('<', '>');

        while(input.ready()) {
            char [] in = input.readLine().toCharArray();
            char t = App.checkClosing(controlMap, in);      //!Nutze etwas von App.java
            String s = autocomplete(in, controlMap);
            if (t == 'n') if(s  != "") list.add(s); 
        }

        ArrayList <Long> sum = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            char [] t = list.get(i).toCharArray();
            long product = 0;
            for (int j = 0; j < t.length; j++) {
                product *= 5;
                switch (t[j]) {
                    case ')':
                        product += 1;
                        break;
                    case ']':
                        product += 2;
                        break;
                    case '}':
                        product += 3;
                        break;
                    case '>':
                        product += 4;
                        break;
                    default:
                        break;
                }
            }
            sum.add(product);
        }
        Collections.sort(sum);
        System.out.println(sum.get((sum.size()/2)));
        input.close();
    }

    public static String autocomplete(char [] input, HashMap <Character, Character> controlMap) {
        String returnElement = "";
        Stack <Character> t = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (t.empty()) {
                t.push(controlMap.get(input[i]));
            }else {
                if (t.peek() == input[i]) {
                    t.pop();
                }else if (controlMap.containsKey(input[i])) {
                    t.push(controlMap.get(input[i]));
                }
            }
        } 
        for (Character character : t) {
            returnElement += character;
        }
        return(new StringBuilder(returnElement).reverse().toString());
    }
}