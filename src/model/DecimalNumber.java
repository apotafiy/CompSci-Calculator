package model;

/**
 * Decimal Numbers
 */
public class DecimalNumber extends Num {
    public DecimalNumber(long decimalValue) {
        super(decimalValue);
    }

    /**
     * @return decimal value toString
     */
    public String toString() {
        return super.getValue()+"";
    }
}
