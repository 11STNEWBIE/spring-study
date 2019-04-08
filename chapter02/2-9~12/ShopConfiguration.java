package chapter2.sub9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("chapter2.sub5")
public class ShopConfiguration {

    @Value("$(endofyear.disount:0)")
    private double specialEndofyearDiscountField;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        String path = System.getProperty("java.io.tmpdir") + "/cashier";
        Cashier c1 = new Cashier();
        c1.setFileName("checkout");
        c1.setPath(path);
        return c1;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }

//    @Bean
//    public Product aaa() {
//        Battery p1 = new Battery();
//        p1.setName("AAA");
//        p1.setPrice(2.5);
//        p1.setRechargeable(true);
//        return p1;
//    }
//
//    @Bean
//    public Product cdrw() {
//        Disc p2 = new Disc("CD-RW", 1.5);
//        p2.setCapacity(700);
//        return p2;
//    }
//
//    @Bean
//    public Product dvdrw() {
//        Disc p2 = new Disc("DVD-RW", 3.0);
//        p2.setCapacity(700);
//        return p2;
//    }

//    @Bean
//    public Product aaa() {
//        return ProductCreator.createProduct("aaa");
//    }
//
//    @Bean
//    public Product cdrw() {
//        return ProductCreator.createProduct("cdrw");
//    }
//
//    @Bean
//    public Product dvdrw() {
//        return ProductCreator.createProduct("dvdrw");
//    }

    @Bean
    public Product aaa() {
        return productCreatorFactory().createProduct("aaa");
    }

    @Bean
    public Product cdrw() {
        return productCreatorFactory().createProduct("cdrw");
    }

    @Bean
    public Product dvdrw() {
        return productCreatorFactory().createProduct("dvdrw");
    }

    @Bean
    public ProductCreator productCreatorFactory() {
        ProductCreator factory = new ProductCreator();
        Map<String, Product> products = new HashMap<>();
        products.put("aaa", new Battery("AAA", 2.5));
        products.put("cdrw", new Disc("CD-RW", 1.5));
        products.put("aaa", new Disc("dvdrw", 3.0));
        factory.setProducts(products);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanAAA() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setDiscount(0.2);
        factory.setProduct(aaa());
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanCDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setDiscount(0.1);
        factory.setProduct(cdrw());
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanDVDRW() {
        DiscountFactoryBean factory = new DiscountFactoryBean();
        factory.setDiscount(0.1);
        factory.setProduct(dvdrw());
        return factory;
    }
}
