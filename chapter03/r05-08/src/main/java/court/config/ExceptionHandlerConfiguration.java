package court.config;

import court.service.ReservationNotAvailableException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

@Configuration
public class ExceptionHandlerConfiguration implements WebMvcConfigurer {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(handlerExceptionResolver());
    }

    /**
     * 웹 어플리케이션 컨텍스트에서 발생한 예외를 매핑.
     *
     * */

    @Bean
    public SimpleMappingExceptionResolver handlerExceptionResolver() {
        Properties exceptionMapping = new Properties();
        /** ReservationNotAvailableException class -> "reservationNotAvailable" mapping */
        exceptionMapping.setProperty(ReservationNotAvailableException.class.getName(), "reservationNotAvailable");

        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        exceptionResolver.setExceptionMappings(exceptionMapping);
        /**  exceptionMapping에 매핑되지 않은 예외가 발생하면 표시할 기본 뷰 이름 : "error"*/
        exceptionResolver.setDefaultErrorView("error");
        return exceptionResolver;
    }
}
