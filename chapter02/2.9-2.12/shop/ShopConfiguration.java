package com.apress.springrecipes.shop;

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
@ComponentScan("com.apress.springrecipes.shop")
@PropertySource("classpath:message_en_US.properties")
public class ShopConfiguration {

   @Value("${endofyear.discount:0}")
   private double specialEndofyearDiscountField;

   @Value("classpath:banner.txt")
   private Resource banner;

   @Bean
   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
   }

   /*@Bean
   public Product dvdrw() {
       Disc p2 = new Disc("DVD-RW", 3.0, specialEndofyearDiscountField);
       p2.setCapacity(700);
       return p2;
   }*/

   @Bean
    public BannerLoader bannerLoader() {
       BannerLoader b1 = new BannerLoader();
       b1.setBanner(banner);
       return b1;
   }

   @Bean //messageSource
    public ReloadableResourceBundleMessageSource messageSource() {
       ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
       messageSource.setBasenames("classpath:message");
       messageSource.setCacheSeconds(1);
       return messageSource;
   }

   @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
       String path = System.getProperty("java.io.tmpdir") + "/cashier";
       Cashier c1 = new Cashier();
       c1.setFileName("checkout");
       c1.setPath(path);
       return c1;
   }

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
    public Product aaa() {
       return  productCreatorFactory().createProduct("aaa");
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
