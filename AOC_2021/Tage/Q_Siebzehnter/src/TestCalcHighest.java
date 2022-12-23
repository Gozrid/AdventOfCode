package Tage.Q_Siebzehnter.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestCalcHighest {
    
     @Test
     public void test1() {
         //String input = "target area: x=20..30, y=-10..-5";
         int expected = 45;
         assertEquals(expected, App.calcHighestPoint(20,30,-5,-10));
     }

}
