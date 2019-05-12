/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.domain;

import com.springrecipes.ch03.ch031.court.service.ReservationService;
import org.springframework.core.convert.converter.Converter;

public class SportTypeConverter implements Converter<String, SportType> {
    private ReservationService reservationService;

    public SportTypeConverter(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public SportType convert(String source) {
        int sportTypeId = Integer.parseInt(source);
        return reservationService.getSportType(sportTypeId);
    }
}
