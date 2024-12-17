package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IBeneficiaireServices;
import tn.spring.springboot.entities.Beneficiaire;
import tn.spring.springboot.entities.enums.TypeContrat;

import java.util.Set;

@RestController
@RequestMapping("/Beneficiaire")
public class BeneficiaireController {


    @Autowired
    IBeneficiaireServices beneficiaireServices;

    @PostMapping("/ajouterBeneficaire")
    @ResponseBody
    public Beneficiaire ajouterBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireServices.ajouterBeneficaire(beneficiaire);
    }

    @GetMapping("/getBeneficairesByType/{type}")
    @ResponseBody
    public Set<Beneficiaire> getBeneficairesByType(@PathVariable("type") TypeContrat type) {
        return beneficiaireServices.getBeneficairesByType(type);
    }

}
