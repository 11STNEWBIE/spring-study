package com.apress.springrecipes.shop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// 빈 후처리기는 BeanPostProcessor 인터페이스를 구현한 객체입니다.
@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("In AuditCheckBeanPostProcessor.postProcessBeforeInitialization"
                + "processiong bean type" + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
