package org.nextprot.scenario.step_definition.utils;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Finds words or matches patterns from text source
 */
public class TextFinder {

    private final String textSource;
    private final boolean caseSensitive;

    public TextFinder(String textSource, boolean caseSensitive) {

        Objects.requireNonNull(textSource);

        this.textSource = textSource;
        this.caseSensitive = caseSensitive;
    }

    public static TextFinder CaseSensitive(String source) {

        return new TextFinder(source, true);
    }

    public static TextFinder CaseInsensitive(String source) {

        return new TextFinder(source, false);
    }

    public boolean findText(List<String> textList) {

        return findText(textList, false);
    }

    public boolean findText(List<String> textList, boolean reverseSearch) {

        for (String text : textList) {
            if (((caseSensitive) ? textSource.contains(text) : Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE).matcher(textSource).find()) == reverseSearch) {
                return false;
            }
        }

        return true;
    }

    public boolean matchPattern(List<String> textList) {

        return matchPattern(textList, false);
    }

    public boolean matchPattern(List<String> patternList, boolean reverseSearch) {

        for (String pattern : patternList) {

            String regex = ".+" + pattern + ".+";
            Pattern p = (caseSensitive) ? Pattern.compile(regex, Pattern.DOTALL) : Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
            Matcher regexMatcher = p.matcher(textSource);

            if (regexMatcher.find() == reverseSearch) {
                return false;
            }
        }

        return true;
    }
}
