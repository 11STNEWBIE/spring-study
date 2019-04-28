package court.web;

import court.config.InterceptorConfiguration;
import court.service.config.ServiceConfiguration;
import court.web.config.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * CourtServletContainerInitializer, META-INF/services/javax.servlet.ServletContainerInitializer
 * 두 파일로 설정하던 것을, 단 하나의 클래스 파일에서 설정 가능.
 *
 * */

public class CourtApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * ContextLoaderListener가 생성한 애플리케이션 컨텍스트를 설정하는데 사용.
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ServiceConfiguration.class};
    }

    /**
     * 로드할 구성 클래스 지정
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{InterceptorConfiguration.class};
    }

    /**
     * 매핑 설정
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/", "/welcome"};
    }
}