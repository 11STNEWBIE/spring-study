package ch2.r6;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 *
 *  #@PropertySource
 *
 *  외부 리소스(텍스트, XML, 프로퍼티, 이미지 파일)의 데이터 사용하기
 *
 *  여러 곳(ex> 파일시스템, 클래스패스, URL)에 있는 외부 리소스를 각자 알맞은 API로 읽어들여야 할 때가 있다
 *
 *      -> @PropertySource
 *          - 빈 프로퍼티 구성용 .properties 파일(키-값 쌍)을 읽어들일 수 있다
 *
 *          - Resource라는 단일 인터페이스를 사용해, 어떤 유형의 외부 리소스라도 '경로만 지정하면' 가져올 수 있는 리소스 로드 메커니즘 마련되어 있음.
 *
 *          - @Value로 접두어를 달리 하여, 상이한 위치에 있는 리소스를 불러올 수도 있다.
 *              이를테면, 파일시스템 리소스는 file, 클래스패스에 있는 리소스는 classpath 접두어로 붙이는 식. 리소스 경로는 URL로도 지정가능.
 *
 *          - @PropertySource와 PropertySourcesPlaceholderConfigurer 클래스를 이용하면,
 *              빈 프로퍼티 구성 전용 프로퍼티 파일의 내용(키-값)을 읽을 수 있다. 스프링 Resource 인터페이스에 @Value를 곁들이면 어느 파일도 읽어들일 수 있다
 *
 * */
public class Main {

    private final static String resourcePath = "/Users/a1101082/Study/spring-study/src/ch2/r6/resources";

    /* 애플리케이션 종료되면 할인률 출력하도록 */
    public static void main(String[] args) throws Exception {

        // 클래스 패스 기준으로 가져오기
        Resource discountResource =
                new ClassPathResource("/ch2/r6/resources/discounts.properties");
        Properties discountProps = PropertiesLoaderUtils.loadProperties(discountResource);

        // 외부에 있는 경우 보통 사용하며, 절대 경로 지정으로 가져오기
        Resource bannerResource = new FileSystemResource(String.format("%s/banner.txt", resourcePath));
        Properties bannerProps = PropertiesLoaderUtils.loadProperties(bannerResource);


        System.out.println("And don't forget our discounts!");
        System.out.println(discountProps);
        System.out.println("And don't forget our banners! :)");
        System.out.println(bannerProps);
    }
}
