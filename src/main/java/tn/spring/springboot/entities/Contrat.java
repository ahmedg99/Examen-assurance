package tn.spring.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.spring.springboot.entities.enums.TypeContrat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Enumerated(EnumType.STRING)
    private TypeContrat type;
}
