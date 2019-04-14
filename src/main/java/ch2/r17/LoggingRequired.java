package main.java.ch2.r17;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 로깅이 필요한 메소드에 붙이는 커스텀 애너테이션.
 * 클래스 레벨에 붙이면 모든 메서드에 적용된다.
 * 단, 애너테이션은 상속되지 않으므로 인터페이스가 아닌, 구현 클래스에만 붙여야한다.
 * */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggingRequired {
}
