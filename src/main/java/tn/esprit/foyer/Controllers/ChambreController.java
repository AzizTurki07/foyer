package tn.esprit.foyer.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.services.ChmabreServiceImpl;
import tn.esprit.foyer.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/Chambre/")
@AllArgsConstructor

public class ChambreController {
    //@Autowired
    IChambreService IchService;

    @GetMapping("/listerChambres")
    public List<Chambre> ListeDesChambres() {
        return IchService.getAllChambre();
    }

    @PostMapping ("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre){
        return IchService.addChambre(chambre);
    }

    @GetMapping ("/getChambre/{id}")
    public Chambre getChambre(@PathVariable long id ){
        return IchService.getChambre(id);
    }

    @PutMapping("/updateChambre/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        chambre.setIdChambre(id);
        return IchService.updateChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{id}")
    public void deleteReservation(@PathVariable Long id) {
        IchService.deleteChambre(id);

    }

    @GetMapping("/getAll")
    public List<Chambre> getAllChambres() {
        return IchService.getAllChambre();
    }

    @PostMapping("/ajouterChambres")
    public List<Chambre> addAllReservations(@RequestBody List<Chambre> chambres) {
        return IchService.addListChambre(chambres);
    }

    @GetMapping("/getchambrebynumero/{num}")
    public Chambre getChambreByNumero(@PathVariable long num) {
        return IchService.getChambreByNumeroChambre(num);
    }
}
