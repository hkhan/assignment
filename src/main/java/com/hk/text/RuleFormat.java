package com.hk.text;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

import com.hk.text.process.Processor;
import com.hk.text.process.ProcessorFactory;

public class RuleFormat extends NumberFormat {

    public static final long FORMAT_RANGE_MAX = 999999999;
    public static final int FORMAT_RANGE_MIN = 0;

    private static final long serialVersionUID = 1011890915447382714L;

    private Processor ruleProcessor;

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
