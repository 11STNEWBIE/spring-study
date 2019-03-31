package ch2.r10;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * 팩토리 빈은 제네릭 클래스 AbstractFactoryBean<T>를 상속하고,
 * createInstance() 메서드를 오버라이드해서 대상 빈 인스턴스를 생성한다.
 * 또 자동 연결 기능이 작동하도록 getObjectType() 메서드로 대상 빈 타입을 반환한다.
 * */

public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

    private Product product;
    private double discount;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Class<?> getObjectType() {
        return product.getClass();
    }

    @Override
    protected Product createInstance() throws Exception {
        product.setPrice(product.getPrice() * (1 - discount));
        return product;
    }
}
