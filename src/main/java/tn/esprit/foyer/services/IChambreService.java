package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public Chambre getChambre(Long idChambre);
    public Chambre updateChambre(Chambre chambre);
    public void deleteChambre(Long idChambre);
    public List<Chambre> getAllChambre();
    public List<Chambre> addListChambre(List<Chambre> chambres);
    public Chambre getChambreByNumeroChambre(long numeroChambre);
    void listeChambresParBloc();
    void pourcentageChambreParTypeChambre();
    void nbPlacesDisponibleParChambreAnneeEnCours();

}
