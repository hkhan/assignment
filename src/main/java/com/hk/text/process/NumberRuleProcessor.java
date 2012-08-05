/**
 *
 */
package com.hk.text.process;

import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Concrete core component for processing the input and producing a text output
 * as a result of applying the matching rule(s). This should be created with a data structure
 * containing all the rules required for processing the input.
 * Internally, it will select the most appropriate rule with the highest base value less than
 * or equal to the provided input.
 *
 * The engine will use recursion and call the <code>process</code> method from the rule in order
 * to apply any further rules.
 *
 * @author hkhan
 *
 */
public class NumberRuleProcessor implements Processor {

    private final NavigableMap<Long, Rule> searchableRules = new TreeMap<Long, Rule>();

    /**
     * Inititializes with the rule descriptions.
     *
     * @param rules
     */
    public NumberRuleProcessor(List<Rule> rules) {
        for (Rule rule : rules) {
            searchableRules.put(rule.getBaseValue(), rule);
        }
    }

    @Override
    public String process(long number) {
        return findRule(number).apply(number, this);
    }

    private Rule findRule(long number) {
        return searchableRules.floorEntry(number).getValue();
    }

}
