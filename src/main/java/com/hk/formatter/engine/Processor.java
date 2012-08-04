/**
 *
 */
package com.hk.formatter.engine;


/**
 * This is the component responsible for finding the appropriate {@link Rule} to apply based on
 * the specified input.
 *
 * @author hkhan
 *
 */
public interface Processor {

    String process(Integer number);

}
