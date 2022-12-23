package Tage.P_Sechszehnter.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestIndividuals {
    
    @Test
    public void testType4() {
        String actual = "D2FE28";
        int expected = 6;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }

    @Test
    public void testLength0() {
        String actual = "38006F45291200";
        int expected = 9;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }

    @Test
    public void testLength1() {
        String actual = "EE00D40C823060";
        int expected = 14;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }

}
