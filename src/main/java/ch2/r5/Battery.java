package main.java.ch2.r5;


public class Battery extends Product {
    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }
}
