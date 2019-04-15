package main.java.ch2.r19;
/**
 * Calculator 객체의 호출 횟수를 기록.
 * 원본 클래스에는 호출 횟수를 담을 카운터 필드가 없기 때문에, 스프링 AOP 인트로덕션을 적용해야 한다.
 *
 * 우선, 카운터 인터페이스를 작성.
 *
 *
 * */

public interface Counter {
    public void increase();
    public int getCount();
}
