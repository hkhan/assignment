package com.hk.text;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

import com.hk.text.process.Processor;
import com.hk.text.process.ProcessorFactory;

/**
 * This is a concrete subclass of {@link NumberFormat} that formats numbers in the specified range according
 * to a set of rules defined in resources which are described as follows:<br><br>
 * <b><i>Rule Definition</i></b>: Collection of rules which make up the whole rule set<br>
 * <b><i>Rule Descriptions</i></b>: Individual rule description which must adhere to the specified format,
 * declared one rule per line.
 *
 * Each rule must include a base value (which determines the divisor used for rule application behaviour)
 * as well as the text which is used in case of a rule match.<br><br>
 *
 * The two types of optional substitutions allowed in a rule are a <b>quotient substitution</b>, denoted by
 * "<" and a <b>remainder substitution</b>, denoted by ">" in the rule description. The latter substition
 * provides additional option to include extra rule text which is applied in case of remainder being not 0.
 * This is optional text is indicated by matching pair of "[" and "]".
 *
 * The rule processing engine uses recursion to repeatedly apply the rules to each part of the number as it
 * is processed by the rule.<br><br>
 *
 * The rules are loaded from <code>rules.txt</code> resource on the classpath. This can be used to supply custom
 * rules in order to format the output accordingly.<br><br>
 *
 * Example rules:<blockquote>
 * <code>0: zero</code> (basic rule with no substitutions required)<br>
 * <code>20: twenty[->]</code> (rule with optional hyphen in the rule text, applied if the remainder
 * substitution is applied)<br>
 * <code>100: < thousand ></code> (rule with quotient and remainder substitutions)
 *
 * @author hkhan
 *
 */
public class RuleFormat extends NumberFormat {

    public static final int FORMAT_RANGE_MAX = 999999999;
    public static final int FORMAT_RANGE_MIN = 0;

    private static final long serialVersionUID = 1011890915447382714L;

    private transient Processor ruleProcessor;

    public RuleFormat() {
        ruleProcessor = ProcessorFactory.DEFAULT_RULE_PROCESSOR;
    }

    public RuleFormat(Processor processor) {
        this.ruleProcessor = processor;
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    /**
     * @throws IllegalArgumentException if the input number is not in the range specified by this formatter
     */
    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        checkArgs(number);

        return toAppendTo.append(ruleProcessor.process(number));
    }

    private void checkArgs(long number) {
        if (number < FORMAT_RANGE_MIN || number > FORMAT_RANGE_MAX) {
            throw new IllegalArgumentException(String.format("ERROR: the input is not valid: %s", number));
        }
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("Operation not supported");
    }

}
