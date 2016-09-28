package org.nextprot;


public class StepUtils {

    public static boolean valueOfShouldBeStatus(String shouldStatus) {

        boolean shouldBe;

        if ("should".equalsIgnoreCase(shouldStatus)) {
            shouldBe = true;
        } else if ("should not".equalsIgnoreCase(shouldStatus)) {
            shouldBe = false;
        } else {
            throw new IllegalArgumentException(shouldStatus + ": bad argument format (take only values 'should' or 'should not')");
        }

        return shouldBe;
    }

}
