package tn.esprit.foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class EtudiantServiceImp implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addListEtudiant(List<Etudiant> Etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(Etudiants);
    }

    @Override
    public List<Etudiant> getListEtudiantsByAnne(Date start , Date end){
        return etudiantRepository.findByReservatioon_AnneeUniversitaireBetween(start, end);
    }

    @Override
    public List<Etudiant> getListEtudiantsQuery(Date start , Date end){
        return etudiantRepository.findByAnneUniversitaireQuery(start, end);
    }
}
