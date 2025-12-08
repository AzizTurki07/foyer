package tn.esprit.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private long cin;
    private String ecole ;
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiant")
    @JsonIgnore
    List<Reservation> reservatioon;

    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }
    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }
    public void setCin(long cin) {
        this.cin = cin;
    }
    public void setEcole(String ecole) {
        this.ecole = ecole;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setReservatioon(List<Reservation> reservatioon) {
        this.reservatioon = reservatioon;
    }
    public long getIdEtudiant() {
        return idEtudiant;
    }
    public String getNomEtudiant() {
        return nomEtudiant;
    }
    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }
    public long getCin() {
        return cin;
    }
    public String getEcole() {
        return ecole;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public List<Reservation> getReservatioon() {
        return reservatioon;
    }

}
