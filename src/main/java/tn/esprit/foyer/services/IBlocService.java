package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Foyer;

import java.util.List;

public interface IBlocService {
    public Bloc addBloc(Bloc bloc);
    public Bloc getBloc(Long idBloc);
    public Bloc updateBloc(Bloc bloc);
    public void deleteBloc(Long idBloc);
    public List<Bloc> getBlocs();
    public List<Bloc>addListBloc(List<Bloc> blocs);
    public List<Bloc>getAllBloc();
    public List<Bloc> getlistBlocselonNomFoyer(String nomFoyer);
    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer);
    public Foyer desaffecterBlocDuFoyer(Long idBloc);
}
