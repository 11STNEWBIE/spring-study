package com.example.ch2.p3;

import com.example.ch2.p1.SequenceGenerator;
import org.springframework.context.annotation.Bean;

public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setInitial(100000);
        sequenceGenerator.setSuffix("A");
        sequenceGenerator.sePrefixGenerator(datePrefixGenerator());
        return sequenceGenerator;
    }
}
