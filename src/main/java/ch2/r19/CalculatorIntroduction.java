package main.java.ch2.r19;

import main.java.ch2.r18.MaxCalculator;
import main.java.ch2.r18.MaxCalculatorImpl;
import main.java.ch2.r18.MinCalculator;
import main.java.ch2.r18.MinCalculatorImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {

    /**
     * @DeclareParens의 value 속성으로 지정하여, 인트로덕션 대상 클래스를 지정한다.
     * 이 애너테이션을 붙인 필드형을 따라 들여올 인터페이스가 결정된다.
     *
     * 새 인터페이스에서 사요할 구현 클래스는 defaultImpl 속성에 명시한다
     *
     * */

    @DeclareParents(
            value="main.java.ch2.r18.ArithmeticCalculatorImpl",
            defaultImpl = MaxCalculatorImpl.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "main.java.ch2.r18.ArithmeticCalculatorImpl",
            defaultImpl = MinCalculatorImpl.class
    )
    public MinCalculator minCalculator;




    /**
     * CounterImpl을 각 Calculator 객체에 드령온다.
     *
     *
     *
     * */

    @DeclareParents(
            value = "main.java.ch2.r18.*CalculatorImpl",
            defaultImpl = CounterImpl.class
    )
    public Counter counter;

    /***
     * 계산기 메서드를 한번 호출할 때마다 counter를 하나씩 증가하려면 다음과 같이 After 어드바이스를 적용한다.
     *
     * 그리고 Counter 인터페이스를 구현한 객체는 프록시가 유일하므로, target이 아닌 this객체를 가져와 사용한다.
     * (이해 잘 안됨 ㅜㅜㅜ)
     *
     */

    @After("execution(* main.java.ch2.r18.*Calculator.*(..))"
            + " && this(counter)")
    public void increaseCount(Counter counter) {
        counter.increase();
    }
}
