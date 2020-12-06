package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexNumberTest {

    @Test
    void testToString() {
        HexNumber num = new HexNumber(-12);
        assertEquals("-c",num.toString());

        num = new HexNumber(0);
        assertEquals("0",num.toString());

        num = new HexNumber(42);
        assertEquals("2a",num.toString());
    }
}