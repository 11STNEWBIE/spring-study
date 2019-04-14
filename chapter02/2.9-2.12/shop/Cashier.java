package com.apress.springrecipes.shop;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;

@Component
public class Cashier implements BeanNameAware {

    @Value("checkout")
    private String fileName;

    @Value("/Users/a1101092/11st")
    private String path;
    private BufferedWriter writer;

    @Override //BeanNameAware 스프링 빈 이름이 POJO인스턴스에 자동 주입
    public void setBeanName(String beanName) {
        this.fileName = beanName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void setPath(String path) {
        this.path = path;
    }

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(path);
        if(!targetDir.exists()){
            targetDir.mkdir();
        }
        File checkoutFile = new File(path, fileName + ".txt");
        if(!checkoutFile.exists()){
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(checkoutFile, true)
        ));
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
        writer.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }

    // 주입된 빈 이름으로 연관 작업을 할 수 있다. fileName을 빈이름으로 설정했기때문에
    // 더이상 setFileName 메서드를 호출할 필요가 없다.
    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        final String path = System.getProperty("java.io.tmpdir") + "cashier";
        Cashier cashier = new Cashier();
        cashier.setPath(path);
        return cashier;
    }

    /*@Autowired
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void checkout(ShoppingCart cart) throws IOException {
        String alert = messageSource.getMessage("alert.inventory.checkout",
                new Object[]{cart.getItems(), new Date()}, Locale.US);
        System.out.println(alert);
    }*/
}
