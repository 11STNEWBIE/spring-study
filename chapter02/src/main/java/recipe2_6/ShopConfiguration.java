package recipe2_6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import recipe2_2.domain.Disc;
import recipe2_2.domain.Product;

@Configuration
@PropertySource(("classpath:discount.properties"))
@ComponentScan
public class ShopConfiguration {

    @Value("${endofyear.discount:0}")
    private double specialEndofYearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer
        propertySourcePlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc();
        //Disc p2 = new Disc("DVD-RW", 3.0, specialEndofYearDiscountField);
        p2.setCapacity(700);
        return p2;
    }

}
