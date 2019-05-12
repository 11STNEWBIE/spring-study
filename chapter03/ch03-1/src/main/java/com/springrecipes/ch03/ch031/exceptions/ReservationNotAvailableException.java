/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationNotAvailableException extends RuntimeException {
    private String courtName;
    private Date date;
    private int hour;

    public ReservationNotAvailableException(String courtName, LocalDate date, int hour) {

    }
}
