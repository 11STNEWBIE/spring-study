/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

package com.springrecipes.ch03.ch031.court.web;

import com.springrecipes.ch03.ch031.court.config.ReservationValidator;
import com.springrecipes.ch03.ch031.court.domain.Player;
import com.springrecipes.ch03.ch031.court.domain.Reservation;
import com.springrecipes.ch03.ch031.court.domain.SportType;
import com.springrecipes.ch03.ch031.court.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
@RequiredArgsConstructor
public class ReservationFormController {
    @Autowired
    private ReservationService reservationService;

    ReservationValidator reservationValidator;

    public ReservationFormController(ReservationValidator reservationValidator) {
        this.reservationValidator = reservationValidator;
    }

    @ModelAttribute("sprotTypes")
    public List<SportType> populateSportTypes() {
        return reservationService.getAllSprotTypes();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam(required = false, value = "username") String username, Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        reservation.setPlayer(new Player(username, null));
        return "reservationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("reservation") @Validated Reservation reservation, BindingResult result, SessionStatus status) {
        if(result.hasErrors()) {
            return "reservationForm";
        } else {
            reservationService.make(reservation);
            status.setComplete();
            return "redirect:reservationSuccess";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(reservationValidator);
    }
}
