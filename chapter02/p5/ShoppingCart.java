package com.example.ch2.p5;

import com.example.ch2.p2.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }
    public List<Product> getItems() {
        return items;
    }

}
