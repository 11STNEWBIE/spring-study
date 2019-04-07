package com.apress.springrecipes.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

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

   @Bean
   public Product dvdrw() {
       Disc p2 = new Disc("DVD-RW", 3.0, specialEndofyearDiscountField);
       p2.setCapacity(700);
       return p2;
   }

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

}
