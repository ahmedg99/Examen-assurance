package tn.spring.springboot.Services.Interfaces;

import tn.spring.springboot.entities.Contrat;

public interface IContratService {

    public Contrat ajouterContrat(Contrat c);

    public Contrat getContratBf(int idBf);



}
