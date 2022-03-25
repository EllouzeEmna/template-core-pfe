/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.factory.AccessControlFactory;
import com.csys.template.repository.AccessControleRepository;
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
public class ControlService {
    
    private final Logger log = LoggerFactory.getLogger(ControlService.class);

    private final AccessControleRepository aConRepository;

    public ControlService(AccessControleRepository aCRepository) {
       this.aConRepository=aCRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<AccessControlDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<AccessControl> result= aConRepository.findAll();
     
     return AccessControlFactory.accessControlToAccessControlDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<AccessControl> findAll() {
     log.debug("Request to get All DemandeForms");
     List<AccessControl> result= aConRepository.findAll();
     return (result);
    }
    
}
