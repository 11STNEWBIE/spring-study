package main.java.ch2.r20;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 레시피 2-20 : AspectJ 애스펙트를 로드 타임 위빙하기
 *
 * 스프링 AOP 프레임워크는 제한된 타입의 AspectJ 포인트컷만 지원하며 IoC 컨테이너에 선언한 빈에 한하여
 * 애스팩트를 적용할 수 있다. 따라서 포인트컷 타입을 추가하거나, IoC 컨테이너 외부 객체에 애스펙트를 적용하려면
 * 스프링 애플리케이션에서 AspectJ 프레임워크를 직접 끌어쓰는 수밖에 없다.
 *
 * ->
 * 위빙(엮어넣기)은 스펙트를 대상 객체에 적용하는 과정이다.
 * 스프링 AOP는 런타임에 동적 프록시를 활용해 위빙을 하는 반면, AspectJ 프레임워크는
 * 컴파일 타임 위빙,
 * 로드 타임 위빙 모두 지원한다. 이 둘 모두 IoC 컨테이너 선언하기 이전에 수행할 수 있으며, 스프링은 위빙 과정에 관여하지 않는다.
 *
 * AspectJ 로드 타임 위빙은 JVM이 클래스 로더를 이용해 대상 클래스를 로드하는 시점에 일어난다.
 *
 *
 *
 *
 * */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ComplexCalculator complexCalculator =
                context.getBean("complexCalculator", ComplexCalculator.class);

        complexCalculator.add(new Complex(1, 2), new Complex(2, 3));
        complexCalculator.sub(new Complex(5, 8), new Complex(2, 3));
    }
}
