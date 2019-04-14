package main.java.ch2.r18;

import main.java.ch2.r17.LoggingRequired;
import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
@LoggingRequired
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public double add(double a, double b) {
        double result = a + b;
        System.out.println(a + " + " + b + " = " + result);

        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a - b;
        System.out.println(a + " - " + b + " = " + result);

        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a * b;
        System.out.println(a + " x " + b + " = " + result);

        return result;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("Division by zero");
        double result = a / b;
        System.out.println(a + " / " + b  + " = " + result);

        return result;
    }
}
