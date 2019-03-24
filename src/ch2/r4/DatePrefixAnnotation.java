package ch2.r4;


import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Custom Annotation
 *      - 타입이 여럿인 경우, @Inject를 이용해 이름으로 자동 연결하고자 할 때
 *
 *      - POJO 주입 클래스와 주입 지점 구별
 * */


@Qualifier      // javax.inject.Qualifier
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePrefixAnnotation {
}
