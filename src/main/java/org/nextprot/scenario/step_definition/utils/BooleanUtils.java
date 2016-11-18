package org.nextprot.scenario.step_definition.utils;


public class BooleanUtils {

    /**
     * Convert a not statement value into boolean
     * @param value the string value to convert in boolean
     * @return false if status equals "not" else true
     */
    public static boolean mapNotStringToBoolean(String value) {

        return mapStringToBoolean(value, "not");
    }

    /**
     * Convert a string value into boolean
     * @param value the value to convert in boolean
     * @param falseValue the false value string considered FALSE
     * @return false if status equals falseValue else true
     * @throws IllegalArgumentException if value is defined and is different of falseValue
     */
    public static boolean mapStringToBoolean(String value, String falseValue) {

        if (value == null || value.trim().isEmpty()) {
            return true;
        } else if (falseValue.equalsIgnoreCase(value.trim())) {
            return false;
        }

        throw new IllegalArgumentException(value + ": bad argument format (take only '' or '"+falseValue+"')");
    }
}
