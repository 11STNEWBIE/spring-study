package court.service.config;

import court.service.MemberService;
import court.service.MemberServiceImpl;
import court.service.ReservationService;
import court.service.ReservationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ReservationService reservationService() {
        return new ReservationServiceImpl();
    }

    @Bean
    public MemberService memberService() { return new MemberServiceImpl();}
}