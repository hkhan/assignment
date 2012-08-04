/**
 *
 */
package com.hk.formatter;

import java.util.NavigableMap;

import com.hk.formatter.engine.Processor;
import com.hk.formatter.engine.Rule;

/**
 * Concrete component for processing {@link Integer} input and producing a text output
 * as a result of applying the matching rule. This should be created with a data structure
 * containing all the rules required for processing the input, keyed by their base value.
 * Internally, it will select the most appropriate rule with the highest base value less than
 * or equal to the provided input.
 *
 * @author hkhan
 *
 */
public class NumberRuleProcessor implements Processor {

    private final NavigableMap<Integer, Rule<Integer, String>> rules;

    /**
     *
     * @param rules
     */
    public NumberRuleProcessor(NavigableMap<Integer, Rule<Integer, String>> rules) {
        this.rules = rules;
    }

    @Override
    public String process(Integer number) {
        return findRule(number).apply(number);
    }



    public Rule<Integer, String> findRule(Integer number) {
        return rules.floorEntry(number).getValue();
    }

}
