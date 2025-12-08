package tn.esprit.foyer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.repositories.BlocRepository;
import tn.esprit.foyer.services.BlocServiceImp;
import tn.esprit.foyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocController {

    private final  IBlocService blocService;



    public BlocController(IBlocService blocService, BlocServiceImp blocServiceImpl) {
        this.blocService = blocService;
    }


    @PostMapping("/ajouterBloc")
    public Bloc createBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }


    @PostMapping("/ajouterBlocs")
    public List<Bloc> addAllBlocs(@RequestBody List<Bloc> blocs) {
        return blocService.addListBloc(blocs);
    }



    @GetMapping("/getById/{idBloc}")
    public Bloc getBloc(@PathVariable Long idBloc){
        return blocService.getBloc(idBloc);
    }

   @GetMapping
    public List<Bloc> getAllBloc(){
        return blocService.getAllBloc();
    }

    @PutMapping("/updateBloc/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc){
        bloc.setIdBloc(id);
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/deleteBloc/{id}")
    public void deleteBloc(@PathVariable Long id){
        blocService.deleteBloc(id);
    }

    @GetMapping("/getlistblocselonNomFoyer/{nom}")
    public List<Bloc> getlistBlocselonNomFoyer(@PathVariable String nom){
        return blocService.getlistBlocselonNomFoyer(nom);
    }
    @PutMapping("/affecterBloc/{nomBloc}")
    public Bloc affecterBloc(
            @PathVariable String nomBloc,
            @RequestBody Foyer foyer) {

        return blocService.affecterBlocAFoyer(nomBloc, foyer);
    }
    @PutMapping("/desaffecterBloc/{idBloc}")
    public Foyer desaffecterBloc(@PathVariable Long idBloc) {
        return blocService.desaffecterBlocDuFoyer(idBloc);
    }
}