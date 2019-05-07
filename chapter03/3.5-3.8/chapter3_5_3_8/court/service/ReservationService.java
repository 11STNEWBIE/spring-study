package chapter3_5_3_8.court.service;

import chapter3_5_3_8.court.domain.PeriodicReservation;
import chapter3_5_3_8.court.domain.Reservation;
import chapter3_5_3_8.court.domain.SportType;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);

    void make(Reservation reservation) throws ReservationNotAvailableException;

    List<SportType> getAllSportTypes();

    SportType getSportType(int sportTypeId);

    List<Reservation> findByDate(LocalDate summaryDate);

    void makePeriodic(PeriodicReservation periodicReservation)
            throws ReservationNotAvailableException;
}
