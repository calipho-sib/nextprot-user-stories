package org.nextprot.scenario.step_definition.utils;

import org.junit.Assert;
import org.junit.Test;

public class BooleanUtilsTest {

    @Test
    public void valueOfBooleanFromNotStringNotStatusShouldBeFalse() throws Exception {

        Assert.assertEquals(false, BooleanUtils.mapNotStringToBoolean("not"));
        Assert.assertEquals(false, BooleanUtils.mapNotStringToBoolean("  not  "));
    }

    @Test
    public void valueOfBooleanFromEmptyNotStatusShouldBeTrue() throws Exception {

        Assert.assertEquals(true, BooleanUtils.mapNotStringToBoolean(""));
    }

    @Test
    public void valueOfBooleanFromNullNotStatusShouldBeTrue() throws Exception {

        Assert.assertEquals(true, BooleanUtils.mapNotStringToBoolean(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfBooleanFromNotStatusShouldThrowExceptionIfUnknownString() throws Exception {

        BooleanUtils.mapNotStringToBoolean("false");
    }

    @Test
    public void valueOfFalseBoolean() throws Exception {

        Assert.assertEquals(false, BooleanUtils.mapStringToBoolean(" faux ", "faux"));
    }

    @Test
    public void valueOfTrueBoolean2() throws Exception {

        Assert.assertEquals(true, BooleanUtils.mapStringToBoolean("", "faux"));
    }
}