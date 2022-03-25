/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Module;
import com.csys.template.dto.ModuleDTO;
import com.csys.template.factory.ModuleFactory;
import com.csys.template.repository.ModuleRepository;
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
public class ModuleService {
    
    private final Logger log = LoggerFactory.getLogger(ModuleService.class);

    private final ModuleRepository mRepository;

    public ModuleService(ModuleRepository moduleRepository) {
       this.mRepository=moduleRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<ModuleDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<Module> result= mRepository.findAll();
     
     return ModuleFactory.moduleToModuleDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<Module> findAll() {
     log.debug("Request to get All DemandeForms");
     List<Module> result= mRepository.findAll();
     return (result);
    }
    
}
