/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.service;

import com.springrecipes.ch03.ch031.court.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String courtName);
}
