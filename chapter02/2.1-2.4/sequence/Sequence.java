package com.apress.springrecipes.sequence;

import lombok.Data;

// Dao 를 이용해 POJO를 생성하기 위해
@Data
public class Sequence {

    private final String id;
    private final String prefix;
    private final String suffix;

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}