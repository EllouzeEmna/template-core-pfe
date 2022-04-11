/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.DemandeModule;
import com.csys.template.domain.DemandeModulePK;
import com.csys.template.dto.DemandeModuleDTO;
import com.csys.template.factory.DemandeModuleFactory;
import com.csys.template.repository.DemandeModuleRepository;
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
public class DemandeModuleService {
//    private final Logger log = LoggerFactory.getLogger(DemandeModuleService.class);
//
//    private final DemandeModuleRepository dmRepository;
//
//    public DemandeModuleService(DemandeModuleRepository demandeModuleRepository) {
//    
//       this.dmRepository=demandeModuleRepository;
//    }
//    
//    public DemandeModuleDTO save(DemandeModuleDTO demandeModuleDTO) {
//     log.debug("Request to save DemandeModule: {}",demandeModuleDTO);
//     DemandeModule dm = DemandeModuleFactory.demandeModuleDTOToDemandeModule(demandeModuleDTO);
//     dm = dmRepository.save(dm);
//     DemandeModuleDTO resultDTO = DemandeModuleFactory.demandeModuleToDemandeModuleDTO(dm);
//     return resultDTO;
//    }
//    
//    @Transactional(
//      readOnly = true
//    )
//    public DemandeModuleDTO findDemandeModuleDTO(DemandeModulePK dmpk) {
//     log.debug("Request to get DemandeModuleDTO: {}",dmpk);
//     DemandeModule dm= dmRepository.findByDemandeModulePK(dmpk);
//     DemandeModuleDTO dto = DemandeModuleFactory.demandeModuleToDemandeModuleDTO(dm);
//     return dto;
//    }
//    
//    @Transactional(
//      readOnly = true
//    )
//    public DemandeModule findDemandeModule(DemandeModulePK dmpk) {
//     log.debug("Request to get DemandeModule: {}",dmpk);
//     DemandeModule dm= dmRepository.findByDemandeModulePK(dmpk);
//     return dm;
//    }
//    
//    @Transactional(
//      readOnly = true
//    )
//    public List<DemandeModuleDTO> findAllDTO() {
//     log.debug("Request to get All DemandeModulesDTO");
//     List<DemandeModule> result= dmRepository.findAll();
//     return DemandeModuleFactory.demandeModuleToDemandeModuleDTOs(result);
//    }
//    
//    @Transactional(
//      readOnly = true
//    )
//    public List<DemandeModule> findAll() {
//     log.debug("Request to get All DemandeModules");
//     List<DemandeModule> result= dmRepository.findAll();
//     return (result);
//    }
//    
//    public void delete(DemandeModulePK dmpk) {
//     log.debug("Request to delete DemandeModule: {}",dmpk);
//     dmRepository.delete(dmpk);
//    }
}
