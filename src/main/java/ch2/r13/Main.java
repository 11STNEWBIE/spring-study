package main.java.ch2.r13;


/**
 * 레시피 2-13 : 애너테이션을 활용해 애스팩트 지향 프로그래밍(AOP)
 *
 * ->
 *
 * Aspect를 정의하려면 -> 자바 클래스에 @Aspect 붙인다. 그리고 메서드별로 적절한 Annotation을 붙여 advice로 만든다.
 *
 * Advice Annotation은 @Before, @After, @AfterReturning, @AfterThrowing, @Around 5개 중 하나를 쓸 수 있다.
 *
 * IoC 컨테이너에서 Aspect Annotation 기능을 활성화하러면 구성 클래스 중 하나에 @EnableAspectJAutoProxy를 붙인다.
 *
 *
 * */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Aspect
 *
 * Aspect는 여러 타입과 객체에 공통 관심사(ex> 로깅, 트랜잭션 관리)를 모듈화한 자바 클래스로, @Aspect를 붙여 표시한다.
 *
 * AOP에서 말하는 애스팩트란 어디에서(포인트컷) 무엇을 할 것인지(어드바이스)를 합쳐 놓은 개념이다.
 *
 *  * 어드바이스 : @Advice를 붙인 단순 자바 메서드로, AspectJ는 @Before, @After, @AfterReturning, @AfterThrowing,
 *              @Around 다섯 개 어드바이스 애너테이션을 지원한다.
 *
 *  * 포인트컷 : 어드바이스에 적용할 타입 및 객체를 찾는 표현식이다.
 *
 * */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ArithmeticCalculator arithmeticCalculator =
                context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);

        UnitCalculator unitCalculator = context.getBean(
                "unitCalculator", UnitCalculator.class
        );
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);

    }

}
