package ch2.r4;

import ch2.r3.PrefixGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.inject.Inject;


import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

    //@Resource // 이름으로 찾는다

    // 타입으로 찾는다
    @Inject @DatePrefixAnnotation   // 이제, 주입 지점에 붙여서 타입이 여럿이어도 더 이상 모호해질 일 없다
    private PrefixGenerator prefixGenerator;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {}

    public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
        this.prefixGenerator = prefixGenerator;
        this.suffix = suffix;
        this.initial = initial;
    }

    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        String builder = prefixGenerator.getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }

    @Autowired
    public void myOwnCustomerInjectionName(
            @Qualifier("datePrefixGenerator") PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

}
