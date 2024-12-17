package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IAssuranceService;
import tn.spring.springboot.entities.Assurance;
import tn.spring.springboot.entities.Beneficiaire;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.repositories.IAssuranceRepository;
import tn.spring.springboot.repositories.IBeneficiaireRepository;
import tn.spring.springboot.repositories.IContratRepository;

@Slf4j
@Service
public class AssuranceServicsImpl implements IAssuranceService {

    @Autowired
    IAssuranceRepository assuranceRepository;
    @Autowired
    IBeneficiaireRepository benefRepository;
    @Autowired
    IContratRepository contratRepository;

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Beneficiaire beneficiaire = benefRepository.getByCin(cinBf);
        a.setBeneficiaire(beneficiaire);
        Contrat c = contratRepository.getContratByMatricule(matricule);
        a.setContrat(c);
        return assuranceRepository.save(a);
    }

    @Override
    public float getMontantBf(int cinBf) {
        Beneficiaire beneficiaire = benefRepository.getByCin(cinBf);
        return beneficiaire.getAssurances().stream().map(assurance -> assurance.getMontant()).reduce(0f, Float::sum);
        /* ****** Expliquation *********
        Calcul de la somme des montants :
            .stream() parcourt la liste des assurances.
            .map(assurance -> assurance.getMontant()) extrait le montant de chaque assurance.
            .reduce(0f, Float::sum) additionne tous les montants, avec une valeur initiale de 0f.
         */

    }
}
