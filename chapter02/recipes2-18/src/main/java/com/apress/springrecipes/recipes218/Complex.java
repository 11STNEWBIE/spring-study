package com.apress.springrecipes.recipes218;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Complex {
    private int real;
    private int imaginary;

    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }
}
