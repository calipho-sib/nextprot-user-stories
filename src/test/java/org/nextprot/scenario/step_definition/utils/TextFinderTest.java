package org.nextprot.scenario.step_definition.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextFinderTest {

    private List<String> sources;

    @Before
    public void setup() {

        sources = Arrays.asList("hello world", "Lorem ipsum dolor sit amet, consectetuer integer nulla aliquam, massa tempor taciti est, mattis " +
                "bibendum, justo nostra. Molestie gravida tristique, ipsum fermentum lobortis mattis felis, et egestas " +
                "ultricies ligula vel. Vivamus vestibulum ut orci pretium, nam mauris fringilla arcu. Tristique ac diam, " +
                "orci ac duis non. Dignissim quis ante primis, in vestibulum molestie neque egestas, pede luctus cursus neque " +
                "amet, maecenas dolor ultricies amet volutpat pulvinar at, dolor habitant adipiscing velit magnis amet non. " +
                "Eget id ut aliquam sollicitudin sed eu, nonummy vitae. Leo luctus nec semper, pede at dui, turpis condimentum " +
                "mauris eu. Nam tempus, quis inceptos vivamus, odio libero, id elit. Nec elementum. Consequat malesuada ac, " +
                "pellentesque orci viverra. Duis mi at, elit amet lectus auctor fermentum torquent, ut vel hello.");
    }

    @Test
    public void shouldFindTextsInAtLeastOneSource() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(sources);

        Assert.assertTrue(finder.search(Arrays.asList("quis", "amet"), false));
    }

    @Test
    public void shouldNotFindAllTextsInSources() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(sources);

        Assert.assertTrue(!finder.search(Arrays.asList("quis", "roudoudou"), false));
    }

    @Test
    public void shouldFindInsensitiveCaseTextsInAtLeastOneSource() throws Exception {

        TextFinder finder = TextFinder.CaseInsensitive(sources);

        Assert.assertTrue(finder.search(Arrays.asList("QUIS", "amet"), false));
    }

    @Test
    public void shouldNotFindTextsInSources() throws Exception {

        TextFinder finder = TextFinder.CaseInsensitive(sources);

        Assert.assertTrue(finder.search(Arrays.asList("roudoudou", "rantanplan"), true));
    }

    @Test
    public void shouldNotFindTextsInSources2() throws Exception {

        TextFinder finder = TextFinder.CaseInsensitive(sources);

        Assert.assertFalse(finder.search(Arrays.asList("hello", "rantanplan"), true));
    }

    @Test
    public void shouldMatchPattern() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(sources);

        Assert.assertTrue(finder.matchPattern(Collections.singletonList("gravida\\s+tristique"), false));
    }

    @Test
    public void shouldMatchPatternMultiline() throws Exception {

        TextFinder finder = TextFinder.CaseSensitive(sources);

        Assert.assertTrue(finder.matchPattern(Collections.singletonList("gravida.+lectus"), false));
    }
}