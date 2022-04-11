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
import java.util.ArrayList;
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

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
       this.moduleRepository=moduleRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<ModuleDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<Module> result= moduleRepository.findAll();
     
     return ModuleFactory.moduleToModuleDTOs(result);
    }
    
    @Transactional(
      readOnly = true
    )
    public ArrayList<ModuleDTO> findAllDTOAfficher(boolean afficher) {
     log.debug("Request to get All DemandeForms");
     List<Module> find= moduleRepository.findAll();
     ArrayList<ModuleDTO> result= new ArrayList<ModuleDTO>();
      find.forEach(x->{
          if(x.getAfficher()==true)
              result.add(ModuleFactory.moduleToModuleDTO(x));
      }
        );
     return (result);
    }
    
    @Transactional(
      readOnly = true
    )
    public ModuleDTO findModuleDTO(String numModule) {
        
     log.debug("Request to get ModuleDTO: {}",numModule);
     Module module= moduleRepository.findByNumModule(numModule);
     ModuleDTO moduleDTO = ModuleFactory.moduleToModuleDTO(module);
     return moduleDTO;
    }
}
