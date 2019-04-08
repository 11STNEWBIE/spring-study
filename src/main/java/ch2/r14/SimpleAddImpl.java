package main.java.ch2.r14;

import org.springframework.stereotype.Component;

@Component("simpleAdd")
public class SimpleAddImpl implements SimpleAdd {
    @Override
    public void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
