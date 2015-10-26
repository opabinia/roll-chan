package org.rorschach.unit;

import java.util.function.Predicate;

public class ConstPattern<T> implements Pattern<T> {

    private boolean condition;
    private Predicate<T> predicate;

    public ConstPattern(boolean condition, Predicate<T> predicate) {
        this.condition = condition;
        this.predicate = predicate;
    }

    @Override
    public boolean IsConditionMatched(T value) {
        return condition;
    }

    @Override
    public boolean Verify(T value) {
        return predicate.test(value);
    }
}
