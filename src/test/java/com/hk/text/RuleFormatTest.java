package com.hk.text;

import org.junit.Before;
import org.junit.Test;

import com.hk.text.process.Processor;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

public class RuleFormatTest {

    private RuleFormat ruleFormat;
    private Processor processor;

    @Before
    public void setUp() {
        processor = createMock(Processor.class);
        ruleFormat = new RuleFormat(processor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputLowerThanMin() {
        ruleFormat.format(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputHigherThanMax() {
        ruleFormat.format(9999999999L);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDoubleFormatNotSupported() {
        ruleFormat.format(9.99);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testParseNotSupported() throws Exception {
        ruleFormat.parse("test");
    }

    @Test
    public void testFormat() {
        expect(processor.process(10)).andReturn("ten");
        replay(processor);

        String result = ruleFormat.format(10);

        verify(processor);
        assertEquals("incorrect formatted value", "ten", result);

    }
}
