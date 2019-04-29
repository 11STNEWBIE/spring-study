package domain;

import java.time.LocalDate;

public class Reservation {

    private String courtName;
    private LocalDate date;
    private int hour;
    private Player player;
    private SportType sportType;

    public Reservation(String courtName, LocalDate date, int hour, Player player, SportType sportType) {
        this.courtName = courtName;
        this.date = date;
        this.hour = hour;
        this.player = player;
        this.sportType = sportType;
    }

    public String getCourtName() {
        return courtName;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public Player getPlayer() {
        return player;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }
}
