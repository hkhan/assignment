/**
 *
 */
package com.hk.assignment;

/**
 * @author hkhan
 *
 */
class Rule {

    private Integer baseValue;

    private String ruleText;

    private Processor processor;

    public Rule(String description, Processor processor) {
        String[] splitDesc = description.split(":");
        ruleText = splitDesc[1].trim();
        baseValue = Integer.valueOf(splitDesc[0].trim());
        this.processor = processor;
    }

    String apply(Integer number) {

        String text = null;

        if (ruleText.contains("%mod%")) {
            if (number % getDivisor() != 0) {
                Integer newNumber = number % getDivisor();
                String modText = processor.process(newNumber);
                text = ruleText.replaceAll("%mod%", modText).replaceAll("<|>", "");
            } else {
                text = ruleText.replaceAll("<-%mod%>", "");
            }
        } else {
            text = ruleText;
        }

        return text;
    }

    private Integer getDivisor() {

        int divisor = 0;

        if (baseValue <= 100) {
            divisor =  10;
        } else if (baseValue <= 1000) {
            divisor = 100;
        } else if (baseValue <= 1000000) {
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
