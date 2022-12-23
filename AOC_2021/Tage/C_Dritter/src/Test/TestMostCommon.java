package Tage.C_Dritter.src.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Tage.C_Dritter.src.*;

public class TestMostCommon {

    ArrayList <String> list = new ArrayList<>();

    private void fillList() {
        list.add("0100110101");
        list.add("1011010100");
        list.add("0010110101");

        for (String string : list) {
            System.out.println(string);
        }
    }

    @Test
    public void TestMostCommonFalseAtFirst() {
        fillList();
        assertEquals(false, App2.getMostCommonAt(list, 0));
    }

    @Test
    public void TestMostCommonFalseAtSecond() {
        fillList();
        assertEquals(false, App2.getMostCommonAt(list, 1));
    }

    @Test
    public void TestMostCommonFalseAtThird() {
        fillList();
        assertEquals(true, App2.getMostCommonAt(list, 2));
    }

    @Test
    public void TestMostCommonFalseAtFourth() {
        fillList();
        assertEquals(false, App2.getMostCommonAt(list, 3));
    }

    @Test
    public void TestMostCommonFalseAtFifith() {
        fillList();
        assertEquals(true, App2.getMostCommonAt(list, 4));
    }

    @Test
    public void TestMostCommonFalseAt6() {
        fillList();
        assertEquals(true, App2.getMostCommonAt(list, 5));
    }

    @Test
    public void TestMostCommonFalseAt7() {
        fillList();
        assertEquals(false, App2.getMostCommonAt(list, 6));
    }

    @Test
    public void TestMostCommonFalseAt8() {
        fillList();
        assertEquals(true, App2.getMostCommonAt(list, 7));
    }

    @Test
    public void TestMostCommonFalseAt9() {
        fillList();
        assertEquals(false, App2.getMostCommonAt(list, 8));
    }

    @Test
    public void TestMostCommonFalseAt10() {
        fillList();
        assertEquals(true, App2.getMostCommonAt(list, 9));
    }

    
}
