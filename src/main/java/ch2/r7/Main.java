package main.java.ch2.r7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 *
 * 애너테이션을 이용해 다국어를 지원하는 애플리케이션 작성
 *
 * MessageSource 인터페이스에는 리소스 번들 메시지를 처리하는 메서드가 존재.
 *
 * ResourceBundleMessageSource는 가장 많이 쓰는 MessageResource 구현체
 *  - 이를 POJO로 구현하고, @Bean을 붙여 선언하면 애플리케이션에서 필요한 i18n 데이터를 가져다 쓸 수 있다
 *  -
 *
 *
 * */

public class Main {


    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ShopConfiguration.class);

        /**
         * getMessage(String s, Object[] objects, Locale locale)
         * 1st param : 메시지 키
         * 2nd param : 메시지 매개변수 배열.
         * 3rd param : 대상 로케
         * */

        /* Main에서는 애플리케이션 컨텍스트를 직접 가져올 수 있으므로, 텍스트 메시지 해석 가능하다  */
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("alert.inventory.checkout",
                new Object[] {"[DVD-RW 3.0]", new Date()}, Locale.US);

        System.out.println("The I18N message for alert.checkout is: " + alert);
        System.out.println("The I18N message for alert.inventory.checkout is: " + alert_inventory );
    }
}
