/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @NotNull
    @Size(min = 4)
    private String courtName;
    @NotNull
    private LocalDate date;
    @Min(9)
    @Max(21)
    private int hour;
    @Valid
    private Player player;
    @NotNull
    private SportType sportType;
}
