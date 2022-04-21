package com.kozlovskaya.algorithms.homework.lesson5;

public class ExponentApp {

    public static void main(String[] args) {
        System.out.println(exponentation(4.00, -1));
    }

    public static double exponentation(double n, double exponent) {
        if (exponent > 0)
            return n * exponentation(n, exponent - 1);

        if (exponent < 0)
            return 1 / n * exponentation(n, exponent + 1);

        return 1;
    }
}
