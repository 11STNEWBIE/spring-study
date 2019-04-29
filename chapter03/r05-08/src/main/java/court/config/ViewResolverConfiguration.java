package court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer {

    /**
     * Recipe 3-7 콘텐트 협상 구성.
     * 확장자가 URL에 명시되지 않은 경우, HTTP Accept 헤더를 조사할 수 있지만, 더 깔끔한 방법!
     * 콘텐트 협상 기능이 제대로 작동하려면 ContentNegotiatingViewResolver의 우선순위를 가장 높게 설정해야한다.
     * 그 이유는, 스스로 뷰를 해석하지 않고, 다른 리졸버에게 그 작업을 넘기기 때문이다.
     *
     * ContentNegotiatingViewResolver가 미디어 타입을 결정하는 과정은 다음과 같다.
     * 1) 요청 경로에 포함된 확장자를 ContentNegotiatingManager 빈 구성시 지정한 mediaTypes 맵을 이용해, 기본 미디어 타입(text/html)과 견준다.
     * 2) 요청 경로에 확장자는 있지만 기본 미디어 타입과 매치되는 확장자가 없으면, JAF의 FileTypeMap을 이용해 확장자의 미디어 타입을 결정한다.
     * 3) 요청 경로에 확장자가 없으면,HTTP Accept 헤더를 활용한다.
     *
     * 그래서 /reservationSummay.xml 요청은 2)에서 확정,
     * /reservationSummary 요청은 Accept 헤더까지 확인되어야 한다.
     * */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediatypes = new HashMap<>();
        mediatypes.put("html", MediaType.TEXT_HTML);
        mediatypes.put("pdf", MediaType.valueOf("application/json"));
        mediatypes.put("xls", MediaType.valueOf("application/vnd.ms-excel"));
        mediatypes.put("xml", MediaType.APPLICATION_XML);
        mediatypes.put("json", MediaType.APPLICATION_JSON);
        configurer.mediaTypes(mediatypes);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {

        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setContentNegotiationManager(contentNegotiationManager);
        return viewResolver;
    }
    ////////////////////////////////////////////////////

    @Bean
    public ResourceBundleViewResolver viewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setBasename("court-views");
        return viewResolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(2);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}



/**
 * 방법1 : InternalResourceViewResolver 활용
 *
 * 템플릿의 이름과 위치에 뷰를 직접 매핑한다.
 *
 * ex> welcome -> /WEB-INF/jsp/welcome.jsp
 *
 *
 *
 * 방법2 : XML 구성 파일에 따라 뷰 해석
 *
 * XmlViewResolver는 기본적으로 /WEB-INF/views.xml 파일에서 뷰 빈을 읽는다.
 * location프로퍼티로 위치를 달리할 수도 있다.
 *
 * ex>
 * @Bean
 * public XmlViewResolver viewResolver {
 *      XmlViewResolver viewResolver = new XmlViewResolver();
 *      viewResolver.setLocation(resourceLoader.getResource("/WEB-INF/court-views.nl"));
 *      return viewResolver;
 * }
 *xml에 클래스명, 프로퍼티를 설정하여 각 뷰를 일반 스프링 빈으로 선언할 수 있다.
 *
 *
 * 방법3 :
 *
 * 방법4 :
 *
 * */