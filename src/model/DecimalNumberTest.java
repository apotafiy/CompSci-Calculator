package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalNumberTest {

    @Test
    void testToString() {
        DecimalNumber num = new DecimalNumber(-13);
        assertEquals(num.toString(), "-13");

        num = new DecimalNumber(0);
        assertEquals(num.toString(), "0");

        num = new DecimalNumber(43);
        assertEquals(num.toString(), "43");
    }
}