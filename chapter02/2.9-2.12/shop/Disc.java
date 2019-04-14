package com.apress.springrecipes.shop;

import lombok.Data;

@Data
public class Disc extends Product{

    private int capacity;

    public Disc(String name, double price, double specialEndofyearDiscountField){
        super(name, price);
    }

    public Disc(String name, double price) {
        super(name, price);
    }
}
