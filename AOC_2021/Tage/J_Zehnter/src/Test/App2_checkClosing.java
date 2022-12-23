package Tage.J_Zehnter.src.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import Tage.J_Zehnter.src.App2;

public class App2_checkClosing {
    
    HashMap <Character, Character> controlMap = new HashMap<>();
    
    private void fillControlMap() {
        controlMap.put('(', ')');
        controlMap.put('{', '}');
        controlMap.put('[', ']');
        controlMap.put('<', '>');
    }

    @Test
    public void check1() {
        fillControlMap();
        assertEquals("}}]])})]", App2.autocomplete("[({(<(())[]>[[{[]{<()<>>".toCharArray(), controlMap));
    }

    @Test
    public void check2() {
        fillControlMap();
        assertEquals(")}>]})", App2.autocomplete("[(()[<>])]({[<{<<[]>>(".toCharArray(), controlMap));
    }

    @Test
    public void check3() {
        fillControlMap();
        assertEquals("}}>}>))))", App2.autocomplete("(((({<>}<{<{<>}{[]{[]{}".toCharArray(), controlMap));
    }

    @Test
    public void check4() {
        fillControlMap();
        assertEquals("]]}}]}]}>", App2.autocomplete("{<[[]]>}<{[{[{[]{()[[[]".toCharArray(), controlMap));
    }

    @Test
    public void check5() {
        fillControlMap();
        assertEquals("])}>", App2.autocomplete("<{([{{}}[<[[[<>{}]]]>[]]".toCharArray(), controlMap));
    }


}
