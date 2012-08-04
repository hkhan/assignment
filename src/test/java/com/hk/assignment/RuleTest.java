/**
 *
 */
package com.hk.assignment;
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
public class RuleTest {

    private Rule rule;

    private String result;

    private Processor processor;

    @Before
    public void setup() {
        processor = createMock(Processor.class);
    }

    @Test
    public void testRuleCreation() {
        rule = new Rule("1: one", processor);
        assertEquals("one", rule.getRuleText());
        assertEquals(1, rule.getBaseValue().intValue());
    }

    @Test
    public void testSimpleRuleApplication() {
        rule = new Rule("1: one", processor);
        result = rule.apply(1);
        assertEquals("one", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionApplied() {
        rule = new Rule("20: twenty<-%mod%>", processor);
        expect(processor.process(5)).andReturn("five");
        replay(processor);

        String result = rule.apply(25);

        verify(processor);
        assertEquals("twenty-five", result);
    }

    @Test
    public void testRuleWithModulusSubstitutionNotApplied() {
        rule = new Rule("20: twenty<-%mod%>", processor);
        String result = rule.apply(20);
        assertEquals("twenty", result);
    }
}