package ch2.r8;

/**
 * 2.8 : 애너테이션을 이용해 POJO 초기화/폐기 커스터마이징하기
 *
 * 어떤 POJO는 사용하기 전에 특정한 초기화 작업을 거쳐야 한다. IoC 컨테이너에서 빈 초기화/폐기 로직을 커스터마이징 해보자
 *
 * ->
 * @Bean 정의부에서 initMethod, destroyMethod 속성 설정.
 *
 * @PostConstruct, @PreDestroy 붙여도 마찬가지이다. 또 스프링에서 @Lazy를 붙이며 느긋한 초기화가 가능하다.
 * @DependsOn으로 빈을 생성하기 전에 다른 빈을 먼저 생성하도록 강제할 수도 있다.
 *
 *
 * */
public class Main {
}
