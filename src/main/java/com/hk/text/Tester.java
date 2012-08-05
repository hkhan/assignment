package com.hk.text;

import java.text.NumberFormat;

public class Tester {

    public static void main(String... args) {
        NumberFormat numberFormat = new RuleFormat();
        long[] numbers = new long[] { 0, 1, 19, 20, 25, 99, 100, 109, 999, 1000, 10001,
                1234567, 123456789, 999999999, 1, 21, 105, 56945781 };

        for (long number: numbers) {
            System.out.println(number + " : " + numberFormat.format(number));
        }
    }

}
