/**
 *
 */
package com.hk.text.process;

import com.hk.text.validation.RuleDescriptionValidator;

/**
 * Helper class with a public static final field holding the default {@link Processor}.
 *
 * @author hkhan
 *
 */
public class ProcessorFactory {

    public static final Processor DEFAULT_RULE_PROCESSOR = getProcessor();

    private ProcessorFactory() {}

    private static Processor getProcessor() {
        RuleDescriptionValidator validator = new RuleDescriptionValidator();
        Loader ruleDescriptionLoader = new RuleDescriptionLoader(validator);
        return new NumberRuleProcessor(ruleDescriptionLoader.load());
    }

}
