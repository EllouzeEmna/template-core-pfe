 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 21694
 */
public interface ModuleRepository extends JpaRepository<Module, String>  {

    public Module findByNumModule(String numModule);
    
}
