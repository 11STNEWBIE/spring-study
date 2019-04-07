package recipe2_13_16;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect_2_13 {

    private Logger log = LoggerFactory.getLogger(this.getClass());

//    @Before("execution(* ArithmeticCalculator.add(..))")
//    public void logBefore() {
//        log.info("The method add() begins");
//    }


    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method "+ joinPoint.getSignature().getName()
        + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method "+ joinPoint.getSignature().getName()
                + "() ends");
    }

    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
//    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("An exception has been thrown in {}()", e, joinPoint.getSignature().getName());
    }

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("the method{}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            log.info("The method {}() ends with ", joinPoint.getSignature().getName(),
                    result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }
}
