package Tage.J_Zehnter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("./Tage/J_Zehnter/src/input.txt"));
        HashMap <Character, Character> controlMap = new HashMap<>();
        ArrayList <Character> list = new ArrayList<>();
        controlMap.put('(', ')');
        controlMap.put('{', '}');
        controlMap.put('[', ']');
        controlMap.put('<', '>');

        while(input.ready()) {
            char [] in = input.readLine().toCharArray();
            char t = checkClosing(controlMap, in);
            if (t != 'n') list.add(t); 
        }

        int sum = 0;
        for (Character character : list) {
            switch (character) {
                case ')':
                    sum += 3;
                    break;
                case ']':
                    sum += 57;
                    break;
                case '}':
                    sum += 1197;
                    break;
                case '>':
                    sum += 25137;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sum);
        input.close();
    }

    public static char checkClosing(HashMap <Character, Character> controlMap, char [] input) {
        char returnElement = 'n';
        Stack <Character> t = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (t.empty()) {
                t.push(controlMap.get(input[i]));
            }else {
                if (t.peek() == input[i]) {
                    t.pop();
                }else if (controlMap.containsKey(input[i])) {
                    t.push(controlMap.get(input[i]));
                }else {
                    returnElement = input[i];
                    break;
                }
            }
        }
        return(returnElement);
    }
}