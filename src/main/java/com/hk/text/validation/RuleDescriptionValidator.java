package com.hk.text.validation;

import java.util.regex.Pattern;

import com.hk.text.RuleFormat;

/**
 * Responsible for validation of the rule syntax which can be supplied with custom matching
 * patterns and should be used to apply any other validation logic on a single rule description.
 *
 * @author hkhan
 *
 */
public class RuleDescriptionValidator implements Validator<String> {

    /**
     * Pattern which conforms to the rule specification as specified in {@link RuleFormat}
     */
    private static final String RULE_FORMAT_PATTERN = "\\d+:\\s<?(\\w+|\\s\\w+)(\\s?>|(\\[.*>\\])?)";

    private Pattern validationPattern;

    public RuleDescriptionValidator() {
        validationPattern = Pattern.compile(RULE_FORMAT_PATTERN);
    }

    public RuleDescriptionValidator(String regex) {
        validationPattern = Pattern.compile(regex);
    }

    @Override
    public boolean valid(String ruleDescription) {
        return validationPattern.matcher(ruleDescription).matches();
    }

}
