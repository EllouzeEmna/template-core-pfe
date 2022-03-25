/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.DemandeForm;
import com.csys.template.domain.DemandeFormPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
public interface DemandeFormRepository extends JpaRepository<DemandeForm, DemandeFormPK>{
    public DemandeForm findByDemandeFormPK(DemandeFormPK dfpk);
 
    public void deleteByDemandeFormPK_CodeDemande(String codeDemande);
}
