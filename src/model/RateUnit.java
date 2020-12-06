package model;

/**
 * Unit of data unit per second.
 */
public class RateUnit extends Unit {
    /**
     * contains factors for converting units
     */
    public enum RateU {
        BIT("bit/s", 1.0),
        KBIT("Kbit/s", 1_000.0),
        MBIT("Mbit/s", 1_000_000.0),
        GBIT("Gbit/s", 1_000_000_000.0),
        TBIT("Tbit/s", 1_000_000_000_000.0);

        private final String toString;
        private final double factor;

        RateU(String toString, double factor) {
            this.factor = factor;
            this.toString = toString;
        }

        public double getFactor() {
            return factor;
        }

        public String getToString() {
            return toString;
        }
    }

    private final RateU rateU;

    public RateUnit(double magnitude, RateU rateU) {
        super(magnitude);
        this.rateU = rateU;
    }

    /**
     * @return enum associated with unit
     */
    public RateU getRateU() {
        return this.rateU;
    }


    /**
     * @return formatted value of unit
     */
    @Override
    public String toString() {
        return getMagnitude() + " " + this.rateU.name().toLowerCase() + "/s";
    }


}