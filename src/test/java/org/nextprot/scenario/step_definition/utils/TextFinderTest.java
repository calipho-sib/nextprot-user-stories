package org.nextprot.scenario.step_definition.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextFinderTest {

    private final String source = "Lorem ipsum dolor sit amet, consectetuer integer nulla aliquam, massa tempor taciti est, mattis " +
            "bibendum, justo nostra. Molestie gravida tristique, ipsum fermentum lobortis mattis felis, et egestas " +
            "ultricies ligula vel. Vivamus vestibulum ut orci pretium, nam mauris fringilla arcu. Tristique ac diam, " +
            "orci ac duis non. Dignissim quis ante primis, in vestibulum molestie neque egestas, pede luctus cursus neque " +
            "amet, maecenas dolor ultricies amet volutpat pulvinar at, dolor habitant adipiscing velit magnis amet non. " +
            "Eget id ut aliquam sollicitudin sed eu, nonummy vitae. Leo luctus nec semper, pede at dui, turpis condimentum " +
            "mauris eu. Nam tempus, quis inceptos vivamus, odio libero, id elit. Nec elementum. Consequat malesuada ac, " +
            "pellentesque orci viverra. Duis mi at, elit amet lectus auctor fermentum torquent, ut vel.";

    @Test
    public void shouldFindTextList() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(source);

        Assert.assertTrue(finder.findText(Arrays.asList("quis", "amet")));
    }

    @Test
    public void shouldNotFindRoudoudouInTextList() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(source);

        Assert.assertTrue(!finder.findText(Arrays.asList("quis", "roudoudou")));
    }

    @Test
    public void shouldFindInsensitiveCaseTextList() throws Exception {

        TextFinder finder = TextFinder.CaseInsensitive(source);

        Assert.assertTrue(finder.findText(Arrays.asList("QUIS", "amet")));
    }

    @Test
    public void shouldNotFindText() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(source);

        Assert.assertTrue(finder.findText(Collections.singletonList("roudoudou"), true));
    }

    @Test
    public void shouldMatchPattern() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(source);

        Assert.assertTrue(finder.matchPattern(Collections.singletonList("gravida\\s+tristique")));
    }
}