package Tage.C_Dritter.src.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Tage.C_Dritter.src.App2;

public class TestCharToBoolean {
@Test
public void testFalse() {
    assertEquals(false, App2.charToBoolean('0'));
}

@Test
public void testTrue() {
    assertEquals(true, App2.charToBoolean('1'));
}
}
