package tn.spring.springboot.Services.Interfaces;

import tn.spring.springboot.entities.Assurance;

public interface IAssuranceService {

    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);
    public float getMontantBf (int cinBf);
}
