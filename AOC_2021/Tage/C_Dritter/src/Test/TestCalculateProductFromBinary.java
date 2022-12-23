package Tage.C_Dritter.src.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Tage.C_Dritter.src.App2;

public class TestCalculateProductFromBinary {
    @Test
    public void test1() {
        assertEquals(200, App2.calculateProductFromBinary("00000001010", "00000010100"));
    }

    @Test
    public void test2() {
        assertEquals(546165, App2.calculateProductFromBinary("000101", "11010101010110001"));
    }
    
}