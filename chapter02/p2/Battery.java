package com.example.ch2.p2;

import lombok.*;

@Getter
@Setter
public class Battery extends Product {
    private boolean rechagable;

    public Battery() {
    }

    public Battery(String name, double price) {
        super(name, price);
    }
}
