package ch2.r7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ShopConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/ch2/r7/resources/messages");   // bundle 위치 지정 ; 이름이 messages로 시작하는 파일들 찾도록 설정
        messageSource.setCacheSeconds(1);   // 쓸모 없는 메시지 다시 읽지 않게 함
        return messageSource;
    }
    /** 미국 로케일에서 찾는 경우,
     *  messages_en_US.properties 번들 파일 제일 먼저 잡힘.
     *  이런 이름 가진 파일 없거나 메시지 못찾으면, messages_en.properties 잡고
     *  그 다음에도 없으면, messages.properties 선택한다.
     * */
}
