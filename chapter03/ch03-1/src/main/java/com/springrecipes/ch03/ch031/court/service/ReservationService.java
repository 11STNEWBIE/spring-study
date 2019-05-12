/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.PeriodicReservation;
import com.springrecipes.ch03.ch031.court.domain.Reservation;
import com.springrecipes.ch03.ch031.court.domain.SportType;
import com.springrecipes.ch03.ch031.exceptions.ReservationNotAvailableException;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);

    void make(Reservation reservation) throws ReservationNotAvailableException;

    List<SportType> getAllSprotTypes();

    SportType getSportType(int sprotTypeId);

    void makePeriodic(PeriodicReservation periodicReservation) throws ReservationNotAvailableException;
}
