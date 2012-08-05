/**
 *
 */
package com.hk.text.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.hk.text.validation.Validator;

/**
 * Loads the individulal rules descriptions from the rules definition data from the default location.
 * Eagerly loads the definitions and from then on returns a read only copy of the rule descriptions.
 *
 * This can be easily extended to support a mechanism for loading from a provided source
 * of rule definitions
 *
 * @author hkhan
 *
 */
class RuleDescriptionLoader implements Loader {

    private static final String DEFAULT_RULES_DEFINITION = "/rules.txt";

    private static final Logger LOGGER = Logger.getLogger(RuleDescriptionLoader.class.getName());

    private Validator<String> validator;

    private List<String> ruleDescriptions = new ArrayList<String>();

    public RuleDescriptionLoader(Validator<String> validator) {
        this.validator = validator;

        loadDefault();
    }

    /**
     * Provides a read-only copy of the rule descriptions after they have been loaded from
     * the default location or the provided rule definition.
     *
     * @return a read-only copy of the rule descriptions
     */
    @Override
    public final List<String> load() {
        return Collections.unmodifiableList(ruleDescriptions);
    }

    private void loadDefault() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(DEFAULT_RULES_DEFINITION));
        try {
            while (scanner.hasNextLine()) {
                processRuleDescription(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
    }

    private void processRuleDescription(String ruleDescription) {
        if (validator.valid(ruleDescription)) {
            ruleDescriptions.add(ruleDescription);
        } else {
            LOGGER.severe(String.format("Unable to process rule: %s", ruleDescription));
        }
    }
}
