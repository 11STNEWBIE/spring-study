package com.apress.spring.ch021.domain;

public class Battery extends Product {

    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public boolean getRechargeable() {
        return rechargeable;
    }

    // 게터 및 세터
    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }
}
