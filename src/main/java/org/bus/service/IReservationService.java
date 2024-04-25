package org.bus.service;

import org.bus.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface IReservationService {
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public Reservation deleteReservation(Integer reservationId);
    public Reservation viewReservation(Integer reservationId);
    public List<Reservation>viewAllReservation();
    public List<Reservation>getAllReservation(LocalDate date);
}
