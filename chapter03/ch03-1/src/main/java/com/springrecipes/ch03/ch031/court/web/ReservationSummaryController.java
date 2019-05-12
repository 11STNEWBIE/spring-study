/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.web;

import com.springrecipes.ch03.ch031.court.config.ReserVationWebException;
import com.springrecipes.ch03.ch031.court.domain.Reservation;
import com.springrecipes.ch03.ch031.court.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservationSummary*")
public class ReservationSummaryController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationSummaryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String generateSummary(@RequestParam(required = true, value = "date") String selectedDate, Model model) {
        List<Reservation> reservations = Collections.emptyList();

        try {
            Date summaryDate = new SimpleDateFormat("yyyy-MM-dd").parse(selectedDate);
            reservationService.findByDate(LocalDate.from((TemporalAccessor) summaryDate));
        } catch (ParseException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            try {
                throw new ReserVationWebException("Invalid date format for reservation summary", new Date(), sw.toString());
            } catch (ReserVationWebException ex) {
                ex.printStackTrace();
            }
        }

        model.addAttribute("reservations", reservations);
        return "reservationSummary";
    }

}
