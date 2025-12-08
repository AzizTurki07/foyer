package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends CrudRepository<Foyer, Long > {
List<Foyer> findByBlocs_Chambre_NumeroChambreIn (List<Long> n);

@Query("select f from Foyer f join f.blocs bs join bs.chambre cs where cs.numeroChambre in ?1 ")
List<Foyer> getFoyerQuery (List<Long> n);
}
