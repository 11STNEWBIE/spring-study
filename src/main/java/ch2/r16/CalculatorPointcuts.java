package main.java.ch2.r16;

import org.aspectj.lang.annotation.Pointcut;

public class CalculatorPointcuts {

    /**
     * 여러 애스팩트가 포인트컷을 공유하는 경우라면, 공통 클래스 한 곳에 포인트컷을 모아두는 편이 좋다.
     *
     * 이 때 당연히, 포인트컷 메서드는 public으로 선언한다.
     *
     * */


    @Pointcut("execution(* *.*(..))")
    public void loggingOperation() {}
}
