/**
 *
 */
package com.hk.text.process;

import java.util.List;

/**
 * @author hkhan
 *
 */
interface Loader {

    /**
     * Load the resource into a list of sparate item which can then be processed individually.
     *
     * @return
     */
    public List<String> load();

}
