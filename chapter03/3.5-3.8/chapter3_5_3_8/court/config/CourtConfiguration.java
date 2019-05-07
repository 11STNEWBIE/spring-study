package chapter3_5_3_8.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("chapter3_1_3_4.court")
@EnableWebMvc
public class CourtConfiguration {

    // �� �ؼ��� �⺻����. �丮������ �̿��� �� �̸��� Ư�� ���ø����̼� ���丮�� ������Ŵ.
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
