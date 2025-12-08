package tn.esprit.foyer.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.repositories.EtudiantRepository;
import tn.esprit.foyer.repositories.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ReservationServiceImp implements IReservationService{
    @Autowired
    ReservationRepository Rerep;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        return Rerep.save(reservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return Rerep.findById(idReservation).get();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return Rerep.save(reservation);
    }

    @Override
    public void deleteReservation(Long idReservation) {
        Rerep.deleteById(idReservation);
    }

    @Override
    public List<Reservation> getReservations() {

        return (List<Reservation>)Rerep.findAll();

    }

    @Override
    public List<Reservation> addListReservation(List<Reservation> reservations) {

        return (List<Reservation>)Rerep.saveAll(reservations);
    }

    @Override
    public List<Reservation> addAllReservations(List<Reservation> reservations) {
        return (List<Reservation>) Rerep.saveAll(reservations);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>)Rerep.findAll();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationAvecEtudiants(Reservation reservation) {

        List<Etudiant> etudiants = new ArrayList<>();

        for (Etudiant e : reservation.getEtudiant()) {
            Etudiant et = etudiantRepository.findById(e.getIdEtudiant()).get();
            etudiants.add(et);
        }

        reservation.setEtudiant(etudiants);

        return Rerep.save(reservation);
    }
}
