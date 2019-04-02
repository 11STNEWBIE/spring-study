package com.apress.spring.ch021;

import com.apress.spring.ch021.domain.Product;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Product) {
            String productName = ((Product) bean).getName();
            System.out.println("In ProductCheckBeanPostProcessor. postProcessBeforeInitailization, processing Product: " + productName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Product) {
            String productName = ((Product)bean).getName();
            System.out.println("In ProductCheckBeanPostProcessor. postProcessAfterInitialization, processing Product : " + productName);
        }
        return bean;
    }
}
