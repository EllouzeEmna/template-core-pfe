/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.GroupUser;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.factory.GroupUserFactory;
import com.csys.template.repository.GroupUserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
@Service
@Transactional
public class GroupUserService {
    
    private final Logger log = LoggerFactory.getLogger(GroupUserService.class);

    private final GroupUserRepository grURepository;

    public GroupUserService(GroupUserRepository grRepository) {
       this.grURepository=grRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<GroupUserDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<GroupUser> result= grURepository.findAll();
     
     return GroupUserFactory.groupUserToGroupUserDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<GroupUser> findAll() {
     log.debug("Request to get All DemandeForms");
     List<GroupUser> result= grURepository.findAll();
     return (result);
    }
    
}
