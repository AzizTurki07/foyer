package tn.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reservation {
    @Id
    private long idReservation;
    //@Temporal(value = TemporalType.TIMESTAMP)
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany
    List<Etudiant> etudiant;
    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }
    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }
    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
    public void setEtudiant(List<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }
    public boolean isEstValide() {
        return estValide;
    }
    public List<Etudiant> getEtudiant() {
        return etudiant;
    }
    public long getIdReservation() {
        return idReservation;
    }
}
