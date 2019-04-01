package ch2.r11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 레시피 2.11 : 스프링 환경 및 프로파일마다 다른 POJO 로드하기
 * - 동일한 POJO 인스턴스/빈을 여러 애플리케이션 시나리오(개발, 테스트, 운영)별로 초깃값 달리하여 구성하기
 *
 *
 * ->
 * 자바 구성 클래스를 여러 개 만들고 각 클래스마다 POJO 인스턴스/빈을 묶는다.
 * 이렇게 묶은 의도를 잘 표현할 수 있게 프로파일을 명명하고 자바 구성 클래스에 @Profile을 붙인다.
 * */
public class Main {



    public static void main(String[] args) {

        /**
         * [프로파일을 환경에 로드하기]
         *
         * 프로파일에 속한 빈을 애플리케이션에 로드하려면 일단 프로파일을 활성화해야한다.
         *
         * 프로파일 여러 개를 한 번에 로드하는 것도 가능하며, 자바 런타임 플래그나
         * WAR파일 초기화 매개변수를 지정해 프로그램 방식으로(직접 코딩)프로 파일을 로드할 수 있다.
         *
         *
         * */

        /** 1 프로그램 방식으로 프로파일 로드 */
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("global", "winter");

        /* [기본 프로파일 지정하기]
        context.getEnvironment().setDefaultProfiles("global");

           -> 요런 방식이면, 런타임 플래그 혹은 WAR파일 초기화 매개변수로 지정할 때,
                spring.profiles.default로 대신한다.
         */
        context.scan("ch2.r11");
        context.refresh();

        /** 2 cf_ 자바 런타임 플래그로 로드할 프로파일을 명시하는 방법도 있다.
         *
         *      // global, winter 프로파일에 속한 빈을 로드하는 경우 다음 플래그 추가
         *      ex> -Dspring.profiles.active=global,winter
         * */

    }
}
