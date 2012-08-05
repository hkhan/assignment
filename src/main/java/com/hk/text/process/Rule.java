/**
 *
 */
package com.hk.text.process;

/**
 * Generic rule which acts on the input to produce an output and exposes two key
 * properties which are the <code>baseValue</code> and the <code>ruleText</code>.
 *
 * @author hkhan
 *
 */
interface Rule {

    String apply(long number, Processor processor);

    Long getBaseValue();

    String getRuleText();

}
