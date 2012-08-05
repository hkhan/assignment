package com.hk.text.process;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberRuleProcessorTest {

    private Processor processor;
    private Rule rule;

    @Before
    public void setup() {
        rule = new MockRule();
        processor = new NumberRuleProcessor(Arrays.asList(rule));
    }

    @Test
    public void testFinder() {
        assertEquals("hundred", processor.process(500));
    }

    private class MockRule implements Rule {

        @Override
        public String apply(long number, Processor processor) {
            return "hundred";
        }

        @Override
        public Long getBaseValue() {
            return 100L;
        }

        @Override
        public String getRuleText() {
            return null;
        }

    }

}
