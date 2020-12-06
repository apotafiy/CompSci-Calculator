package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateUnitTest {

    @Test
    void testToString() {
        RateUnit unit = new RateUnit(56, RateUnit.RateU.TBIT);
        assertEquals("56.0 tbit/s",unit.toString());

        unit = new RateUnit(56, RateUnit.RateU.MBIT);
        assertEquals("56.0 mbit/s",unit.toString());

        unit = new RateUnit(56, RateUnit.RateU.BIT);
        assertEquals("56.0 bit/s",unit.toString());
    }
}