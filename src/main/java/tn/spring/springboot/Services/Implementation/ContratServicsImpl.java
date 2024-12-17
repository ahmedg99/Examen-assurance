package tn.spring.springboot.Services.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IContratService;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.repositories.IBeneficiaireRepository;
import tn.spring.springboot.repositories.IContratRepository;

import java.util.List;

@Slf4j
@Service
public class ContratServicsImpl implements IContratService {

    @Autowired
    IContratRepository contratRepository;
    @Autowired
    IBeneficiaireRepository benefRepository;


    @Override
    public Contrat ajouterContrat(Contrat c) {
        Contrat contrat = contratRepository.save(c);
        log.info("Contrat ajouté avec succès");
        return contrat;
    }

    @Override
    public Contrat getContratBf(int idBf) {
        List<Contrat> contrats = contratRepository.getOldestContratByBenefId(idBf);
        return contrats.get(0);
    }
}
