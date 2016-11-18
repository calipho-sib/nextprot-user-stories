package org.nextprot.stepdefs.utils;

import org.junit.Assert;
import org.junit.Test;

public class StepUtilsTest {

    @Test
    public void valueOfBooleanFromNotStringNotStatusShouldBeFalse() throws Exception {

        Assert.assertEquals(false, StepUtils.valueOfBooleanFromNotStatus("not"));
        Assert.assertEquals(false, StepUtils.valueOfBooleanFromNotStatus("  not  "));
    }

    @Test
    public void valueOfBooleanFromEmptyNotStatusShouldBeTrue() throws Exception {

        Assert.assertEquals(true, StepUtils.valueOfBooleanFromNotStatus(""));
    }

    @Test
    public void valueOfBooleanFromNullNotStatusShouldBeTrue() throws Exception {

        Assert.assertEquals(true, StepUtils.valueOfBooleanFromNotStatus(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfBooleanFromNotStatusShouldThrowExceptionIfUnknownString() throws Exception {

        StepUtils.valueOfBooleanFromNotStatus("false");
    }

    @Test
    public void propertiesShouldExist() throws Exception {

        Assert.assertNotNull(StepUtils.getProperty("api"));
        Assert.assertNotNull(StepUtils.getProperty("search"));
        Assert.assertNotNull(StepUtils.getProperty("snorql"));
        Assert.assertNotNull(StepUtils.getProperty("any"));
        Assert.assertNotNull(StepUtils.getProperty("ndu.email"));
        Assert.assertNotNull(StepUtils.getProperty("ndu.google.email"));
        Assert.assertNotNull(StepUtils.getProperty("ndu.email.password"));
        Assert.assertNotNull(StepUtils.getProperty("ndu.google.email.password"));
    }

    @Test
    public void passwordsShouldNotBeDefined() throws Exception {

        Assert.assertTrue(StepUtils.getProperty("ndu.google.email.password").isEmpty());
        Assert.assertTrue(StepUtils.getProperty("ndu.email.password").isEmpty());
    }
}