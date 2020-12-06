package controller;

import model.*;

/**
 * Contained all bandwidth calculators
 */
public class BandWidthCalculator {

    /**
     * Website Bandwidth Calculator
     *
     * @param freq       the frequency of page views
     * @param size       size of page
     * @param redundancy redundancy factor
     * @return required bandwidth
     */
    public static String WBCalculator(FrequencyUnit freq, SizeUnit size, int redundancy) {
        double secViews = freq.getMagnitude() / freq.getFrequencyU().getSeconds();
        double pageBits = sizeUnitToBits(size);

        double bitSec = secViews * pageBits;

        double mBitSec = bitSec / 1_000_000.0;

        double gBitSec = mBitSec / 1_000.0;
        double gByteSec = gBitSec / 8.0;

        double gigPerMonth = gByteSec * FrequencyUnit.FrequencyU.MONTH.getSeconds();

        String withRedundant = redundancy == 1 ? "" :
                "\nWith redundancy factor of " + redundancy + ", the bandwidth needed is "
                        + mBitSec * redundancy + " Mbits/s " +
                        "or " + gigPerMonth * redundancy + " GB per month.";

        return "Bandwidth needed is " + mBitSec + " Mbits/s" + " or " + gigPerMonth + " GB per month." + withRedundant;
    }


    /**
     * Hosting Bandwidth Calculator
     *
     * @param data      how much data is needed
     * @param bandwidth what kind of bandwidth is needed
     * @return how much bandwidth is needed
     */
    public static String HBConverter(SizeUnit data, RateUnit.RateU bandwidth) {
        double monthlyBits = sizeUnitToBits(data);
        double bitPerSec = monthlyBits / FrequencyUnit.FrequencyU.MONTH.getSeconds();
        RateUnit rate = new RateUnit(bitPerSec / bandwidth.getFactor(), bandwidth);


        return data.toString() + " per month is equivalent to " + rate.getMagnitude() +
                " " + bandwidth.getToString();

    }

    /**
     * Download/Upload Time Calculator
     *
     * @param sizeUnit size of file
     * @param rateUnit bandwidth
     * @return time it takes to download/upload file
     */
    public static String DUTCalculator(SizeUnit sizeUnit, RateUnit rateUnit) {
        double bitMagnitude = sizeUnitToBits(sizeUnit);
        double seconds = bitMagnitude / (rateUnit.getMagnitude() * rateUnit.getRateU().getFactor());


        int days = (int) (seconds / 86400.0);
        seconds %= 86400;
        int hours = (int) (seconds / 3600.0);
        seconds %= 3600;
        int minutes = (int) (seconds / 60.0);
        seconds %= 60;
        return "Download or upload time needed is: " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " " +
                "seconds";


    }


    /**
     * Data Unit Converter
     *
     * @param data data unit
     * @return conversion of data units to all data unit types
     */
    public static String DUConverter(SizeUnit data) {
        double kiloBits = sizeUnitToBits(data) / 1000.0;
        double megaBits = kiloBits / 1000.0;
        double gigaBits = megaBits / 1000.0;
        double teraBits = gigaBits / 1000.0;
        double bytes = sizeUnitToBits(data) / 8.0;
        double kiloBytes = bytes / 1000.0;
        double megaBytes = kiloBytes / 1000.0;
        double gigaBytes = megaBytes / 1000.0;
        double teraBytes = gigaBytes / 1000.0;
        String returnString =
                "\t" + sizeUnitToBits(data) + " bits" + "\n\t" + kiloBits + " kilobits" + "\n\t" + megaBits + " megabits" +
                        "\n\t" +
                        gigaBits + " gigabits" + "\n\t" + teraBits + " terabits" + "\n\t" +
                        bytes + " Bytes" +
                        "\n\t" + kiloBytes + " Kilobytes" + "\n\t" + megaBytes + " Megabytes" + "\n\t"
                        + gigaBytes + " Gigabytes" + "\n\t" + teraBytes + " Terabytes";
        return data.getMagnitude() + " " + data.getSizeU().name().toLowerCase() + " is equivalent to any of the following:\n" + returnString;


    }


    /**
     * @param data unit of data
     * @return data converted to bits
     */
    private static double sizeUnitToBits(SizeUnit data) {
        double bitMagnitude = data.getMagnitude();

        switch (data.getSizeU()) {
            case BITS: {
                bitMagnitude *= 1.0;
                break;
            }
            case KILOBITS: {
                bitMagnitude *= 1_000.0;
                break;
            }
            case MEGABITS: {
                bitMagnitude *= 1_000_000.0;
                break;
            }
            case GIGABITS: {
                bitMagnitude *= 1_000_000_000.0;
                break;
            }
            case TERABITS: {
                bitMagnitude *= 1_000_000_000_000.0;
                break;
            }
            case BYTES: {
                bitMagnitude *= 8.0;
                break;
            }
            case KILOBYTES: {
                bitMagnitude *= 8_000.0;
                break;
            }
            case MEGABYTES: {
                bitMagnitude *= 8_000_000.0;
                break;
            }
            case GIGABYTES: {
                bitMagnitude *= 8_000_000_000.0;
                break;
            }
            case TERABYTES: {
                bitMagnitude *= 8_000_000_000_000.0;
                break;
            }
            default: {
                return -1;
            }
        }
        return bitMagnitude;
    }

}
