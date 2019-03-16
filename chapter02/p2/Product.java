package com.example.ch2.p2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private double price;
    public String toString() {
        return name + " " + price;
    }
}