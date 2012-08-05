/**
 *
 */
package com.hk.text.process;
import org.junit.Before;
import org.junit.Test;

import com.hk.text.process.NumberConversionRule;
import com.hk.text.process.Processor;

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
        rule = new NumberConversionRule("1: one", processor);
        assertEquals("one", rule.getRuleText());
        assertEquals(1, rule.getBaseValue().intValue());
    }

    @Test
    public void testSimpleRuleApplication() {
        rule = new NumberConversionRule("1: one", processor);
        result = rule.apply(1);
        assertEquals("one", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionApplied() {
        rule = new NumberConversionRule("20: twenty[->]", processor);
        expect(processor.process(5)).andReturn("five");
        replay(processor);

        String result = rule.apply(25);

        verify(processor);
        assertEquals("twenty-five", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionNotApplied() {
        rule = new NumberConversionRule("20: twenty[->]", processor);
        String result = rule.apply(20);
        assertEquals("twenty", result);
    }

    @Test
    public void testRuleWithQuotientAndModulusSubstitutionApplied() {
        rule = new NumberConversionRule("100: < hundred[ and >]", processor);

        expect(processor.process(1)).andReturn("one");
        expect(processor.process(5)).andReturn("five");
        replay(processor);

        result = rule.apply(105);

        verify(processor);
        assertEquals("one hundred and five", result);
    }
}