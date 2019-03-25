package ch2.r6.config;


import ch2.r6.BannerLoader;
import ch2.r6.Disc;
import ch2.r6.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("ch2.r6")
public class ShopConfiguration {

    @Value("classpath:banner.txt")  // classpath:ch2/r6/resources/banner.txt
    private Resource banner;

    // 파일에서 가져온 프로퍼티값을 담을 자바 변수
    @Value("${endofyear.discount:0}")  // 매치되는 키가 있으면 그 값을 빈 프로퍼티 값으로 할당하고, 찾지 못하면 default_value 할당
    private double specialEndofyearDiscountField;



    /* configuring explicit embedded value resolver ;
        this way is only required if you need to customize configuration such as placeholder syntax */
    // 프로퍼티 파일을 로드하기 위해 Bean으로 선언.
    @Bean
    public static PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0, specialEndofyearDiscountField);   // discount 프퍼티 값으로 설정
        p2.setCapacity(700);
        return p2;
    }


    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader b1 = new BannerLoader();
        b1.setBanner(banner);
        return b1;
    }
}
