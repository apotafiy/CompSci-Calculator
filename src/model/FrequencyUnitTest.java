package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
class FrequencyUnitTest {

    @Test
    void testToString() {
        FrequencyUnit unit = new FrequencyUnit(123, FrequencyUnit.FrequencyU.DAY);
        assertEquals(unit.toString(), "123.0 per day");

        unit = new FrequencyUnit(-13, FrequencyUnit.FrequencyU.HOUR);
        assertEquals(unit.toString(), "-13.0 per hour");

        unit = new FrequencyUnit(0, FrequencyUnit.FrequencyU.MONTH);
        assertEquals(unit.toString(), "0.0 per month");
    }
}