package com.hk.text;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

import com.hk.text.process.Processor;
import com.hk.text.process.ProcessorFactory;

public class RuleFormat extends NumberFormat {

    private static final long serialVersionUID = 1011890915447382714L;

    private Processor ruleProcessor;

    public RuleFormat() {
        ruleProcessor = ProcessorFactory.DEFAULT_RULE_PROCESSOR;
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        return toAppendTo.append(ruleProcessor.process(number));
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("Operation not supported");
    }

}
