package main.java.ch2.r10;

/**
 * 레시피 2.10 : 팩토리(1)정적 메서드, 2)인스턴스 메서드, 3)스프링 FactoryBean)로 POJO 생성하기
 *
 * 객체 생성 로직을 정적 메서드나 다른 객체 인스턴스 메서드 내부로 캡슐화해보자. 객체가 필요한 클라이언트는 생성 로직은 알 필요 없이 메서드를 호출해 쓰면 그만이다.
 *
 * ->
 * 스프링 팩토리 빈을 이용해서, IoC 컨테이너에 POJO 인스턴스를 만들자.
 *
 * IoC 컨테이너 안에서 팩토리 빈은 다른 빈을 찍어내는 공장 역할을 하며 개념은 팩토리 메서드와 비슷하지만,
 *
 * 빈 생성 도중 IoC 컨테이너가 식별할 수 있는 스프링 전용 빈이다.
 *
 *
 * */

public class Main {
}