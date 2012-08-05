package com.hk.text.process;

/**
 * A NOP substitution which allows for a cleaner way to process text which does
 * not need to be altered.
 *
 * @author hkhan
 *
 */
public class NopSubstitution extends Substitution {

    public NopSubstitution(Integer divisor) {
        super(divisor);
    }

    @Override
    String substitute(Long number, String source, Processor processor) {
        return source;
    }

}
