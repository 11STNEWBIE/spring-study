package main.java.ch2.r11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"summer", "winter"})
/**
 프로파일은 속성값으로 "" 안에 적되, 이름이 여러 개면 csv 형식으로 {}로 감싸 적는다 */
public class ShopConfigurationSumWin {

    @Bean
    public Product aaa() {
        Battery p1 = new Battery();
        p1.setName("AAA");
        p1.setPrice(2.0);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.0);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 2.5);
        p2.setCapacity(700);
        return p2;
    }
}
