package court.service;


import court.domain.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);


}

