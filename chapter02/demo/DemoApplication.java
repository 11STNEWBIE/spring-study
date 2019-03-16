package com.example.demo;

import com.example.ch2.p1.Sequence;
import com.example.ch2.p1.SequenceDao;
import com.example.ch2.p2.Product;
import com.example.ch2.p2.ShopConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // 2-1
//        SpringApplication.run(DemoApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.ch2.p1");
//        SequenceDao sequenceDao = context.getBean(SequenceDao.class);
//        System.out.println(sequenceDao.getNextValue("IT"));
//        System.out.println(sequenceDao.getNextValue("IT"));

//        2-2
//        SpringApplication.run(DemoApplication.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
//
//        Product aaa =context.getBean("aaa", Product.class);
//        Product cdrw = context.getBean("cdrw", Product.class);
//
//        System.out.println(aaa);
//        System.out.println(cdrw);

        SpringApplication.run(DemoApplication.class, args);
    }
}
