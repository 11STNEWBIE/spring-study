package ch2.r4;


/**
*   스프링 전용 @Autowired 대신, 자바 표준 애너테이션 @Resource, @Inject로 POJO 자동 연결
*
 *
 *  @Autowired :
 *      - 스프링 기반.
 *
 *  @Resource :
 *      - 이름으로 POJO 레퍼런스 찾아 연결    ; name - type - qualifier
 *      - @Autowired + @Qualifier 역할
 *      - 구문은 가장 단순
 *
 *  @Inject :
 *      - 타입으로 POJO 레퍼런스 찾아 연결 ; type - qualifier - name
* */
public class Main {
}
