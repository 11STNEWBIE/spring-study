package main.java.ch2.r12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("global")
@ComponentScan("main.java.ch2.r12")
public class ShopConfigurationGlobal {

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        final String path = System.getProperty("java.io.tmpdir") + "cashier";
        Cashier c1 = new Cashier();
        //c1.setFileName("checkout");       <- beanName 가져와서 설정하는 경우 불필요~
        c1.setPath(path);
        return c1;
    }
}
