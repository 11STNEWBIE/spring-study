package main.java.ch2.r15;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorValidationAspect implements Ordered {
    /** 하나 더 추가된 Aspect
     *
     * Aspect를 둘 다 쓰면, 어느 쪽을 먼저 적용해야 할지 알 수 없다.
     *
     * 어느 한 애스펙트가 다른 것보다 먼저 실행되게 하려면, 우선순위를 부여해야 한다.
     *
     * 두 애스팩트 모두 Ordered 인터페이스를 구현하거나, @Order 애너테이션을 활용하면 된다.
     *
     * Ordered 인터페이스를 구현할 경우, getOrder() 메서드가 반환하는 값이 작을수록 우선순위가 높다.
     *
     * 더 깔끔하게는,
     * @Order(1), @Order(2)로 구현할 수 있다.
     * */

    @Before("execution(* *.*(double, double))")
    public void validateBefore(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            validate((Double) arg);
        }
    }

    private void validate(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
