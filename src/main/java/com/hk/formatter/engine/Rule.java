/**
 *
 */
package com.hk.formatter.engine;

/**
 * Generic rule which acts on the input to produce an output
 *
 * @author hkhan
 *
 * @param <I> - Input
 * @param <O> - Output
 */
public interface Rule<I, O> {

    O apply(I input);

}
