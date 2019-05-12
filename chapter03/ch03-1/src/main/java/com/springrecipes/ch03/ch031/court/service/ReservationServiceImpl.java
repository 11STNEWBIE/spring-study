/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.PeriodicReservation;
import com.springrecipes.ch03.ch031.court.domain.Player;
import com.springrecipes.ch03.ch031.court.domain.Reservation;
import com.springrecipes.ch03.ch031.court.domain.SportType;
import com.springrecipes.ch03.ch031.exceptions.ReservationNotAvailableException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void make(Reservation reservation) throws ReservationNotAvailableException {
        long count = reservations.stream().filter(made -> Objects.equals(made.getCourtName(), reservation.getCourtName()))
                .filter(made -> Objects.equals(made.getDate(), reservation.getDate()))
                .filter(made -> made.getHour() == reservation.getHour())
                .count();
        if (count > 0) {
            throw new ReservationNotAvailableException(reservation.getCourtName(), reservation.getDate(), reservation.getHour());
        } else {
            reservations.add(reservation);
        }
    }

    @Override
    public List<SportType> getAllSprotTypes() {
        return Arrays.asList(TENNIS, SOCCER);
    }

    @Override
    public SportType getSportType(int sprotTypeId) {
        switch (sprotTypeId) {
            case 1:
                return TENNIS;
            case 2:
                return SOCCER;
            default:
                return null;
        }
    }

    @Override
    public void makePeriodic(PeriodicReservation periodicReservation) throws ReservationNotAvailableException{
        LocalDate fromDate = LocalDate.from((TemporalAccessor) periodicReservation.getFromDate());

        while(fromDate.isBefore(LocalDate.from((TemporalAccessor) periodicReservation.getToDate()))) {
            Reservation reservation = new Reservation();
            reservation.setCourtName(periodicReservation.getCourtName());
            reservation.setDate(fromDate);
            reservation.setHour(periodicReservation.getHour());
            reservation.setPlayer(periodicReservation.getPlayer());
            make(reservation);

            fromDate = fromDate.plusDays(periodicReservation.getPeriod());
        }

    }
}
