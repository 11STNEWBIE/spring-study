package com.apress.springrecipes.shop;

import lombok.Data;

@Data
public class Battery extends Product {

    private boolean rechargeable;

    public Battery(String name, double price) {
        super(name, price);
    }
}
