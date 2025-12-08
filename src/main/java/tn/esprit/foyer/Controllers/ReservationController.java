package tn.esprit.foyer.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.services.IReservationService;
import tn.esprit.foyer.services.ReservationServiceImp;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/ajouterReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PostMapping("/ajouterReservations")
    public List<Reservation> addAllReservations(@RequestBody List<Reservation> reservations) {
        return reservationService.addAllReservations(reservations);
    }

    @GetMapping("/getById/{idReservation}")
    public Reservation getReservation(@PathVariable Long idReservation) {
        return reservationService.getReservation(idReservation);
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "Réservation supprimée avec succès";
    }
    @PostMapping("/addWithEtudiants")
    public Reservation ajouterAvecEtudiants(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservationAvecEtudiants(reservation);
    }
}