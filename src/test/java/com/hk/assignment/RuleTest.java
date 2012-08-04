/**
 *
 */
package com.hk.assignment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author hkhan
 *
 */
public class RuleTest {

    private Rule rule;

    @Test
    public void testParsing() {
        rule = new Rule("1: one");
        assertEquals("one", rule.getRuleText());
        assertEquals(1, rule.getRuleText());
    }

}
