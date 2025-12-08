package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Foyer getFoyer(Long idFoyer);
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyer(Long idFoyer);
    public List<Foyer> getFoyers();
    public List<Foyer>addListBloc(List<Foyer> foyers);
    public List<Foyer> getFoyersByNumeroChambres(List<Long> nums);
    public List<Foyer> getFoyersByNumeroChambresQuery(List<Long> nums);
}
