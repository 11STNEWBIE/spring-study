package main.java.ch2.r5;

import main.java.ch2.r5.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @Scope 붙여 POJO 스코프 지정하기
 *
 *
 * @Componenet 같은 annotation을 POJO에 붙이는 것은 빈 생성에 관한 템플릿 정의할 뿐, 실제 빈 인스턴스 정의가 아니다
 *
 * getBean() 메서드로 빈을 요청하거나 다른 빈에서 참조할 때, 스프링은 빈 스코프에 따라 어느 빈 인스턴스를 반환할지 결정해야 한다.
 *
 * 이 때, 기본 스코프 이외의 다른 빈 스코프를 지정할 경우가 있다.
 *  -> @Scope
 *
 *  cf. 스프링의 빈 스코프
 *  - singleton : IoC 컨테이너당 빈 인스턴스 하나를 생성
 *  - prototype : 요청할 때마다 빈 인스턴스 새로 만듬
 *  - request : HTTP 요청당 하나의 빈 인스턴스 생성. 웹 애플리케이션 컨텍스트에만 해당
 *  - session : HTTP 세션당 빈 인스턴스 하나를 생성. 웹 애플리케이션 컨텍스트에만 해당
 *  - globalSession : 전역 HTTP 세션당 빈 인스턴스 하나를 생성. 포털 애플리케이션 컨텍스트에만 해당.
 *
 * */

public class Main {

    public static void main(String[] args) {
        /*  카트에 상품을 넣어가며 테스트해보기 */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        System.out.println("Shopping cart 1 contains " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
        cart2.addItem(dvdrw);
        System.out.println("Shopping cart 2 contains " + cart2.getItems());
        /////////////////////////  ShoppingCart에서 prototype을 지정하지 않으면 두 카트가 동일한 카트로 인식됨


    }

}
