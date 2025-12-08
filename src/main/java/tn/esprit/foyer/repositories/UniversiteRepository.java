package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Universite;
@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByFoyer_CapaciteFoyerGreaterThan(long capacite);

    @Query("SELECT u FROM Universite u WHERE u.foyer.capaciteFoyer > ?1")
    Universite getUniversiteByCapaciteFoyer(long capacite);

    Universite findByNomUniversite(String nomUniversite);

}
