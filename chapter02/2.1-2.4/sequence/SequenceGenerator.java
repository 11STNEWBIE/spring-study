package com.apress.springrecipes.sequence;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class SequenceGenerator {

    @Autowired
    @Qualifier("datePrefixGenerator")
    private PrefixGenerator prefixGenerator;

    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }

    @Autowired
    public void setPrefixGenerator(PrefixGenerator prefixGenerator){
        this.prefixGenerator = prefixGenerator;
    }

    public void setPrefix(DatePrefixGenerator datePrefixGenerator) {
    }
}
