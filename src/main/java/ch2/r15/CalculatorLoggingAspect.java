package main.java.ch2.r15;

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
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect implements Ordered {

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

    @Before("execution(* *.*(..))")
    public void logJoinPoint(JoinPoint joinPoint) {
        log.info("Join point kind : {}", joinPoint.getKind());
        log.info("Signature declaring type : {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Signature name : {}", joinPoint.getSignature().getName());
        log.info("Arguments : {}", Arrays.toString(joinPoint.getArgs()));
        log.info("Target class : {}", joinPoint.getTarget().getClass().getName());  // 대상 객체 정보
        log.info("This class : {}", joinPoint.getThis().getClass().getName());      // 프록시 객체 정보

    }




    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method " + joinPoint.getSignature().getName()
        + "() ends");
    }

    @AfterReturning(pointcut = "execution(* *.*(..))",
    returning = "result")
    public void logAfterReturnin(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}",
                joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "execution(* *.*(..))",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {    // 여기 e 에 타입 선언하면, 그 타입과 호환하는 에러가 난 경우만 어드바이스 실행됨.
        log.error("An exception {} has been thrown in {}()",
                e,
                joinPoint.getSignature().getName());
    }

    // 가장 강력한 Advice. 원본 인숫값 바꾸거나 최종 반환값 변경하는 일도 가능하지만,
    // 간혹 원본 조인포인트를 진행하는 호출을 잊어버리기 쉬우므로 사용시 주의해야 한다.
    @Around("execution(* *.*(..))")
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

    @Override
    public int getOrder() {
        return 1;
    }
}
