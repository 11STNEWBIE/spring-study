package com.springstudy.ch02.config;

import com.springstudy.ch02.sequence.DatePrefixGenerator;
import com.springstudy.ch02.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator datePrefixGenerator = new DatePrefixGenerator();
        datePrefixGenerator.setPattern("yyyyMMdd");
        return datePrefixGenerator;
    }

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator seqGenerator = new SequenceGenerator();
        seqGenerator.setSuffix("A");
        seqGenerator.setInitial(100000);
        seqGenerator.setPrefixGenerator(datePrefixGenerator());
        return seqGenerator;
    }
}
