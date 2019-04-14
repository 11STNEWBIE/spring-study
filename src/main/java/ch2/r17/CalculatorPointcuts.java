package main.java.ch2.r17;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcuts {

    /**
     * 여러 애스팩트가 포인트컷을 공유하는 경우라면, 공통 클래스 한 곳에 포인트컷을 모아두는 편이 좋다.
     *
     * 이 때 당연히, 포인트컷 메서드는 public으로 선언한다.
     *
     * */



    /**
     * 포인트컷 표현식을 넣어서, LoggingRequired가 붙인 클래스를 스캐닝하도록 한다
     * */
    @Pointcut("@annotation(LoggingRequired)")
    public void loggingOperation() {}


    /**
     * 타입 시그니처 패턴
     *
     * 특정 타입 내부의 모든 조인포인트를 매치하는 포인트컷 표현식도 있다.
     *
     * AOP에 적용하면 그 타입 안에 구현된 메서드를 실행할 때만 어드바이스가 적용되도록 포인트컷 적용 범위를 좁힐 수 있다.
     *
     * */


    /**
     * ArithmeticCalculator 인터페이스를 구현한 모든 클래스의 메서드 실행 조인포인트 매치
     * */
    @Pointcut("within(ArithmeticCalculator+)")
    public void arithmeticOperation() {
    }

    @Pointcut("within(UnitCalculator+)")
    public void unitOperation() {
    }
    /**
     * UnitCalculator 또는 ArithmeticCalculator 인터페이스를 구현한 모든 클래스의 메서드 실행 조인포인트 매치
     * */
//    @Pointcut("within(UnitCalculator+) || within(ArithmeticCalculator+)")
    @Pointcut("arithmeticOperation() || unitOperation()")
    public void loggingOperation2() {
    }

    /**
     * 지정 패키지 이하의 전체 메서드 실행 조인포인트를 매치한다.
     * */
    @Pointcut("within(main.java.ch2.r17.*)")
    public void foo() {
    }

    @Pointcut("execution(* *.*(..)) && target(target) && args(a,b)")
    public void parameterPointcut(Object target, double a, double b) {}

}
