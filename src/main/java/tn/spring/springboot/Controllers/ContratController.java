package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IContratService;
import tn.spring.springboot.entities.Contrat;

@RestController
@RequestMapping("/Contrat")
public class ContratController {


    @Autowired
    IContratService contratService;

    @PostMapping("/ajouterContrat")
    @ResponseBody
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @GetMapping("/getOldestContratByBenefId/{id-benef}")
    @ResponseBody
    public Contrat getOldestContratByBenefId(@PathVariable("id-benef") int idBf) {
        Contrat oldestContrat = contratService.getContratBf(idBf);
        System.out.println("oldestContrat = " + oldestContrat);
        return oldestContrat;
    }

}
