package org.rorschach.unit;

import java.util.function.Predicate;

public class Matcher {

    public static <T> Pattern<T> Pattern(Predicate<T> condition, Predicate<T> predicate) {
        return new PredicatePattern<>(condition, predicate);
    }

    public static <T> Pattern<T> Pattern(boolean condition, Predicate<T> predicate) {
        return new ConstPattern<>(condition, predicate);
    }

}
