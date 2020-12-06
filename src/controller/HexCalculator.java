package controller;

import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Calculate anything that is related to hexadecimal
 */
public class HexCalculator extends Calculator {
    /**
     * @param value decimal value
     * @return decimal value converted hex
     */
    @SuppressWarnings("DuplicatedCode")
    @Override
    public String convertToBase(double value) {
        if (value == 0) return "0";
        if (value < 0) return "-" + convertToBase(value * -1.0);

        List<Character> list = new ArrayList<>();
        {
            list.add('0');
            list.add('1');
            list.add('2');
            list.add('3');
            list.add('4');
            list.add('5');
            list.add('6');
            list.add('7');
            list.add('8');
            list.add('9');
            list.add('a');
            list.add('b');
            list.add('c');
            list.add('d');
            list.add('e');
            list.add('f');
        }
        long rem;
        long num = (long) value;
        StringBuilder hex = new StringBuilder();
        while (num > 0) {
            rem = num % 16;
            hex.insert(0, list.get((int) rem));
            num = num / 16;
        }
        return hex.toString();
    }

    /**
     * @param hex hex value
     * @return hex value converted to decimal
     */
    @Override
    public String convertToDec(String hex) {
        if (hex.equals("0")) return hex;
        if (hex.startsWith("-")) return "-" + convertToDec(hex.substring(1));
        hex = hex.toLowerCase();
        int[] intArr = new int[hex.length()];
        int i = 0;
        for (char c : hex.toCharArray()) {
            switch (c) {
                case '0': {
                    intArr[i] = 0;
                    break;
                }
                case '1': {
                    intArr[i] = 1;
                    break;
                }
                case '2': {
                    intArr[i] = 2;
                    break;
                }
                case '3': {
                    intArr[i] = 3;
                    break;
                }
                case '4': {
                    intArr[i] = 4;
                    break;
                }
                case '5': {
                    intArr[i] = 5;
                    break;
                }
                case '6': {
                    intArr[i] = 6;
                    break;
                }
                case '7': {
                    intArr[i] = 7;
                    break;
                }
                case '8': {
                    intArr[i] = 8;
                    break;
                }
                case '9': {
                    intArr[i] = 9;
                    break;
                }
                case 'a': {
                    intArr[i] = 10;
                    break;
                }
                case 'b': {
                    intArr[i] = 11;
                    break;
                }
                case 'c': {
                    intArr[i] = 12;
                    break;
                }
                case 'd': {
                    intArr[i] = 13;
                    break;
                }
                case 'e': {
                    intArr[i] = 14;
                    break;
                }
                case 'f': {
                    intArr[i] = 15;
                    break;
                }
                default:
                    return "~~Error: Invalid Input. Please Try Again.";
            }
            i++;
        }
        int exponent = intArr.length - 1;
        int value = 0;
        for (int num : intArr) {
            value += num * Math.pow(16, exponent);
            exponent--;
        }
        return value + "";
    }

    /**
     * @param n1 HexNumber
     * @param n2 HexNumber
     * @return HexNumber
     */
    @Override
    public Num add(Num n1, Num n2) {
        return new HexNumber(n1.getValue() + n2.getValue());
    }

    /**
     * @param n1 HexNumber
     * @param n2 HexNumber
     * @return HexNumber
     */
    @Override
    public Num subtract(Num n1, Num n2) {
        return new HexNumber(n1.getValue() - n2.getValue());
    }

    /**
     * @param n1 HexNumber
     * @param n2 HexNumber
     * @return HexNumber
     */
    @Override
    public Num multiply(Num n1, Num n2) {
        return new HexNumber(n1.getValue() * n2.getValue());
    }

    /**
     * @param n1 HexNumber
     * @param n2 HexNumber
     * @return HexNumber
     */
    @Override
    public Num divide(Num n1, Num n2) {
        return new HexNumber(n1.getValue() / n2.getValue());
    }


}
