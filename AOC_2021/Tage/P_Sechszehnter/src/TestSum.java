package Tage.P_Sechszehnter.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestSum {

    @Test
    public void test1() {
        String actual = "8A004A801A8002F478";
        int expected = 16;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }
    
    @Test
    public void test2() {
        String actual = "620080001611562C8802118E34";
        int expected = 12;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }
    @Test
    public void test3() {
        String actual = "C0015000016115A2E0802F182340";
        int expected = 23;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }
    @Test
    public void test4() {
        String actual = "A0016C880162017C3686B18A3D4780";
        int expected = 31;
        assertEquals(expected, App.sumUpVersionNumbers(actual));
    }

}
