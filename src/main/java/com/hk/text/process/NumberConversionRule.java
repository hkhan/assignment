/**
 *
 */
package com.hk.text.process;



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

    private Processor processor;

    public NumberConversionRule(String description, Processor processor) {
        String[] splitDesc = description.split(":");
        ruleText = splitDesc[1].trim();
        baseValue = Long.valueOf(splitDesc[0].trim());
        this.processor = processor;
    }

    @Override
    public String apply(long number) {
        String text = ruleText;

        if (text.contains("<")) {
            long newNumber = number / getDivisor();
            String quotientText = processor.process(newNumber);
            text = text.replaceAll("<", quotientText);
        }

        if (text.contains(">")) {
            if (number % getDivisor() != 0) {
                long newNumber = number % getDivisor();
                String remainderText = processor.process(newNumber);
                text = text.replaceAll(">", remainderText).replaceAll("\\[|\\]", "");
            } else {
                text = text.replaceAll("\\[.*\\]", "");
            }
        }

        return text;
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

    @Override
    public Long getBaseValue() {
        return baseValue;
    }
}
