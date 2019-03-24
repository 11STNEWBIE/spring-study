package com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.apress.springrecipes.sequence.SequenceGenerator;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com.apress.springrecipes.sequence.*Dao",
                                "com.apress.springrecipes.sequence.*Service"})
        },

        excludeFilters = {
                @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {org.springframework.stereotype.Controller.class})
        }

)

public class SequenceGeneratorConfiguration {
//    public SequenceGenerator sequenceGenerator() {

//        SequenceGenerator seqgen = new SequenceGenerator();
//        seqgen.setPrefix("30");
//        seqgen.setSuffix("A");
//        seqgen.setInitial(100000);
//        return seqgen;
//    }
}