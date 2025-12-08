package tn.esprit.foyer.services;

import tn.esprit.foyer.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant getEtudiant(Long idEtudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiant(Long idEtudiant);
    public List<Etudiant> getEtudiants();
    public List<Etudiant>addListEtudiant(List<Etudiant> Etudiants);
    public List<Etudiant>getListEtudiantsByAnne(Date start , Date end);
    public List<Etudiant>getListEtudiantsQuery(Date start , Date end);

}
