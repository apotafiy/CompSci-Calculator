package model;

/**
 * Unit of data.
 */
@SuppressWarnings("ALL")
public class SizeUnit extends Unit {
    /**
     * contains factors for converting frequency units
     */
    public enum SizeU {
        BITS(1.0),
        KILOBITS(1_000.0),
        MEGABITS(1_000_000.0),
        GIGABITS(1_000_000_000.0),
        TERABITS(1_000_000_000_000.0),
        BYTES(8.0),
        KILOBYTES(8_000.0),
        MEGABYTES(8_000_000.0),
        GIGABYTES(8_000_000_000.0),
        TERABYTES(8_000_000_000_000.0);
        private final double factor;

        SizeU(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    private final SizeU sizeU;

    public SizeUnit(double magnitude, SizeU sizeU) {
        super(magnitude);
        this.sizeU = sizeU;
    }
    /**
     * @return enum associated with unit
     */
    public SizeU getSizeU() {
        return this.sizeU;
    }

    /**
     * @return formatted value of unit
     */
    @Override
    public String toString() {
        return getMagnitude() + " " + this.sizeU.name().toLowerCase();
    }

}
