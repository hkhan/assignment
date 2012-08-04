/**
 *
 */
package com.hk.formatter;

import com.hk.formatter.engine.Processor;
import com.hk.formatter.engine.Rule;

/**
 * This class is responsible for parsing the rule description and setting up the rule
 * to convert the number to text.
 *
 * @author hkhan
 *
 */
class NumberConversionRule implements Rule<Integer, String> {

    private Integer baseValue;

    private String ruleText;

    private Processor processor;

    public NumberConversionRule(String description, Processor processor) {
        String[] splitDesc = description.split(":");
        ruleText = splitDesc[1].trim();
        baseValue = Integer.valueOf(splitDesc[0].trim());
        this.processor = processor;
    }

    @Override
    public String apply(Integer number) {

        String text = ruleText;

        if (text.contains("%quo%")) {
            Integer newNumber = number / getDivisor();
            String quoText = processor.process(newNumber);
            text = text.replaceAll("%quo%", quoText).replaceFirst("<", "").replaceFirst(">", "");
        }

        if (text.contains("%mod%") && (number % getDivisor() != 0)) {
            Integer newNumber = number % getDivisor();
            String modText = processor.process(newNumber);
            text = text.replaceAll("%mod%", modText).replaceFirst("<", "").replaceFirst(">", "");
        }

        return text.replaceAll("<.*>", "");

    }

    private Integer getDivisor() {

        int divisor = 0;

        if (baseValue < 100) {
            divisor =  10;
        } else if (baseValue < 1000) {
            divisor = 100;
        } else if (baseValue < 1000000) {
            divisor = 1000;
        } else {
            divisor = 1000000;
        }

        return divisor;
    }

    public String getRuleText() {
        return ruleText;
    }

    public Integer getBaseValue() {
        return baseValue;
    }

}
