package tn.esprit.foyer.services;

import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    public Reservation addReservation(Reservation reservation);
    public Reservation getReservation(Long idReservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(Long idReservation);
    public List<Reservation> getReservations();
    public List<Reservation>addListReservation(List<Reservation> reservations);
    public List<Reservation> addAllReservations(@RequestBody List<Reservation> reservations);
    public List<Reservation> getAllReservations();
    public Reservation ajouterReservationAvecEtudiants(Reservation reservation);
}
