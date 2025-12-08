package tn.esprit.foyer.services;

import jakarta.transaction.Transactional;
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
@Transactional
public class BlocServiceImp implements IBlocService{
    @Autowired
    BlocRepository blocRepository;
    @Autowired
    FoyerRepository foyerRepository;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return  blocRepository.save(bloc);
    }

    @Override
    public Bloc getBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> getBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public List<Bloc> addListBloc(List<Bloc> blocs) {
        return (List<Bloc>) blocRepository.saveAll(blocs);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public List<Bloc> getlistBlocselonNomFoyer(String nomFoyer) {
        return blocRepository.findByFoyer_NomFoyer(nomFoyer);
    }
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) {
        Foyer f = foyerRepository.findById(foyer.getIdFoyer()).get();
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        System.out.println("Received foyer id: " + f.getNomFoyer());

        bloc.setFoyer(f);

        return blocRepository.save(bloc);
    }
    @Override
    public Foyer desaffecterBlocDuFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();

        Foyer old = bloc.getFoyer(); // si on veut retourner l'ancien foyer

        bloc.setFoyer(null);
        blocRepository.save(bloc);

        return old;
    }
}
