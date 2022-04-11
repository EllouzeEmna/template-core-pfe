/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.AccessControl;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 *
 * @author 21694
 */
public interface AccessControleRepository extends JpaRepository<AccessControl, String>,QueryDslPredicateExecutor<AccessControl>{
    public  AccessControl findByUserName(String userName);

    public List<AccessControl> findByActif(boolean actif);
    
}
