package com.springstudy.ch02.runner;

import com.springstudy.ch02.sequence.SequenceDao;
import com.springstudy.ch02.sequence.SequenceGenerator;
import com.springstudy.ch02.shop.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    private final SequenceGenerator sequenceGenerator;

    private final SequenceDao sequenceDao;

    @Autowired
    @Qualifier("aaa")
    private Product aaa;

    @Autowired
    @Qualifier("cdrw90")
    private Product cdrw;

    @Autowired
    public ApplicationRunner(SequenceGenerator sequenceGenerator, SequenceDao sequenceDao) {
        this.sequenceGenerator = sequenceGenerator;
        this.sequenceDao = sequenceDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(aaa.toString());
        System.out.println(cdrw.toString());
    }
}
