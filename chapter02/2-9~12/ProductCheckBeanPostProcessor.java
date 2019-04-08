package chapter2.sub9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProductCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Product) {
            String productName = ((Product) bean).getName();
            System.out.println("In productCheckbean.postProcessorBefore~, processing Product: " + productName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Product) {
            String productName = ((Product) bean).getName();
            System.out.println("In productCheckbean.postProcessorAfter~, processing Product: " + productName);
        }
        return bean;
    }
}
