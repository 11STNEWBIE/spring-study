/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.Player;
import com.springrecipes.ch03.ch031.court.domain.Reservation;
import com.springrecipes.ch03.ch031.court.domain.SportType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final SportType TENNIS = new SportType(1, "Tennis");
    private static final SportType SOCCER = new SportType(2, "Soccer");
    private final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1", LocalDate.of(2008, 1, 14), 16, new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", LocalDate.of(2008, 1, 14), 20, new Player("Games", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), courtName)).collect(Collectors.toList());
    }
}
