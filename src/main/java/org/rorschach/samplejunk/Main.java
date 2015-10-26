package org.rorschach.samplejunk;

import org.rorschach.unit.Matcher;
import org.rorschach.unit.PatternSet;
import org.rorschach.unit.StringValidator;

public class Main {

    public static void main(String[] args){
        boolean result = StringValidator
                .init()
                .length(5,10)
                .regex("\\d+")
                .when(new PatternSet<String>()
                            .addPattern(Matcher.<String>Pattern(it -> it.startsWith("1"), it -> it.length() == 5))
                            .addPattern(Matcher.<String>Pattern(true, it -> true))
                ).verify("10000");
        System.out.println(result);
    }

}
