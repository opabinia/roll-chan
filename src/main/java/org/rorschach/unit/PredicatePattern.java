package org.rorschach.unit;

import java.util.function.Predicate;

public class PredicatePattern<T> implements Pattern<T> {

    private Predicate<T> condition;
    private Predicate<T> predicate;

    public PredicatePattern(Predicate<T> condition, Predicate<T> predicate) {
        this.condition = condition;
        this.predicate = predicate;
    }

    @Override
    public boolean IsConditionMatched(T value) {
        return condition.test(value);
    }

    @Override
    public boolean Verify(T value) {
        return predicate.test(value);
    }
}
