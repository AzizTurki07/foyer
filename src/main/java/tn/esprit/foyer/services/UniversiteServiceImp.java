package tn.esprit.foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.entities.Universite;
import tn.esprit.foyer.repositories.FoyerRepository;
import tn.esprit.foyer.repositories.UniversiteRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class UniversiteServiceImp implements IUniversiteService {
    @Autowired
    UniversiteRepository Urep;
    @Autowired
    FoyerRepository foyerRepository;
    @Override
    public Universite addUniversite(Universite universite) {
        return Urep.save(universite);
    }

    @Override
    public Universite getUniversite(Long idUniversite) {
        return Urep.findById(idUniversite).get();
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return Urep.save(universite);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        Urep.deleteById(idUniversite);
    }

    @Override
    public List<Universite> getUniversites() {
        return (List<Universite>)Urep.findAll();

    }

    @Override
    public List<Universite> addListUniversite(List<Universite> universites) {

        return (List<Universite>)Urep.saveAll(universites);

    }

    @Override
    public List<Universite> getAllUniversites() {
        return (List<Universite>)Urep.findAll();
    }

    @Override
    public List<Universite> addAllUniversites(List<Universite> universites) {
        return (List<Universite>) Urep.saveAll(universites);
    }

    @Override
    public Universite getUniversiteByCapacite(long capacite) {
        return Urep.findByFoyer_CapaciteFoyerGreaterThan(capacite);
    }

    @Override
    public Universite getUniversiteByCapaciteQuery(long capacite) {
        return Urep.getUniversiteByCapaciteFoyer(capacite);
    }
    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        Universite universite = Urep.findByNomUniversite(nomUniversite);

        universite.setFoyer(foyer);

        return Urep.save(universite);
    }
}
