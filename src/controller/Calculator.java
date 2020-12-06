package controller;


import model.*;

/**
 * Abstract class for calculators
 */

public abstract class Calculator implements Convertible {
    /**
     * @param n1 Num
     * @param n2 Num
     * @return Num
     */
    public abstract Num add(Num n1, Num n2);

    /**
     * @param n1 Num
     * @param n2 Num
     * @return Num
     */
    public abstract Num subtract(Num n1, Num n2);

    /**
     * @param n1 Num
     * @param n2 Num
     * @return Num
     */
    public abstract Num multiply(Num n1, Num n2);

    /**
     * @param n1 Num
     * @param n2 Num
     * @return Num
     */
    public abstract Num divide(Num n1, Num n2);
}