package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNumberTest {

    @Test
    void testToString() {
        BinaryNumber num = new BinaryNumber(-11);
        assertEquals(num.toString(), "-1011");

        num = new BinaryNumber(0);
        assertEquals(num.toString(), "0");

        num = new BinaryNumber(15);
        assertEquals(num.toString(), "1111");
    }
}