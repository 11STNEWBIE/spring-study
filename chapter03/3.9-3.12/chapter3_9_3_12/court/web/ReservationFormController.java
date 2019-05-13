package chapter3_9_3_12.court.web;

import chapter3_9_3_12.court.domain.Player;
import chapter3_9_3_12.court.domain.Reservation;
import chapter3_9_3_12.court.domain.ReservationValidator;
import chapter3_9_3_12.court.domain.SportType;
import chapter3_9_3_12.court.service.ReservationNotAvailableException;
import chapter3_9_3_12.court.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

    private final ReservationService reservationService;
    private final ReservationValidator validator;

    public ReservationFormController(ReservationService reservationService,
                                     ReservationValidator validator) {
        this.reservationService = reservationService;
        this.validator = validator;
    }

    @ModelAttribute("sportTypes")
    public List<SportType> populateSportTypes() {
        return reservationService.getAllSportTypes();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(@RequestParam(required = false, value = "username") String username, Model model) {
        Reservation reservation = new Reservation();
        reservation.setPlayer(new Player(username, null));
        model.addAttribute("reservation", reservation);
        return "reservationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("reservation") @Validated Reservation reservation,
            BindingResult result, SessionStatus status) {
            if (result.hasErrors()) {
                return "reservationForm";
            }else {

                reservationService.make(reservation);
                status.setComplete();

                return "redirect:reservationSuccess";
            }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @ExceptionHandler(ReservationNotAvailableException.class)
    public String handle(ReservationNotAvailableException ex) {
        return "reservationNotAvailable";
    }

    @ExceptionHandler
    public String handleDefault(Exception e) {
        return "error";
    }

}