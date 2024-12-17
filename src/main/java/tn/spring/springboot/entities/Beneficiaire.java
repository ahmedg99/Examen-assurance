package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Beneficiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBenef;
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private float salaire;
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiaire", fetch = FetchType.EAGER)
    private List<Assurance> assurances;

}
