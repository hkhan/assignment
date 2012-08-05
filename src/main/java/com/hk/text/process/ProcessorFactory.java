/**
 *
 */
package com.hk.text.process;

import java.util.ArrayList;
import java.util.List;

import com.hk.text.validation.RuleDescriptionValidator;

/**
 * Helper class with a public static final field holding the default {@link Processor}
 * loaded with default rules.
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
        List<String> ruleDescriptions = ruleDescriptionLoader.load();

        return new NumberRuleProcessor(convertToRules(ruleDescriptions));
    }

    private static List<Rule> convertToRules(List<String> ruleDescriptions) {
        List<Rule> rules = new ArrayList<Rule>();
        for (String ruleDescription : ruleDescriptions) {
            rules.add(new NumberConversionRule(ruleDescription));
        }
        return rules;
    }

}
