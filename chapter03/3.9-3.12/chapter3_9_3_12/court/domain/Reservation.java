package chapter3_9_3_12.court.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reservation {
    private String courtName;
    private LocalDate date;
    private int hour;
    private Player player;
    private SportType sportType;

    public Reservation(){

    }
    public Reservation(String courtName, LocalDate date, int hour, Player player, SportType sportType) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
        this.player = player;
        this.sportType = sportType;
    }
}
