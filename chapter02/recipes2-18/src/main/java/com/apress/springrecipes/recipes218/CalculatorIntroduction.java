package com.apress.springrecipes.recipes218;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CalculatorIntroduction {

    @DeclareParents(
            value = "com.apress.springrecipes.recipes218.ArithmeticCalculatorImpl",
            defaultImpl = MaxCalculatorImpl.class)
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "com.apress.springrecipes.recipes218.ArithmeticCalculatorImpl",
            defaultImpl = MinCalculatorImpl.class)
    public MinCalculator minCalculator;

    @DeclareParents(
        value = "com.apress.springrecipes.recipes218.*CalculatorImpl",
        defaultImpl =CounterImpl.class)
    public Counter counter;

    @After(value = "execution(* com.apress.springrecipes.recipes218.*Calculator.*(..))"
        + " && this(counter)", argNames = "counter")
    public void increaseCount(Counter counter) {
        counter.increase();
    }
}
