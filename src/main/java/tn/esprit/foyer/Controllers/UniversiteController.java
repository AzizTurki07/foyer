package tn.esprit.foyer.Controllers;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.Universite;
import tn.esprit.foyer.repositories.FoyerRepository;
import tn.esprit.foyer.services.IUniversiteService;
import tn.esprit.foyer.services.UniversiteServiceImp;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    FoyerRepository foyerRepository;
    private final IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @PostMapping("/ajouterUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {

        return universiteService.addUniversite(universite);
    }

    @PostMapping("/ajouterUniversites")
    public List<Universite> addAllUniversites(@RequestBody List<Universite> universites) {
        return universiteService.addAllUniversites(universites);
    }

    @GetMapping("/getById/{idUniversite}")
    public Universite getUniversite(@PathVariable Long idUniversite) {
        return universiteService.getUniversite(idUniversite);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @PutMapping("/updateUniversite/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        universite.setIdUniversite(id);
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public String deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return "Université supprimée avec succès";
    }
    @GetMapping("/getByCapacite/{cap}")
    public Universite getUniversiteByCapacite(@PathVariable Long cap) {
        return universiteService.getUniversiteByCapacite(cap);
    }
    @GetMapping("/getUniByCapaciteQuery/{cap}")
    public Universite getUniByCapaciteQuery(@PathVariable Long cap) {
        return universiteService.getUniversiteByCapaciteQuery(cap);
    }
    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyer(
            @PathVariable Long idFoyer,
            @PathVariable String nomUniversite) {

        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
}