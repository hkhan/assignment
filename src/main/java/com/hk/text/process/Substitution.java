/**
 *
 */
package com.hk.text.process;

/**
 * @author hkhan
 *
 */
abstract class Substitution implements Action {

    private Integer divisor;

    public Substitution(Integer divisor) {
        this.divisor = divisor;
    }

    Integer getDivisor() {
        return divisor;
    }

    @Override
    public String perform(Long number, String source, Processor processor) {
        if (source.contains(getPlaceholder())) {
            source = substitute(number, source, processor);
        }

        return source;
    }

    abstract String substitute(Long number, String source, Processor processor);

    abstract String getPlaceholder();
}
