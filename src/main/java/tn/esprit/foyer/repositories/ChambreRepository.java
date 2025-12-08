package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findByNumeroChambre(long numeroChambre);
    List<Chambre> findByB(Bloc b);
    @Query("SELECT c FROM Chambre c LEFT JOIN FETCH c.reservations")
    List<Chambre> findAllWithReservations();

}
