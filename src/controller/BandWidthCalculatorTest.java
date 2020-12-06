package controller;

import model.FrequencyUnit;
import model.RateUnit;
import model.SizeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BandWidthCalculatorTest {

    @Test
    void WBCalculator() {
        FrequencyUnit frequencyUnit;
        SizeUnit sizeUnit;
        int redundancy;
        String expected;
        String actual;

        frequencyUnit = new FrequencyUnit(123, FrequencyUnit.FrequencyU.MINUTE);
        sizeUnit = new SizeUnit(321, SizeUnit.SizeU.BYTES);
        redundancy = 2;
        expected = "Bandwidth needed is 0.0052644 Mbits/s or 1.7293554 GB per month.\n" +
                "With redundancy factor of 2, the bandwidth needed is 0.0105288 Mbits/s or 3.4587108 GB per month.";
        actual = BandWidthCalculator.WBCalculator(frequencyUnit, sizeUnit, redundancy);
        assertEquals(expected, actual);


        frequencyUnit = new FrequencyUnit(45, FrequencyUnit.FrequencyU.HOUR);
        sizeUnit = new SizeUnit(6, SizeUnit.SizeU.GIGABYTES);
        redundancy = 1;
        expected = "Bandwidth needed is 600.0 Mbits/s or 197100.0 GB per month.";
        actual = BandWidthCalculator.WBCalculator(frequencyUnit, sizeUnit, redundancy);
        assertEquals(expected, actual);


        frequencyUnit = new FrequencyUnit(1, FrequencyUnit.FrequencyU.MONTH);
        sizeUnit = new SizeUnit(64, SizeUnit.SizeU.KILOBYTES);
        redundancy = 1;
        expected = "Bandwidth needed is 1.9482496194824962E-7 Mbits/s or 6.4E-5 GB per month.";
        actual = BandWidthCalculator.WBCalculator(frequencyUnit, sizeUnit, redundancy);
        assertEquals(expected, actual);
    }

    @Test
    void HBConverter() {
        SizeUnit sizeUnit;
        RateUnit.RateU rateU;
        String expected;
        String actual;

        sizeUnit = new SizeUnit(45, SizeUnit.SizeU.BYTES);
        rateU = RateUnit.RateU.KBIT;
        expected = "45.0 bytes per month is equivalent to 1.36986301369863E-7 Kbit/s";
        actual = BandWidthCalculator.HBConverter(sizeUnit, rateU);
        assertEquals(expected, actual);

        sizeUnit = new SizeUnit(5, SizeUnit.SizeU.MEGABYTES);
        rateU = RateUnit.RateU.GBIT;
        expected = "5.0 megabytes per month is equivalent to 1.5220700152207E-8 Gbit/s";
        actual = BandWidthCalculator.HBConverter(sizeUnit, rateU);
        assertEquals(expected, actual);


        sizeUnit = new SizeUnit(534, SizeUnit.SizeU.TERABYTES);
        rateU = RateUnit.RateU.MBIT;
        expected = "534.0 terabytes per month is equivalent to 1625.5707762557076 Mbit/s";
        actual = BandWidthCalculator.HBConverter(sizeUnit, rateU);
        assertEquals(expected, actual);
    }

    @Test
    void DUTCalculator() {
        SizeUnit sizeUnit;
        RateUnit rateUnit;
        String expected;
        String actual;

        sizeUnit = new SizeUnit(345, SizeUnit.SizeU.BYTES);
        rateUnit = new RateUnit(6, RateUnit.RateU.GBIT);
        expected = "Download or upload time needed is: 0 days 0 hours 0 minutes 4.6E-7 seconds";
        actual = BandWidthCalculator.DUTCalculator(sizeUnit, rateUnit);
        assertEquals(expected, actual);


        sizeUnit = new SizeUnit(5, SizeUnit.SizeU.TERABYTES);
        rateUnit = new RateUnit(13, RateUnit.RateU.MBIT);
        expected = "Download or upload time needed is: 35 days 14 hours 42 minutes 3.076923076994717 seconds";
        actual = BandWidthCalculator.DUTCalculator(sizeUnit, rateUnit);
        assertEquals(expected, actual);


        sizeUnit = new SizeUnit(98, SizeUnit.SizeU.KILOBYTES);
        rateUnit = new RateUnit(13, RateUnit.RateU.KBIT);
        expected = "Download or upload time needed is: 0 days 0 hours 1 minutes 0.3076923076923066 seconds";
        actual = BandWidthCalculator.DUTCalculator(sizeUnit, rateUnit);
        assertEquals(expected, actual);
    }

    @Test
    void DUConverter() {
        SizeUnit sizeUnit;
        String expected;
        String actual;

        sizeUnit = new SizeUnit(434, SizeUnit.SizeU.KILOBITS);
        expected = "434.0 kilobits is equivalent to any of the following:\n" +
                "\t434000.0 bits\n" +
                "\t434.0 kilobits\n" +
                "\t0.434 megabits\n" +
                "\t4.34E-4 gigabits\n" +
                "\t4.34E-7 terabits\n" +
                "\t54250.0 Bytes\n" +
                "\t54.25 Kilobytes\n" +
                "\t0.05425 Megabytes\n" +
                "\t5.425E-5 Gigabytes\n" +
                "\t5.425E-8 Terabytes";
        actual = BandWidthCalculator.DUConverter(sizeUnit);
        assertEquals(expected, actual);


        sizeUnit = new SizeUnit(47, SizeUnit.SizeU.MEGABYTES);
        expected = "47.0 megabytes is equivalent to any of the following:\n" +
                "\t3.76E8 bits\n" +
                "\t376000.0 kilobits\n" +
                "\t376.0 megabits\n" +
                "\t0.376 gigabits\n" +
                "\t3.76E-4 terabits\n" +
                "\t4.7E7 Bytes\n" +
                "\t47000.0 Kilobytes\n" +
                "\t47.0 Megabytes\n" +
                "\t0.047 Gigabytes\n" +
                "\t4.7E-5 Terabytes";
        actual = BandWidthCalculator.DUConverter(sizeUnit);
        assertEquals(expected, actual);


        sizeUnit = new SizeUnit(79, SizeUnit.SizeU.GIGABYTES);
        expected = "79.0 gigabytes is equivalent to any of the following:\n" +
                "\t6.32E11 bits\n" +
                "\t6.32E8 kilobits\n" +
                "\t632000.0 megabits\n" +
                "\t632.0 gigabits\n" +
                "\t0.632 terabits\n" +
                "\t7.9E10 Bytes\n" +
                "\t7.9E7 Kilobytes\n" +
                "\t79000.0 Megabytes\n" +
                "\t79.0 Gigabytes\n" +
                "\t0.079 Terabytes";
        actual = BandWidthCalculator.DUConverter(sizeUnit);
        assertEquals(expected, actual);
    }
}