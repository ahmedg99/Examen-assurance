package tn.spring.springboot.Services.Interfaces;

import tn.spring.springboot.entities.Beneficiaire;
import tn.spring.springboot.entities.enums.TypeContrat;

import java.util.Set;

public interface IBeneficiaireServices {

    Beneficiaire ajouterBeneficaire(Beneficiaire bf);

    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat);

    public void statistiques();
}
