package com.example.ch2.p2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disc extends Product{
    private int capacity;

    public Disc() {
        super();
    }

    public Disc(String name, double price) {
        super(name, price);
    }
}
