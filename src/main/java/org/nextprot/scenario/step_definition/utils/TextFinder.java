package org.nextprot.scenario.step_definition.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;


/**
 * Finds words or matches patterns from text sources
 */
public class TextFinder {

    private final List<String> textSources;
    private final boolean caseSensitive;

    public TextFinder(List<String> textSources, boolean caseSensitive) {

        Objects.requireNonNull(textSources);

        this.textSources = new ArrayList<>();
        this.textSources.addAll(textSources);
        this.caseSensitive = caseSensitive;
    }

    public static TextFinder CaseSensitive(List<String> sources) {

        return new TextFinder(sources, true);
    }

    public static TextFinder CaseInsensitive(List<String> sources) {

        return new TextFinder(sources, false);
    }

    /**
     * Search texts in all page sources
     *
     * @param textList the text list to be find or not find (@see reverseSearch)
     * @param not true if given texts should not be found
     * @return
     */
    public boolean search(List<String> textList, boolean not) {

        for (String textSource : textSources) {

            if (search(textSource, textList, not))
                return true;
        }

        return false;
    }

    private boolean search(String textSource, List<String> textList, boolean not) {

        for (String text : textList) {

            if (findMatch(textSource, Pattern.quote(text), false) == not)
                return false;
        }

        return true;
    }

    public boolean matchPattern(List<String> patternList, boolean not) {

        for (String textSource : textSources) {

            if (matchPattern(textSource, patternList, not))
                return true;
        }

        return false;
    }

    private boolean matchPattern(String textSource, List<String> patternList, boolean not) {

        for (String pattern : patternList) {

            if (findMatch(textSource, pattern, true) == not)
                return false;
        }

        return true;
    }

    private boolean findMatch(String textSource, String regex, boolean extended) {

        Pattern pattern;

        if (extended) {
            pattern = (caseSensitive) ? compile(regex, Pattern.DOTALL) : compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        }
        else {
            pattern = (caseSensitive) ? compile(regex) : compile(regex, Pattern.CASE_INSENSITIVE);
        }

        return pattern.matcher(textSource).find();
    }
}
