package tn.esprit.foyer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name= "F")

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;
    private String nomFoyer;
    private Long capaciteFoyer;


@OneToOne (mappedBy = "foyer")
@JsonBackReference
Universite universite;

    @OneToMany (mappedBy = "foyer", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Bloc> blocs;

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }
    public void setNomFoyer(String nomFoyer) {this.nomFoyer = nomFoyer;}
    public void setCapaciteFoyer(Long capaciteFoyer) {this.capaciteFoyer = capaciteFoyer;}
    public void setUniversite(Universite universite) {this.universite = universite;}
    public void setBlocs(List<Bloc> blocs) {this.blocs = blocs;}
    public Long getIdFoyer() {return idFoyer;}

    public String getNomFoyer() {return nomFoyer;}
    public Long getCapaciteFoyer() {return capaciteFoyer;}
    public Universite getUniversite() {return universite;}
    public List<Bloc> getBlocs() {return blocs;}
}
