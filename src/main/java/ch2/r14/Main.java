package main.java.ch2.r14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 레시피 2-14 : 조인포인트 정보 가져오기
 *
 * AOP에서 어드바이스는 여러 조인포인트, 즉 프로그램 실행 지점 곳곳에 적용된다.
 * 어드바이스가 정확하게 작동하려면 조인포인트에 대한 세부 정보가 필요한 경우가 많다.
 *
 * ->
 * 어드바이스 메서드의 시그니처에 org.aspectj.lang.JoinPoint형 인수를 선언하면
 * 여기서 조인포인트 정보를 얻을 수 있다.
 *
 *
 * */



public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        SimpleAdd simpleAdd = context.getBean("simpleAdd", SimpleAdd.class);
        simpleAdd.add(3, 5);


    }
}
