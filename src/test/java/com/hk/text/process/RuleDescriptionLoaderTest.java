package com.hk.text.process;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hk.text.process.RuleDescriptionLoader;
import com.hk.text.validation.Validator;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

public class RuleDescriptionLoaderTest {

    private RuleDescriptionLoader ruleDescriptionLoader;
    private Validator<String> validator;
    private List<String> result;

    @Before
    public void setUp() throws Exception {
        validator = createMock(Validator.class);
        expect(validator.valid(anyObject(String.class))).andReturn(true).times(1);
        expect(validator.valid(anyObject(String.class))).andReturn(false).times(1);
        replay(validator);

        ruleDescriptionLoader = new RuleDescriptionLoader(validator);
    }

    @Test
    public void testLoadingFromDefault() {
        result = ruleDescriptionLoader.load();

        verify(validator);
        assertEquals("size should be one for the one valid rule description", 1, result.size());
    }

}
