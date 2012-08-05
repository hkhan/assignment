package com.hk.text.process;

/**
 * Performs a modulus operation on the input in order to calculate that part of the substitution.
 *
 * @author hkhan
 *
 */
class RemainderSubstitution extends Substitution {

    static final String PLACEHOLDER = ">";
    private static final String TEXT_PLACEHOLDER_REGEX = "\\[|\\]";
    private static final String PLACEHOLDER_CONTENT_REGEX = "\\[.*\\]";

    public RemainderSubstitution(Integer divisor) {
        super(divisor);
    }

    @Override
    String substitute(Long number, String source, Processor processor) {
        String text = source;
        if (number % getDivisor() != 0) {
            long newNumber = number % getDivisor();
            String remainderText =  processor.process(newNumber);
            text = text.replaceAll(PLACEHOLDER, remainderText).replaceAll(TEXT_PLACEHOLDER_REGEX, "");
        } else {
            text = text.replaceAll(PLACEHOLDER_CONTENT_REGEX, "");
        }

        return text;
    }


}
