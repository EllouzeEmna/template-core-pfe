/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.DemandeMenu;
import com.csys.template.domain.DemandeMenuPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 21694
 */
public interface DemandeMenuRepository extends JpaRepository<DemandeMenu, DemandeMenuPK>{

    public DemandeMenu findByDemandeMenuPK(DemandeMenuPK dmpk);
    
}
