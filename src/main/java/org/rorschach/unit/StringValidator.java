package org.rorschach.unit;

import java.util.LinkedList;
import java.util.function.Predicate;

public class StringValidator {

    private LinkedList<Predicate<String>> verifier = new LinkedList<>();

    public static StringValidator init() {
        return new StringValidator();
    }

    public StringValidator length(int min, int max) {
        verifier.add(it -> length(it, min, max));
        return this;
    }

    public StringValidator regex(String regex) {
        verifier.add(it -> regex(it, regex));
        return this;
    }

    public StringValidator when(PatternSet<String> patterns) {
        verifier.add(patterns);

        return this;
    }

    public boolean verify(String target) {
        for(Predicate<String> v : verifier) if(!v.test(target)) return false;
        return true;
    }

    public static boolean length(String target, int min, int max) {
        return min <= target.length() && target.length() <= max;
    }

    public static boolean regex(String target, String regex) {
        return java.util.regex.Pattern.matches(regex, target);
    }
}
