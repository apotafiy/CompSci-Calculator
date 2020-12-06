package controller;

import model.BinaryNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculatorTest {
    private BinaryNumber n1;
    private BinaryNumber n2;
    private String expected;
    private String actual;
    private final BinaryCalculator calc = new BinaryCalculator();

    @Test
    void convertToBase() {
        expected = "1001";
        actual = calc.convertToBase(9);
        assertEquals(expected, actual);


        expected = "-1011";
        actual = calc.convertToBase(-11);
        assertEquals(expected, actual);


        expected = "101011001";
        actual = calc.convertToBase(345);
        assertEquals(expected, actual);
    }

    @Test
    void convertToDec() {
        expected = "9";
        actual = calc.convertToDec("1001");
        assertEquals(expected, actual);


        expected = "170";
        actual = calc.convertToDec("10101010");
        assertEquals(expected, actual);


        expected = "21";
        actual = calc.convertToDec("10101");
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        n1 = new BinaryNumber(234);
        n2 = new BinaryNumber(123);
        expected = 234 + 123 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(1);
        n2 = new BinaryNumber(1);
        expected = 1 + 1 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(-9);
        n2 = new BinaryNumber(3);
        expected = -9 + 3 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);

    }

    @Test
    void subtract() {
        n1 = new BinaryNumber(234);
        n2 = new BinaryNumber(123);
        expected = 234 - 123 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(1);
        n2 = new BinaryNumber(1);
        expected = 0 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(-9);
        n2 = new BinaryNumber(3);
        expected = -9 - 3 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        n1 = new BinaryNumber(234);
        n2 = new BinaryNumber(123);
        expected = 234 * 123 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(1);
        n2 = new BinaryNumber(1);
        expected = 1 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(-9);
        n2 = new BinaryNumber(3);
        expected = -9 * 3 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        n1 = new BinaryNumber(234);
        n2 = new BinaryNumber(123);
        expected = 234 / 123 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(1);
        n2 = new BinaryNumber(1);
        expected = 1 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new BinaryNumber(-9);
        n2 = new BinaryNumber(3);
        expected = -9 / 3 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }
}