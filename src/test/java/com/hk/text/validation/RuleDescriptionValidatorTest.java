package com.hk.text.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleDescriptionValidatorTest {

    private Validator<String> validator;

    @Before
    public void setUp() throws Exception {
        validator = new RuleDescriptionValidator();
    }

    @Test
    public void testValidDefaultRules() {
        assertTrue("rule should be valid", validator.valid("1: one"));
        assertTrue("rule should be valid", validator.valid("20: twenty[->]"));
        assertTrue("rule should be valid", validator.valid("100: < hundred[ and >]"));
        assertTrue("rule should be valid", validator.valid("1000: < thousand >"));
        assertTrue("rule should be valid", validator.valid("1000000: < million[ >]"));
    }

    @Test
    public void testInvalidDefaultRules() {
        assertFalse("rule should be invalid", validator.valid("1: <<one"));
        assertFalse("rule should be invalid", validator.valid("20: twenty>[->]"));
    }

    @Test
    public void testValidCustomPatternValidation() {
        validator = new RuleDescriptionValidator("a");
        assertTrue("rule should be valid", validator.valid("a"));
    }

    @Test
    public void testInvalidCustomPatternValidation() {
        validator = new RuleDescriptionValidator("a");
        assertFalse("rule should be invalid", validator.valid("b"));
    }

}
