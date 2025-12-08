package tn.esprit.foyer.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne
    @JsonManagedReference
    Foyer foyer;
    public void setIdUniversite(long idUniversite) {
        this.idUniversite = idUniversite;
    }
    public void setNomUniversite(String nomUniversite) {
        this.nomUniversite = nomUniversite;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }
    public long getIdUniversite() {
        return idUniversite;
    }
    public String getNomUniversite() {
        return nomUniversite;
    }
    public String getAdresse() {
        return adresse;
    }
    public Foyer getFoyer() {
        return foyer;
    }

}
