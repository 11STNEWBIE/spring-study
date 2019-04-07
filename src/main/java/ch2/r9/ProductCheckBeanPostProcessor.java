package main.java.ch2.r9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 특정 타입의 빈만 후처리기를 적용하려는 경우!
 *
 * -> 인스턴스 타입을 체크하는 필터를 이용해 원하는 빈에만 후처리 로직을 적용할 수 있다.
 *
 * Product형 빈 인스턴스에만 적용하는 빈 후처리기를 만들어보자~
 *
 * */

/**
 * cf) 두 메서드 모두 빈 인스턴스를 반환한다.
 * 다른 말로는, 원본 빈을 다른 인스턴스로 바꿔치기할 수도 있다는 것
 * */

@Component
public class ProductCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Product) {
            String productName = ((Product) bean).getName();
            System.out.println("In ProductCheckBeanPostProcessor.postProcessBeforeInitialization, " +
                    "processing Product: " + productName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
