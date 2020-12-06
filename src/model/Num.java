package model;

/**
 * Generic Number class
 */
public abstract class Num {
    private final long decimalValue;

    public Num(long decimalValue) {
        this.decimalValue = decimalValue;
    }

    /**
     * @return decimal value
     */
    public long getValue() {
        return decimalValue;
    }

    /**
     * @return decimal converted to desired base
     */
    public abstract String toString();
}
