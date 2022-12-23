package Tage.J_Zehnter.src.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import Tage.J_Zehnter.src.App;

public class App1_checkClosing {
    
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
        assertEquals('}', App.checkClosing(controlMap, "{([(<{}[<>[]}>{[]{[(<()>".toCharArray()));
    }

    @Test
    public void check2() {
        fillControlMap();
        assertEquals(')', App.checkClosing(controlMap, "[[<[([]))<([[{}[[()]]]".toCharArray()));
    }

    @Test
    public void check3() {
        fillControlMap();
        assertEquals(']', App.checkClosing(controlMap, "[{[{({}]{}}([{[{{{}}([]".toCharArray()));
    }

    @Test
    public void check4() {
        fillControlMap();
        assertEquals(')', App.checkClosing(controlMap, "[<(<(<(<{}))><([]([]()".toCharArray()));
    }

    @Test
    public void check5() {
        fillControlMap();
        assertEquals('>', App.checkClosing(controlMap, "<{([([[(<>()){}]>(<<{{".toCharArray()));
    }

}
