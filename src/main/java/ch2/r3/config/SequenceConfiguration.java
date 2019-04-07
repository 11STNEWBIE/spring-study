package main.java.ch2.r3.config;

import main.java.ch2.r3.PrefixGenerator;
import main.java.ch2.r3.SequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PrefixConfiguration.class)
/**
    이 구성 클래스에는 없고, 다른 자바 구성 클래스에서 정의되어 있는 경우,
    @Import를 사용해서, 다른 구성 클래스에서 정의한 POJO를 현재 구성 클래스의 스코프로 가져올 수 있다.
*/
public class SequenceConfiguration {

    @Value("#{datePrefixGenerator}")
    private PrefixGenerator prefixGenerator;

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        sequence.setPrefixGenerator(prefixGenerator);
        return sequence;
    }
}
