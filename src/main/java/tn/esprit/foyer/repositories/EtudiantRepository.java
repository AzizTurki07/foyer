package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant , Long> {
    List<Etudiant> findByReservatioon_AnneeUniversitaireBetween (Date start, Date end);

    @Query("select e from Etudiant e join e.reservatioon rs where rs.anneeUniversitaire between ?1 and ?2")
    List<Etudiant> findByAnneUniversitaireQuery(Date start, Date end);
}
