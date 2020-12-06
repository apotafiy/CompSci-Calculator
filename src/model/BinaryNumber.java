package model;

import controller.BinaryCalculator;

/**
 * Binary Numbers
 */
public class BinaryNumber extends Num {

    public BinaryNumber(long decimalValue) {
        super(decimalValue);
    }

    /**
     * @return decimal value converted to binary
     */
    public String toString() {
        BinaryCalculator b = new BinaryCalculator();
        return b.convertToBase(super.getValue());
    }
}
