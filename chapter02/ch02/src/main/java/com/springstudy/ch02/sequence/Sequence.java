package com.springstudy.ch02.sequence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;
}
