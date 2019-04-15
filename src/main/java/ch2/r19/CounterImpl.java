package main.java.ch2.r19;

public class CounterImpl implements Counter {

    private int count;

    @Override
    public void increase() {
        count++;

    }

    @Override
    public int getCount() {
        return count;
    }
}
