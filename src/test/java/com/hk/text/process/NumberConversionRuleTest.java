/**
 *
 */
package com.hk.text.process;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

/**
 * @author hkhan
 *
 */
public class NumberConversionRuleTest {

    private NumberConversionRule rule;

    private String result;

    private Processor processor;

    @Before
    public void setup() {
        processor = createMock(Processor.class);
    }

    @Test
    public void testRuleCreation() {
        rule = new NumberConversionRule("1: one");
        assertEquals("one", rule.getRuleText());
        assertEquals(1, rule.getBaseValue().intValue());
    }

    @Test
    public void testSimpleRuleApplication() {
        rule = new NumberConversionRule("1: one");
        result = rule.apply(1, processor);
        assertEquals("one", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionApplied() {
        rule = new NumberConversionRule("20: twenty[->]");
        expect(processor.process(5)).andReturn("five");
        replay(processor);

        String result = rule.apply(25, processor);

        verify(processor);
        assertEquals("twenty-five", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionNotApplied() {
        rule = new NumberConversionRule("20: twenty[->]");
        String result = rule.apply(20, processor);
        assertEquals("twenty", result);
    }

    @Test
    public void testRuleWithQuotientAndModulusSubstitutionApplied() {
        rule = new NumberConversionRule("100: < hundred[ and >]");

        expect(processor.process(1)).andReturn("one");
        expect(processor.process(5)).andReturn("five");
        replay(processor);

        result = rule.apply(105, processor);

        verify(processor);
        assertEquals("one hundred and five", result);
    }

    @Test
    public void testRuleWithHighBaseValue() {
        rule = new NumberConversionRule("1000: < thousand[ >]");

        expect(processor.process(1)).andReturn("one");
        replay(processor);

        result = rule.apply(1000, processor);

        verify(processor);
        assertEquals("one thousand", result);
    }

    @Test
    public void testRuleWithHighestBaseValue() {
        rule = new NumberConversionRule("1000000: < million[ >]");

        expect(processor.process(1)).andReturn("one");
        replay(processor);

        result = rule.apply(1000000, processor);

        verify(processor);
        assertEquals("one million", result);
    }
}