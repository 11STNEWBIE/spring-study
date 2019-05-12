/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.config;

import com.springrecipes.ch03.ch031.court.domain.SportTypeConverter;
import com.springrecipes.ch03.ch031.court.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.springrecipes.ch03.ch031.court.web")
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private ReservationService reservationService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SportTypeConverter(reservationService));
    }
}
