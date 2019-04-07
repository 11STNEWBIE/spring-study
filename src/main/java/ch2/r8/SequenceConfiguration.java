package main.java.ch2.r8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SequenceConfiguration {

    @Bean
    @DependsOn("datePrefixGenerator")       // sequenceGenerator보다 먼저 datePrefixGenerator가 생성된다
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setInitial(100000);
        sequenceGenerator.setSuffix("A");
        return sequenceGenerator;
    }
}
