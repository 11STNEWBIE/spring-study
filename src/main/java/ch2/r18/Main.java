package main.java.ch2.r18;


/**
 * 레시피2-18 : 인트로덕션을 이용해 POJO에 기능 더하기
 *
 * 어떤 공통 로직을 공유하는 클래스가 여러 개 있을 경우, 보통 OOP에서는 같은 base class를 상속하거나 같은 인터페이스를 구현하는 형태로 개발한다.
 *
 * AOP 관점에서는 충분히 모듈화 가능한 공통 관심사인데, 자바는 언어 구조상 클래스를 한 개만 상속가능하기에,
 * 동시에 여러 구현 클래스로부터 기능을 물려받아 쓰는 일을 불가능하다.
 *
 *
 * -> Introduction(인트로덕션 : 끌어들임)
 * 인트로덕션은 AOP어드바이스의 특별한 타입이다. 객체가 어떤 인터페이스의 구현 클래스를 공급받아 동적으로 인터페이스를 구현하는 기술이다.
 * 마치 객체가 런타임에 구현 클래스를 상속하는 것처럼 보인다.
 * 게다가, 여러 구현 클래스를 지닌 여러 인터페이스를 동시에 인트로듀스할 수 있어서 사실상 다중 상속도 가능하다.
 *
 * */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ArithmeticCalculatorImpl에서 max()와 min() 을 둘다 계산하려면, 단일 상속만 가능하기에 동시 상속이 불가하다.
 *
 * 이럴 때, 인트로덕션을 쓰면, MaxCalculator, MinCalculator 인터 페이스를 둘 다 동적으로 구현한 것처럼 이용가능하다.
 *
 * ---->
 * 스프링 AOP에서 인트로덕션이 움직이는 비결은, 동적 프록시이다.
 * 인트로덕션은 동적 프록시에
 *
 *
 * */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ArithmeticCalculator arithmeticCalculator =
                (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);

        UnitCalculator unitCalculator =
                (UnitCalculator) context.getBean("unitCalculator");
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);


        /***
         * 다음 아래와 같이, 설정한 인트로덕션을 통해서 ArithmeticCalculatorImpl 클래스로 두 인터페이스를
         * 동적으로 들여올 수 있다.
         *
         * @DeclareParents의 value속성값에 AspectJ의 타입 매치 표현식을 넣으면 여러 클래스로 인터페이스를 들여올 수 있다.
         *
         * MaxCalculator와 MinCalculator 두 인터페이스를 ArithmeticCalculatorImpl에 들여왔으면, 해당 인터페이스로 캐스팅 후,
         * max() min()계산을 수행할 수 있다.
          * */

        MaxCalculator maxCalculator = (MaxCalculator) arithmeticCalculator;
        maxCalculator.max(1, 2);

        MinCalculator minCalculator = (MinCalculator) arithmeticCalculator;
        minCalculator.min(1, 2);
    }

}

