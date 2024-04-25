package org.bus.service;

import org.bus.model.Reservation;
import org.bus.repository.BusRepository;
import org.bus.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements IReservationService{

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BusRepository busRepository;
    
    @Override
    public Reservation addReservation(Reservation reservation) {
    	busRepository.save(reservation.getBus());
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation deleteReservation(Integer reservationId) {
        Optional<Reservation> opt = reservationRepository.findById(reservationId);
        if (opt.isPresent()){
            Reservation reservation = opt.get();
            reservationRepository.delete(reservation);
            return reservation;
        }
        return null;
    }

    @Override
    public Reservation viewReservation(Integer reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public List<Reservation> viewAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getAllReservation(LocalDate date) {
        return reservationRepository.findByReservationDate(date);
    }
}
