/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.DemandeMenu;
import com.csys.template.domain.DemandeMenuPK;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.factory.DemandeMenuFactory;
import com.csys.template.repository.DemandeMenuRepository;
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
public class DemandeMenuService {
    
    private final Logger log = LoggerFactory.getLogger(DemandeMenuService.class);

    private final DemandeMenuRepository dmRepository;

    public DemandeMenuService(DemandeMenuRepository demandeMenuRepository) {
    
       this.dmRepository=demandeMenuRepository;
    }
    
    public DemandeMenuDTO save(DemandeMenuDTO demandeMenuDTO) {
     log.debug("Request to save DemandeMenu: {}",demandeMenuDTO);
     DemandeMenu dm = DemandeMenuFactory.demandeMenuDTOToDemandeMenu(demandeMenuDTO);
     dm = dmRepository.save(dm);
     DemandeMenuDTO resultDTO = DemandeMenuFactory.demandeMenuToDemandeMenuDTO(dm,false);
     return resultDTO;
    }
    
    @Transactional(
      readOnly = true
    )
    public DemandeMenuDTO findDemandeMenuDTO(DemandeMenuPK dmpk) {
     log.debug("Request to get DemandeMenuDTO: {}",dmpk);
     DemandeMenu dm= dmRepository.findByDemandeMenuPK(dmpk);
     DemandeMenuDTO dto = DemandeMenuFactory.demandeMenuToDemandeMenuDTO(dm,false);
     return dto;
    }
    
    @Transactional(
      readOnly = true
    )
    public DemandeMenu findDemandeMenu(DemandeMenuPK dmpk) {
     log.debug("Request to get DemandeMenu: {}",dmpk);
     DemandeMenu dm= dmRepository.findByDemandeMenuPK(dmpk);
     return dm;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<DemandeMenuDTO> findAllDTO() {
     log.debug("Request to get All DemandeMenusDTO");
     List<DemandeMenu> result= dmRepository.findAll();
     return DemandeMenuFactory.demandeMenuToDemandeMenuDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<DemandeMenu> findAll() {
     log.debug("Request to get All DemandeMenus");
     List<DemandeMenu> result= dmRepository.findAll();
     return (result);
    }
    
    public void delete(DemandeMenuPK dmpk) {
     log.debug("Request to delete DemandeMenu: {}",dmpk);
     dmRepository.delete(dmpk);
    }
}
