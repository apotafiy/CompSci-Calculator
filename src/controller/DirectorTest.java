package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    @Test
    void interpreter() {
        String expected;
        String actual;
        String command;

        command = "convert binary to decimal 1001";
        expected = "9";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "convert decimal to binary 9";
        expected = "1001";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "convert hexadecimal to decimal aa";
        expected = "170";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "convert decimal to hexadecimal 170";
        expected = "aa";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "convert data unit to bytes 123";
        expected = "123.0 bytes is equivalent to any of the following:\n" +
                "\t984.0 bits\n" +
                "\t0.984 kilobits\n" +
                "\t9.84E-4 megabits\n" +
                "\t9.84E-7 gigabits\n" +
                "\t9.840000000000001E-10 terabits\n" +
                "\t123.0 Bytes\n" +
                "\t0.123 Kilobytes\n" +
                "\t1.23E-4 Megabytes\n" +
                "\t1.23E-7 Gigabytes\n" +
                "\t1.2300000000000001E-10 Terabytes";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "Calculate Download/Upload Time 12 Bytes 6 bit/s";
        expected = "Download or upload time needed is: 0 days 0 hours 0 minutes 16.0 seconds";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "Calculate Website Bandwidth 5 per hour 16 Bytes 4";
        expected = "Bandwidth needed is 1.777777777777778E-7 Mbits/s or 5.840000000000001E-5 GB per month.\n" +
                "With redundancy factor of 4, the bandwidth needed is 7.111111111111112E-7 Mbits/s or 2.3360000000000004E-4 GB per month.";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);

        command = "Convert Monthly Usage to Bandwidth 11 Bytes bit/s";
        expected = "11.0 bytes per month is equivalent to 3.3485540334855407E-5 bit/s";
        actual = Director.interpreter(command);
        assertEquals(expected, actual);
    }
}