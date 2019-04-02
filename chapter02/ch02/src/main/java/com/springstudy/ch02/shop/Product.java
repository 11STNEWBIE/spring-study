package com.springstudy.ch02.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public abstract class Product {
    private String name;
    private double price;

    @Override
    public String toString() {
        return name + " " + price;
    }
}
