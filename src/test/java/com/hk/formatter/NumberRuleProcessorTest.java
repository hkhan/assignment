package com.hk.formatter;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.junit.Test;

import com.hk.formatter.engine.Processor;
import com.hk.formatter.engine.Rule;

import static org.junit.Assert.assertEquals;

public class NumberRuleProcessorTest {

    private Processor processor;

    @Test
    public void testFinder() {
        NavigableMap<Integer, Rule<Integer, String>> rules = new TreeMap<Integer, Rule<Integer, String>>();

        processor = new NumberRuleProcessor(rules);

        rules.put(20, new MockRule(20));
        rules.put(100, new MockRule(100));
        rules.put(1000, new MockRule(1000));
        rules.put(1, new MockRule(1));

        assertEquals("1000", processor.process(2000));
        assertEquals("100", processor.process(999));
        assertEquals("1", processor.process(1));
    }

    private class MockRule implements Rule<Integer, String> {

        private Integer number;

        MockRule(Integer number) {
            this.number = number;
        }
        @Override
        public String apply(Integer input) {
            return number.toString();
        }

    }

}
