package main.java.ch2.r18;

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
}
