package court.web;

import court.service.ReservationNotAvailableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 범용적 예외 처리 메서드 처리하기 위한 별도 클래
 * 애플리케이션 컨텍스트에 존재하는 모든 컨트롤러에 적용된다.
 *
 * */

@ControllerAdvice  // 모든 컨트롤러에 어드바이스를 제공한다.
public class ExceptionHandlingAdvice {

    @ExceptionHandler(ReservationNotAvailableException.class)
    public String handle(ReservationNotAvailableException ex) {
        return "reservationNotAvailable";
    }

    @ExceptionHandler
    public String handleDefault(Exception e) {
        return "error";
    }
}