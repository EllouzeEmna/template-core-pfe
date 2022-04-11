/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.Demande;
import com.csys.template.domain.EtatDemandeEnum;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
public interface DemandeRepository extends JpaRepository<Demande, String> {

    public Demande findByCodeDemande(String codeDemande);

   
    @Transactional
    public void deleteByCodeDemande(String codeDemande);

    public List<Demande> findByEtat(EtatDemandeEnum etat);

}
