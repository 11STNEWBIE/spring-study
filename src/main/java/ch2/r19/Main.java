package main.java.ch2.r19;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 * 레시피 2-19 : AOP 이용해 POJO에 상태 추가하기
 *
 * 기존 객체에 새로운 상태를 추가해서 호출 횟수, 최종 수정 일자 등 사용 내역을 파악하고 싶은 경우가 있다.
 * 모든 객체가 동일한 베이스 클래스를 상속하는 건 해결책이 될 수 없다.
 * 레이어 구조가 다른 여러 클래스에 상태를 추가하기란 더욱 어렵다.
 *
 * ->
 * 상태 필드가 위치한 구현 클래스의 인터페이스를 기존 객체에 들여온 다음,
 * 특정 조건에 따라 상태값을 바꾸는 어드바이스를 작성한다.
 *
 *
 * */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ArithmeticCalculator arithmeticCalculator =
                (ArithmeticCalculator) context.getBean("arithmeticCalculator");

        UnitCalculator unitCalculator =
                (UnitCalculator) context.getBean("unitCalculator");


        Counter arithmeticCounter = (Counter) arithmeticCalculator;
        System.out.println(arithmeticCounter.getCount());

        Counter unitCounter = (Counter) unitCalculator;
        System.out.println(unitCounter.getCount());
    }


}
