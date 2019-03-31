package recipe2_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import recipe2_2.config.ShopConfiguration;
import recipe2_2.domain.Product;

public class Main {
    public static void main(String args[]) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);

        System.out.println(aaa);
        //System.out.println(cdrw);
    }
}