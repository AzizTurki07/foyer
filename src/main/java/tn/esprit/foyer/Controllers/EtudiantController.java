package tn.esprit.foyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.services.IEtudiantService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

   /* @PostMapping("/addAll")
    public List<Etudiant> addAllEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addAllEtudiants(etudiants);
    }*/

    /*@GetMapping("/getAll")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }*/

    @GetMapping("/get/{id}")
    public Etudiant getEtudiant(@PathVariable Long id) {
        return etudiantService.getEtudiant(id);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return "Etudiant supprimé avec succès";
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiantsBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end
    ) {
        return etudiantService.getListEtudiantsByAnne(start, end);
    }
    @GetMapping("/etudiantsQuery")
    public List<Etudiant> getEtudiantsBetweenDatesQuery(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date end
    ) {
        return etudiantService.getListEtudiantsQuery(start, end);
    }

}
