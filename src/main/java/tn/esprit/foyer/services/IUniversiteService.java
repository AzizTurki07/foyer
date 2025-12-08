package tn.esprit.foyer.services;


import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite addUniversite(Universite universite);
    public Universite getUniversite(Long idUniversite);
    public Universite updateUniversite(Universite universite);
    public void deleteUniversite(Long idUniversite);
    public List<Universite> getUniversites();
    public List<Universite>addListUniversite(List<Universite> universites);
    public List<Universite> getAllUniversites();
    public List<Universite> addAllUniversites(@RequestBody List<Universite> universites);
    public Universite getUniversiteByCapacite(long capacite);
    public Universite getUniversiteByCapaciteQuery(long capacite);
    public Universite affecterFoyerAUniversite (Long idFoyer, String nomUniversite) ;
}
