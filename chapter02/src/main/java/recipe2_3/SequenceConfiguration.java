package recipe2_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import recipe2_1_1.sequence.SequenceGenerator;

@Configuration
public class SequenceConfiguration {

//    @Bean
//    public DatePrefixGenerator datePrefixGenerator() {
//        DatePrefixGeneraotr dpg = new DatePrefixGenerator();
//        dpg.setPattern("yyyyMMdd");
//        return dpg;
//    }
//
//    @Bean
//    public SequenceGenerator sequenceGenerator() {
//        SequenceGenerator sequence = new SequenceGenerator();
//        sequence.setInitial(100000);
//        sequence.setSuffix("A");
//        sequence.setPrefixGenerator(datePrefixGenerator());
//        return sequence;
//    }
}
