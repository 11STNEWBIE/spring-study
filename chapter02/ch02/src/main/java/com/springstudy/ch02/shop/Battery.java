package com.springstudy.ch02.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battery extends Product {
    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }
}
