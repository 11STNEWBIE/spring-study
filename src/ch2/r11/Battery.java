package ch2.r11;



public class Battery extends Product {
    private boolean rechargeable;

    public Battery() {
        super();
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }

    public boolean isRechargeable() {
        return rechargeable;
    }
}
