package com.hk.text.process;

/**
 * Calculate the quotient part and processes the new number.
 *
 * @author hkhan
 *
 */
public class QuotientSubstitution extends Substitution {

    static final String PLACEHOLDER = "<";

    public QuotientSubstitution(Integer divisor) {
        super(divisor);
    }

    @Override
    String substitute(Long number, String source, Processor processor) {
        long newNumber = number / getDivisor();
        String quotientText = processor.process(newNumber);
        return source.replaceAll("<", quotientText);
    }

}
