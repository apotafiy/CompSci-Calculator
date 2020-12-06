package model;

/**
 * Unit of a value over time.
 */
public class FrequencyUnit extends Unit {
    /**
     * contains factors for converting frequency units
     */
    @SuppressWarnings("unused")
    public enum FrequencyU {
        SECOND(1.0),
        MINUTE(60.0),
        HOUR(3600.0),
        DAY(86400.0),
        WEEK(604800),
        MONTH(2.628e+6),
        YEAR(3.154e+7);
        private final double seconds;

        FrequencyU(double seconds) {
            this.seconds = seconds;
        }

        public double getSeconds() {
            return seconds;
        }
    }

    private final FrequencyU frequencyU;

    public FrequencyUnit(double magnitude, FrequencyU frequencyU) {
        super(magnitude);
        this.frequencyU = frequencyU;
    }

    /**
     * @return enum associated with unit
     */
    public FrequencyU getFrequencyU() {
        return this.frequencyU;
    }

    /**
     * @return formatted value of unit
     */
    @Override
    public String toString() {
        return getMagnitude() + " per " + this.frequencyU.name().toLowerCase();
    }
}
