package tn.esprit.foyer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.repositories.FoyerRepository;
import tn.esprit.foyer.services.IBlocService;
import tn.esprit.foyer.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerController {

    private final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    // CREATE - Ajouter un foyer
    @PostMapping("/ajouterFoyer")
    public Foyer createFoyer(@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer);
    }

    // CREATE - Ajouter plusieurs foyers en même temps
    /*@PostMapping("/ajouterFoyers")
    public List<foyer> addAllFoyers(@RequestBody List<foyer> foyers){
        return foyerService.addAllFoyers(foyers);
    }*/

    // READ - Récupérer un foyer par ID
    @GetMapping("/getById/{idFoyer}")
    public Foyer getFoyer(@PathVariable Long idFoyer){
        return foyerService.getFoyer(idFoyer);
    }

    // READ - Récupérer tous les foyers
   /* @GetMapping
    public List<foyer> getAllFoyer(){
        return foyerService.getAllFoyer();
    }*/

    // UPDATE - Modifier un foyer
    @PutMapping("/updateFoyer/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer){
        foyer.setIdFoyer(id);
        return foyerService.updateFoyer(foyer);
    }

    // DELETE - Supprimer un foyer
    @DeleteMapping("/deleteFoyer/{id}")
    public String deleteFoyer(@PathVariable Long id){
        foyerService.deleteFoyer(id);
        return "Foyer supprimé avec succès";
    }
    @GetMapping("/searchByChambres")
    public List<Foyer> getFoyersByChambres(@RequestParam List<Long> nums) {
        return foyerService.getFoyersByNumeroChambres(nums);
    }
    @GetMapping("/searchByChambresQuery")
    public List<Foyer> getFoyersByChambresQuery(@RequestParam List<Long> nums) {
        return foyerService.getFoyersByNumeroChambresQuery(nums);
    }

}