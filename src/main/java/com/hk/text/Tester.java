package com.hk.text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {

    /**
     * Tester to demonstrate the formatting functionality.
     *
     * If there are no args supplied then random numbers are converted and displayed.
     * If args are supplied then they are converted and displayed accordingly.
     *
     * @param args
     */
    public static void main(String... args) {
        NumberFormat numberFormat = new RuleFormat();

        List<Long> testData = createTestData(args);

        for (long number: testData) {
            System.out.println(number + " : " + numberFormat.format(number));
        }
    }

    private static List<Long> createTestData(String... args) {
        List<Long> input = new ArrayList<Long>();

        if (args.length == 0) {
            input.add(Long.valueOf(new Random().nextInt(10)));
            input.add(Long.valueOf(new Random().nextInt(20)));
            input.add(Long.valueOf(new Random().nextInt(100)));
            input.add(Long.valueOf(new Random().nextInt(1000)));
            input.add(Long.valueOf(new Random().nextInt(10000)));
            input.add(Long.valueOf(new Random().nextInt(100000)));
            input.add(Long.valueOf(new Random().nextInt(1000000)));
            input.add(Long.valueOf(new Random().nextInt(10000000)));
            input.add(1L);
            input.add(21L);
            input.add(105L);
            input.add(56945781L);
        } else {
            for (String arg : args) {
                try {
                    Long.valueOf(arg);
                } catch (NumberFormatException nfe) {
                    System.err.println(String.format("Invalid number [%s]", arg));
                }
            }
        }

        return input;
    }

}
