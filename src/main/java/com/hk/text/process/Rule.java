/**
 *
 */
package com.hk.text.process;

/**
 * Generic rule which acts on the input to produce an output
 *
 * @author hkhan
 *
 */
interface Rule {

    String apply(long number);

    Long getBaseValue();

}
