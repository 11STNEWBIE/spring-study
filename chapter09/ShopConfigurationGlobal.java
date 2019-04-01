package chapter2.sub9;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

@Configuration
@Profile("global")
@ComponentScan("chapter2.sub9")
public class ShopConfigurationGlobal {

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
}
