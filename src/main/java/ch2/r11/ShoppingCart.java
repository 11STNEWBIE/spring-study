package main.java.ch2.r11;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Lazy   // 느긋한 초기화 ; 시동 시점에 초기화 하지 않고 나중에 초기화 해서 리소스 절약
@Component
@Scope("prototype") // 고객마다 상이한 카트 인스턴스 가져오도록 함
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {

        items.add(item);
    }

    public List<Product> getItems() {

        return items;
    }
}
