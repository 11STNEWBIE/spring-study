package chapter2.sub9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
//
//        SequenceDao sequenceDao = context.getBean(SequenceDao.class);
//
//        System.out.println(sequenceDao.getNextValue("IT"));
//        System.out.println(sequenceDao.getNextValue("IT"));
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("global", "winter");
        context.scan("chapter2.sub5");
        context.refresh();
    }
}


/*

public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        System.out.println(aaa);
        System.out.println(cdrw);
    }
}


 */
