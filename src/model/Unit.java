package model;

/**
 * Generic Unit.
 */
public abstract class Unit {
    private final double magnitude;

    public Unit(double magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * @return decimal value
     */
    public double getMagnitude() {
        return this.magnitude;
    }

    /**
     * @return string conversion to base
     */
    public abstract String toString();
}
