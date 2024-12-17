package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.springboot.entities.Contrat;

import java.util.List;

public interface IContratRepository extends JpaRepository<Contrat, Integer> {

    public Contrat getContratByMatricule(String matricule);

    @Query("SELECT c FROM Contrat c " +
            "JOIN Assurance a ON c.idContrat = a.contrat.idContrat " +
            "JOIN Beneficiaire b ON a MEMBER OF b.assurances " +
            "WHERE b.idBenef = :benefId " +
            "ORDER BY c.dateEffet ASC")
    List<Contrat> getOldestContratByBenefId(@Param("benefId") int benefId);


}
