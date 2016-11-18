package org.nextprot.stepdefs;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFinder {

    private final String pageSource;
    private final boolean caseSensitive;
    private final boolean reverseSearch;

    TextFinder(String pageSource, boolean caseSensitive, boolean reverseSearch) {

        Objects.requireNonNull(pageSource);

        this.pageSource = pageSource;
        this.caseSensitive = caseSensitive;
        this.reverseSearch = reverseSearch;
    }

    public boolean findText(List<String> textList) {

        for (String text : textList) {
            if (((caseSensitive) ? pageSource.contains(text) : Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE).matcher(pageSource).find()) != reverseSearch) {
                return false;
            }
        }

        return true;
    }

    public boolean matchPattern(List<String> patternList) {

        for (String pattern : patternList) {

            String regex = ".+" + pattern + ".+";
            Pattern p = (caseSensitive) ? Pattern.compile(regex, Pattern.DOTALL) : Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
            Matcher regexMatcher = p.matcher(pageSource);

            if (regexMatcher.find() != reverseSearch) {
                return false;
            }
        }

        return true;
    }
}
