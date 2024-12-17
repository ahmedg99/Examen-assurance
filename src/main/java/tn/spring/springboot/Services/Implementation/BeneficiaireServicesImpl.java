package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IBeneficiaireServices;
import tn.spring.springboot.entities.Beneficiaire;
import tn.spring.springboot.entities.enums.TypeContrat;
import tn.spring.springboot.repositories.IAssuranceRepository;
import tn.spring.springboot.repositories.IBeneficiaireRepository;
import tn.spring.springboot.repositories.IContratRepository;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Slf4j
@Service
public class BeneficiaireServicesImpl implements IBeneficiaireServices {

    @Autowired
    IBeneficiaireRepository benefRepository;

    @Autowired
    IAssuranceRepository assuranceRepository;

    @Autowired
    IContratRepository contratRepository;

    @Override
    public Beneficiaire ajouterBeneficaire(Beneficiaire bf) {
        Beneficiaire beneficiaire = benefRepository.save(bf);
        log.info("Beneficiaire ajouté avec succès");
        return beneficiaire;
    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return benefRepository.getByAssuranceType(typeContrat);
    }

    @Scheduled(fixedRate = 60000)
    public void statistiques() {
        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());
        benefRepository.findAll().forEach(beneficiaire -> {
            myStat.put(beneficiaire.getAssurances().size(), beneficiaire.getCin());
        });
        log.info("******************* Statistiques des beneficiaires :******************* ");
        for (Map.Entry<Integer, Integer> entry :
                myStat.entrySet()) {
            log.info("CIN : " + entry.getValue() + " Nombre d'assurances : " + entry.getKey());

        }
    }

}
