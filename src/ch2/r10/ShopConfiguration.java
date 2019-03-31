package ch2.r10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("ch2.r10")
public class ShopConfiguration {

    /**
     * 일반 자바 구문으로 정적 팩토리 메서드를 호출해 POJO를 생성한다.
     * */
    @Bean
    public Product aaa() {
        return ProductCreator.createProduct("aaa");
    }

    @Bean
    public Product cdrw() {
        return ProductCreator.createProduct("cdrw");
    }

    @Bean
    public Product dvdrw() {
        return ProductCreator.createProduct("dvdrw");
    }

    /**
     * ProductCreator 를 Bean으로 선언해서, 팩토리값을 인스턴스화하고
     *
     * 이 팩토리의 퍼사드 역할을 하는 두 번째 빈을 선언한다
     *
     * 마지막으로 팩토리를 호출하고 createProduct() 메서드를 호출해서 다른 빈들을 인스턴스화한다.
     * */
    @Bean
    public ProductCreator productCreatorFactory() {
        ProductCreator factory = new ProductCreator();
        Map<String, Product> products = new HashMap<>();
        products.put("aaa", new Battery("AAA", 2.5));
        products.put("cdrw", new Disc("CD-RW", 1.5));
        products.put("dvdrw", new Disc("DVD-RW", 3.0));
        factory.setProducts(products);
        return factory;
    }

    @Bean
    public Product aaa2() {
        return productCreatorFactory().createProduct2("aaa");
    }

    @Bean
    public Product cdrw2() {
        return productCreatorFactory().createProduct2("cdrw");
    }

    @Bean
    public Product dvdrw2() {
        return productCreatorFactory().createProduct2("dvdrw");
    }


    /**
     * 팩토리 빈을 통한 빈 생성
     *
     * - (참고) 여기서 factory Product 세터 메소드에서 aaa(), cdrw() 와 같은 메서드는 꼭 정적 메서드를 타지 않아도 됨.
     * 그냥, 단순히 Bean을 가져오는 기본 메소드인데 수정안했을 뿐 :)
     * */

    @Bean
    public DiscountFactoryBean discountFactoryBeanAAA() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(aaa());
        factory.setDiscount(0.2);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanCDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(cdrw());
        factory.setDiscount(0.1);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanDVDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setProduct(dvdrw());
        factory.setDiscount(0.1);
        return factory;
    }
}
