package controller;

import model.HexNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexCalculatorTest {
    private HexNumber n1;
    private HexNumber n2;
    private String expected;
    private String actual;
    private final HexCalculator calc = new HexCalculator();

    @Test
    void convertToBase() {
        expected = "9";
        actual = calc.convertToBase(9);
        assertEquals(expected, actual);


        expected = "-b";
        actual = calc.convertToBase(-11);
        assertEquals(expected, actual);


        expected = "159";
        actual = calc.convertToBase(345);
        assertEquals(expected, actual);
    }

    @Test
    void convertToDec() {
        expected = "9";
        actual = calc.convertToDec("9");
        assertEquals(expected, actual);


        expected = "170";
        actual = calc.convertToDec("aa");
        assertEquals(expected, actual);


        expected = "21";
        actual = calc.convertToDec("15");
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        n1 = new HexNumber(234);
        n2 = new HexNumber(123);
        expected = 234 + 123 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(1);
        n2 = new HexNumber(1);
        expected = 1 + 1 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(-9);
        n2 = new HexNumber(3);
        expected = -9 + 3 + "";
        actual = calc.add(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }

    @Test
    void subtract() {
        n1 = new HexNumber(234);
        n2 = new HexNumber(123);
        expected = 234 - 123 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(1);
        n2 = new HexNumber(1);
        expected = 0 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(-9);
        n2 = new HexNumber(3);
        expected = -9 - 3 + "";
        actual = calc.subtract(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        n1 = new HexNumber(234);
        n2 = new HexNumber(123);
        expected = 234 * 123 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(1);
        n2 = new HexNumber(1);
        expected = 1 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(-9);
        n2 = new HexNumber(3);
        expected = -9 * 3 + "";
        actual = calc.multiply(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }

    @Test
    void divide() {
        n1 = new HexNumber(234);
        n2 = new HexNumber(123);
        expected = 234 / 123 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(1);
        n2 = new HexNumber(1);
        expected = 1 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);

        n1 = new HexNumber(-9);
        n2 = new HexNumber(3);
        expected = -9 / 3 + "";
        actual = calc.divide(n1, n2).getValue() + "";
        assertEquals(expected, actual);
    }
}