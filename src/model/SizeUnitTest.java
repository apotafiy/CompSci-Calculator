package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeUnitTest {

    @Test
    void testToString() {
        SizeUnit unit = new SizeUnit(123, SizeUnit.SizeU.BYTES);
        assertEquals("123.0 bytes",unit.toString());

        unit = new SizeUnit(123, SizeUnit.SizeU.GIGABYTES);
        assertEquals("123.0 gigabytes",unit.toString());

        unit = new SizeUnit(123, SizeUnit.SizeU.MEGABYTES);
        assertEquals("123.0 megabytes",unit.toString());
    }
}