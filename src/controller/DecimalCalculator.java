package controller;

import model.*;

/**
 * Calculate everything related to decimal numbers
 */
public class DecimalCalculator extends Calculator {

    /**
     * @param value decimal value
     * @return decimal value converted to desired base
     */
    @Override
    public String convertToBase(double value) {
        return value + "";
    }

    /**
     * @param value decimal value
     * @return value decimal value but string
     */
    @Override
    public String convertToDec(String value) {
        return value;
    }

    /**
     * @param n1 DecimalNumber
     * @param n2 DecimalNumber
     * @return DecimalNumber
     */
    @Override
    public Num add(Num n1, Num n2) {
        return new DecimalNumber(n1.getValue() + n2.getValue());
    }

    /**
     * @param n1 DecimalNumber
     * @param n2 DecimalNumber
     * @return DecimalNumber
     */
    @Override
    public Num subtract(Num n1, Num n2) {
        return new DecimalNumber(n1.getValue() - n2.getValue());
    }

    /**
     * @param n1 DecimalNumber
     * @param n2 DecimalNumber
     * @return DecimalNumber
     */
    @Override
    public Num multiply(Num n1, Num n2) {
        return new DecimalNumber(n1.getValue() * n2.getValue());
    }

    /**
     * @param n1 DecimalNumber
     * @param n2 DecimalNumber
     * @return DecimalNumber
     */
    @Override
    public Num divide(Num n1, Num n2) {
        return new DecimalNumber(n1.getValue() / n2.getValue());
    }
}
