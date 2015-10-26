package org.rorschach.unit;

import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class PatternSet<T> implements Predicate<T> {

    private LinkedList<Pattern<T>> pattern = new LinkedList<>();

    public PatternSet<T> addPattern(Pattern<T> pattern) {
        this.pattern.add(pattern);
        return this;
    }

    @Override
    public boolean test(T t) {
        Optional<Pattern<T>> p = pattern.stream().filter(it -> it.IsConditionMatched(t)).findFirst();
        if(!p.isPresent()) throw new RuntimeException();
        return p.get().Verify(t);
    }
}
