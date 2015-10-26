package org.rorschach.unit;

public interface Pattern<T> {

    boolean IsConditionMatched(T value);

    boolean Verify(T value);

}
