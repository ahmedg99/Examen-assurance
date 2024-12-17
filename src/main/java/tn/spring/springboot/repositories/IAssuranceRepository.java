package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.springboot.entities.Assurance;
import tn.spring.springboot.entities.enums.TypeContrat;


public interface IAssuranceRepository extends JpaRepository<Assurance, Integer> {

//    @Query("Select SUM(a.montant) From Assurance a where a.beneficiaire.idBeneficiaire = :id ")
//    float getMontantAnnuelByBf(@Param("id") int idBf);
//
//    @Query("Select SUM(a.montant) From Assurance a where a.contrat.type = :typeC")
//    float getSumByType(@Param("typeC") TypeContrat typeContrat);

}
