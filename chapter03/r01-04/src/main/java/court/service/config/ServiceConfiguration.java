package main.java.court.service.config;

import main.java.court.service.MemberService;
import main.java.court.service.MemberServiceImpl;
import main.java.court.service.ReservationService;
import main.java.court.service.ReservationServiceImpl;
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