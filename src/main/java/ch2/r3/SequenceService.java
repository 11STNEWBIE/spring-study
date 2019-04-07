package main.java.ch2.r3;

import main.java.ch2.r1.Sequence;
import main.java.ch2.r1.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
* 서비스 객체는 내부적으로 DAO와 연동하여 시퀀스 생성 요청 처리
*
* */
@Component  /** @Component : 스프링 빈에 등록. 빈 이름은 sequenceService  */
public class SequenceService {

    @Autowired
    private SequenceDao sequenceDao;
    /** SequenceDao 빈(SequenceDaoImpl)이 이 프로퍼티에 자동 연결
        cf. 배열형 프로퍼티에 @Autowired 붙이면, 스프링은 매치된 빈을 모두 찾아 자동 연결.
     선언한 인터페이스 및 클래스 타입 호환되는 빈이 여럿 있어도 배열에 자동 추가된다.

        cf2. Map에 @Autowired를 붙이면, 스프링은 타입 호환되는 빈을 모두 찾아,
        빈 이름이 키인 맵에 추가한다.
        ; ex> Map<String, PrefixGenerator>

        * @Autowired(required=false) 이면, 프로퍼티에 해당하는 빈을 찾지 못해도 그냥 지나친다.


        * @Autowired는 메서드 인수의 이름과 개수에 상관없이 적용 가능.
            * 스프링은 각 메서드 인수형과 호환되는 빈을 찾아 연결한다.

        * 생성자에도 붙일 수 있다.
            * 스프링 4.3부터는 생성자가 하나뿐인 클래스의 생성자는 자동 연결이 기본이므로 굳이 붙이지 않아도 된다.

        * 모호성 해결
            * A라는 interface가 있고, B, C, D가 구현체라고 하자. 그러면 모호하여, NoUniqueBeanDefinitionException
            * 이 때, @Primary를 붙어 후보 빈을 명시한다.
            * 혹은 Qualifier 에 이름을 주어, 후보 빈을 명시할 수도 있다.

     */

    public void setSequenceDao(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}
