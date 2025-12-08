package tn.esprit.foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.repositories.BlocRepository;
import tn.esprit.foyer.repositories.FoyerRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class FoyerServiceImp implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public List<Foyer> getFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public List<Foyer> addListBloc(List<Foyer> foyers) {

        return (List<Foyer>) foyerRepository.saveAll(foyers);
    }
    @Override
    public List<Foyer> getFoyersByNumeroChambres(List<Long> nums){
        return foyerRepository.findByBlocs_Chambre_NumeroChambreIn(nums);
    }
    @Override
    public    List<Foyer> getFoyersByNumeroChambresQuery(List<Long> nums){
        return foyerRepository.getFoyerQuery(nums);
    }

}
