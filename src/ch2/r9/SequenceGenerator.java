package ch2.r9;

import org.springframework.beans.factory.annotation.Required;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Required로 프로퍼티 검사하기
 * - 특정 빈 프로퍼티가 설정되었는지 체크하고 싶은 경우, 커스텀 후처리기를 작성하고 해당 프로퍼티에 @Required를 붙인다
 *
 * 스프링 빈 후처리기 RequiredAnnotationBeanPostProcessor는 @Required를 붙인 프로퍼티값이 설정됐는지 살핀다.
 *
 * 그러나 프로파티 값의 설정 여부만 체크할 뿐, 그 값이 null인지 아니면 다른 값인지는 신경 쓰지 않는다
 *
 *
 *
 * prefixGenerator, suffix는 시퀀스 생성기의 필수 프로퍼티이므로 다음 코드처럼 해당 세터 메서드에 @Required를 붙인다
 *
 *
 * */
public class SequenceGenerator {

    private PrefixGenerator prefixGenerator;
    private String suffix;

    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {}

    // TODO : setter 가 불리지는 않았지만 생성자로 세팅된 경우도 에러날까?
    public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
        this.prefixGenerator = prefixGenerator;
        this.suffix = suffix;
        this.initial = initial;
    }

    // Required를 붙인 프로퍼티는 스프링이 감지해서, 값의 존재 여부를 조사하고 프로퍼티 값이 없으면 BeanInitializationException 예외 던진다.

    @Required
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {

        this.prefixGenerator = prefixGenerator;
    }

    @Required
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

}

