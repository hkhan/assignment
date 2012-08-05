/**
 *
 */
package com.hk.text.process;

/**
 * Interface which defines a generic action which can be performed when processing a rule.
 *
 * @author hkhan
 *
 */
interface Action {

    /**
     *
     * @param input
     * @param result
     * @param processor
     * @return
     */
    String perform(Long input, String result, Processor processor);

}
