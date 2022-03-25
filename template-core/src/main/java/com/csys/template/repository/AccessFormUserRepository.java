/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.AccessFormUser;
import com.csys.template.domain.AccessFormUserPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 21694
 */
public interface AccessFormUserRepository extends JpaRepository<AccessFormUser, AccessFormUserPK>{
    
}
