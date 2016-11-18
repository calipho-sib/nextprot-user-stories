package org.nextprot.scenario.step_definition.utils;

import org.junit.Assert;
import org.junit.Test;

public class PropertyRegisterTest {

    @Test
    public void propertiesShouldExist() throws Exception {

        Assert.assertNotNull(PropertyRegister.getProperty("api"));
        Assert.assertNotNull(PropertyRegister.getProperty("search"));
        Assert.assertNotNull(PropertyRegister.getProperty("snorql"));
        Assert.assertNotNull(PropertyRegister.getProperty("any"));
        Assert.assertNotNull(PropertyRegister.getProperty("ndu.email"));
        Assert.assertNotNull(PropertyRegister.getProperty("ndu.google.email"));
        Assert.assertNotNull(PropertyRegister.getProperty("ndu.email.password"));
        Assert.assertNotNull(PropertyRegister.getProperty("ndu.google.email.password"));
    }

    @Test
    public void passwordsShouldNotBeDefined() throws Exception {

        Assert.assertTrue(PropertyRegister.getProperty("ndu.google.email.password").isEmpty());
        Assert.assertTrue(PropertyRegister.getProperty("ndu.email.password").isEmpty());
    }
}