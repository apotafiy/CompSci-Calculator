package model;

import controller.HexCalculator;

/**
 * Hexadecimal Numbers
 */
public class HexNumber extends Num {

    public HexNumber(long decimalValue) {
        super(decimalValue);
    }

    /**
     * @return decimal value converted to hex
     */
    public String toString() {
        HexCalculator h = new HexCalculator();
        return h.convertToBase(super.getValue());
    }
}