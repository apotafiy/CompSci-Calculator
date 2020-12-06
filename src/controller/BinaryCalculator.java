package controller;

import model.*;

import java.util.Stack;

/**
 * Calculate anything that is related to binary
 */
public class BinaryCalculator extends Calculator {
    @Override
    public String convertToBase(double value) {
        if (value == 0) return "0";
        if (value < 0) return "-" + convertToBase(value * -1);
        StringBuilder val = new StringBuilder();
        long num = (long) value;
        Stack<Long> stack = new Stack<>();
        while (num > 0) {
            long rem = num % 2;
            stack.push(rem);
            num /= 2;
        }
        while (!stack.isEmpty()) {
            val.append(stack.pop());
        }
        return val.toString();
    }

    @Override
    public String convertToDec(String s) {
        if (s.equals("0")) return s;
        if (s.startsWith("-")) return "-" + convertToDec(s.substring(1));
        int exponent = 0;
        int value = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                value += Math.pow(2, exponent);
            }else if(s.charAt(i)!='0'){
                return "ERROR: Must contain only 1 and 0.";
            }
            exponent++;
        }
        return value + "";
    }

    /**
     * @param n1 BinaryNumber
     * @param n2 BinaryNumber
     * @return BinaryNumber
     */
    @Override
    public Num add(Num n1, Num n2) {
        return new BinaryNumber(n1.getValue() + n2.getValue());
    }
    /**
     * @param n1 BinaryNumber
     * @param n2 BinaryNumber
     * @return BinaryNumber
     */
    @Override
    public Num subtract(Num n1, Num n2) {
        return new BinaryNumber(n1.getValue() - n2.getValue());
    }
    /**
     * @param n1 BinaryNumber
     * @param n2 BinaryNumber
     * @return BinaryNumber
     */
    @Override
    public Num multiply(Num n1, Num n2) {
        return new BinaryNumber(n1.getValue() * n2.getValue());
    }
    /**
     * @param n1 BinaryNumber
     * @param n2 BinaryNumber
     * @return BinaryNumber
     */
    @Override
    public Num divide(Num n1, Num n2) {
        return new BinaryNumber(n1.getValue() / n2.getValue());
    }
}
