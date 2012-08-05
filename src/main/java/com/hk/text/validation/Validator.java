/**
 *
 */
package com.hk.text.validation;

/**
 * @author hkhan
 *
 */
public interface Validator<T> {

    /**
     * Validate the specified input according to the specified criteria.
     *
     * @param input for validation
     * @return true if valid.
     */
    boolean valid(T input);
}
