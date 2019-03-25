package com.example.ch2.p6;

import com.example.ch2.p2.Disc;
import com.example.ch2.p2.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan("com.example.ch2")
public class ShopConfiguration {

    @Value("${endofyear.discount}")
    private double specialEndofYearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0, specialEndofYearDiscountField);
        p2.setCapacity(700);
        return p2;
    }
}
