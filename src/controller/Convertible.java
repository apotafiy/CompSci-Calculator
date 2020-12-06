package controller;

/**
 * Interface for implementing value conversions
 */

public interface Convertible {
    String convertToBase(double value);

    String convertToDec(String value);
}
