package recipe2_10_1;

public class Disc extends Product {

    private int capacity;

    public Disc() {
        super();
    }

    public Disc(String name, double price) {
        super(name, price);
    }

    public int getCapacity() {
        return capacity;
    }

    // Getters and Setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}