package recipe2_13_16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import recipe2_13_16.calculator.ArithmeticCalculator;
import recipe2_13_16.calculator.UnitCalculator;

public class Main {
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
//        arithmeticCalculator.add(1,-2);
        arithmeticCalculator.add(1,2);
        arithmeticCalculator.sub(2,2);
        arithmeticCalculator.mul(3,2);
//        arithmeticCalculator.div(4,0);
        arithmeticCalculator.div(4,2);

        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);
    }
}
