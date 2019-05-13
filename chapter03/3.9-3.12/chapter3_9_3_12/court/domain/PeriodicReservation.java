package chapter3_9_3_12.court.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PeriodicReservation {

    private String courtName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate toDate;

    private int period;
    private int hour;
    private Player player;

    public Player getPlayer() {
        return player;
    }

}
