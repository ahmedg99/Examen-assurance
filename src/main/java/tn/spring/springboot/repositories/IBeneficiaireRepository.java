package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Beneficiaire;
import tn.spring.springboot.entities.enums.TypeContrat;

import java.util.Set;

@Repository
public interface IBeneficiaireRepository extends JpaRepository<Beneficiaire, Integer> {

    Beneficiaire getByCin(int cinBenef);

    @Query("Select b From Beneficiaire b join b.assurances ass join ass.contrat c where c.type = :tc")
    Set<Beneficiaire> getByAssuranceType(@Param("tc") TypeContrat tc);


}
