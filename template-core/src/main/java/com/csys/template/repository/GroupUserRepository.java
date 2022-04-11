/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.repository;

import com.csys.template.domain.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 *
 * @author 21694
 */
public interface GroupUserRepository extends JpaRepository<GroupUser, String> ,QueryDslPredicateExecutor<GroupUser> {

    public GroupUser findByGrp(String grp);
    
}
