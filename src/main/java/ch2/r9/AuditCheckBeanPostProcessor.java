package main.java.ch2.r9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * 빈 후처리기는 BeanPostProcessor 인터페이스를 구현한 객체이다.
 * 이 인터페이스를 구현한 빈을 발견하면, 스프링은 자신이 관장하는 모든 빈 인스턴스에 두 메서드를 적용한다.
 *
 *
 * */

@Component      // 클래스 레벨에 @Component를 붙이면 애플리케이션 컨텍스트에 빈 후처리기로 등록된다 -> 컨테이너 안에 있는 다른 빈 인스턴스에 일괄 적용되게 됨
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("In AuditCheckBeanPostProcessor.postProcessBeforeInitialization," +
                "processing bean type : " + bean.getClass());

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
