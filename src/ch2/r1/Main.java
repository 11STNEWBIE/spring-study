package ch2.r1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("ch2.one");
        SequenceGenerator generator = context.getBean(SequenceGenerator.class);

        SequenceDao dao = context.getBean(SequenceDao.class);

        SequenceDaoImpl daoImpl = context.getBean("sequenceDao",SequenceDaoImpl.class);

        System.out.println(dao == daoImpl);
        System.out.println(dao.equals(daoImpl));

        System.out.println(dao.getNextValue("IT"));

        System.out.println(daoImpl.getNextValue("IT"));
    }
}
