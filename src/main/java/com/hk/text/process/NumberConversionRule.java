/**
 *
 */
package com.hk.text.process;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for parsing the rule description and setting up the rule
 * to convert the number to text.
 *
 * @author hkhan
 *
 */
class NumberConversionRule implements Rule {

    private Long baseValue;

    private String ruleText;

    private List<Action> actions;

    private int divisor;

    NumberConversionRule(String description) {
        String[] splitDesc = description.split(":");
        ruleText = splitDesc[1].trim();
        baseValue = Long.valueOf(splitDesc[0].trim());
        calculateDivisor();

        setupRuleActions();
    }

    private void setupRuleActions() {
        actions = new ArrayList<Action>();
        actions.add(new QuotientSubstitution(divisor));
        actions.add(new RemainderSubstitution(divisor));
    }

    @Override
    public String apply(long number, Processor processor) {
        String text = ruleText;

        for (Action action : actions) {
            text = action.perform(number, text, processor);
        }

        return text;
    }

    private void calculateDivisor() {
        if (baseValue < 100) {
            divisor =  10;
        } else if (baseValue < 1000) {
            divisor = 100;
        } else if (baseValue < 1000000) {
            divisor = 1000;
        } else {
            divisor = 1000000;
        }
    }

    @Override
    public String getRuleText() {
        return ruleText;
    }

    @Override
    public Long getBaseValue() {
        return baseValue;
    }
}
