package com.example.ch2.p1;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@NoArgsConstructor
public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix).append(initial).append(counter.getAndIncrement()).append(suffix);
        return builder.toString();
    }
}
