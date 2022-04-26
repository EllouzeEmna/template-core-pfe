/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.MenuP;
import com.csys.template.domain.MenuPPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 *
 * @author 21694
 */
public interface MenuPRepository extends JpaRepository<MenuP , MenuPPK>,QueryDslPredicateExecutor<MenuP> {

    public MenuP findByMenuPPK(MenuPPK menuPPK);
    
}
