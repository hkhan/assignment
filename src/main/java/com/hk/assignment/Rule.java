/**
 *
 */
package com.hk.assignment;

/**
 * @author hkhan
 *
 */
public class Rule {

    private Integer baseValue;

    private String ruleText;

    public Rule(String description) {
        String[] splitDesc = description.split(":");
        ruleText = splitDesc[1].trim();
        baseValue = Integer.valueOf(splitDesc[0].trim());
    }

    public String getRuleText() {
        return ruleText;
    }

    public Integer getBaseValue() {
        return baseValue;
    }

}
