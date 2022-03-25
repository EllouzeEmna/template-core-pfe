/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.MenuP;
import com.csys.template.dto.MenuPDTO;
import com.csys.template.factory.MenuPFactory;
import com.csys.template.repository.MenuPRepository;
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
public class MenuPService {
    
    private final Logger log = LoggerFactory.getLogger(MenuPService.class);

    private final MenuPRepository mRepository;

    public MenuPService(MenuPRepository menuPRepository) {
       this.mRepository=menuPRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<MenuPDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<MenuP> result= mRepository.findAll();
     
     return MenuPFactory.menuPToMenuPDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<MenuP> findAll() {
     log.debug("Request to get All DemandeForms");
     List<MenuP> result= mRepository.findAll();
     return (result);
    }
    
}
