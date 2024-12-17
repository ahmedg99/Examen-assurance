package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IAssuranceService;
import tn.spring.springboot.entities.Assurance;

@RestController
@RequestMapping("/Assurance")
public class AssuranceController {


    @Autowired
    IAssuranceService assuranceService;

    @PostMapping("/ajouterAssurance/{cinBF}/{matricule}")
    @ResponseBody
    public Assurance ajouterAssurance(@RequestBody Assurance assurance, @PathVariable("cinBF") int cinBf, @PathVariable("matricule") String matricule) {
        return assuranceService.ajouterAssurance(assurance, cinBf, matricule);
    }

    @GetMapping("/getTotalAmountByBenefCin/{cinBenef}")
    public float getTotalAmountByBenefCin(@PathVariable("cinBenef") int cinBenef) {
        return assuranceService.getMontantBf(cinBenef);
    }

}
