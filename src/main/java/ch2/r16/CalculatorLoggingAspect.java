package main.java.ch2.r16;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(0)
@Aspect
@Component
public class CalculatorLoggingAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * logJoinPoint 어드바이스에서 조인포인트 정보를 액세스한다고 하자.
     *
     * 필요한 정보는 조인포인트 유형(스프링 AOP의 메서드 실행만 해당),
     * 메서드 시그니처,
     * 인수값,
     * 대상 객체와 프록시 객체이다
     *
     * */



    @Before("CalculatorPointcuts.loggingOperation()")
    public void logBefore(JoinPoint joinPoint) {

    }


    @After("CalculatorPointcuts.loggingOperation()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
        + "() ends");
    }

    @AfterReturning(
            pointcut = "CalculatorPointcuts.loggingOperation()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}",
                joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "CalculatorPointcuts.loggingOperation()",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {    // 여기 e 에 타입 선언하면, 그 타입과 호환하는 에러가 난 경우만 어드바이스 실행됨.
        log.error("An exception {} has been thrown in {}()",
                e,
                joinPoint.getSignature().getName());
    }

    // 가장 강력한 Advice. 원본 인숫값 바꾸거나 최종 반환값 변경하는 일도 가능하지만,
    // 간혹 원본 조인포인트를 진행하는 호출을 잊어버리기 쉬우므로 사용시 주의해야 한다.
    @Around("CalculatorPointcuts.loggingOperation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            log.info("The method {}() ends with", joinPoint.getSignature().getName(),
                    result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getName());
            throw e;
        }
    }

}
