/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.MenuP;
import com.csys.template.domain.MenuPPK;
import com.csys.template.domain.QMenuP;
import com.csys.template.dto.MenuPDTO;
import com.csys.template.factory.MenuPFactory;
import com.csys.template.repository.MenuPRepository;
import com.csys.template.util.WhereClauseBuilder;
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

    private final MenuPRepository menuRepository;

    public MenuPService(MenuPRepository menuPRepository) {
       this.menuRepository=menuPRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<MenuPDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<MenuP> result= menuRepository.findAll();
     
     return MenuPFactory.menuPToMenuPDTOs(result);
    }
    
//    @Transactional(
//      readOnly = true
//    )
//    public MenuPDTO findMenuPDTO(String module, String codMnp) {
//     MenuPPK menuPPK=new MenuPPK();
//     menuPPK.setCodMnp(codMnp);
//     menuPPK.setModule(module);
//     log.debug("Request to get MenuPDTO: {}",menuPPK);
//     MenuP menuP= menuRepository.findOne(menuPPK);
//     MenuPDTO menuPDTO = MenuPFactory.menuPToMenuPDTO(menuP);
//     return menuPDTO;
//    }
    
     @Transactional(
      readOnly = true
    )
    public List<MenuPDTO> findMenuPByModuleDTO(String module, String codMnp) {
      log.debug("Request to get All Menus");
        QMenuP qMenuP = QMenuP.menuP;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(module, () -> qMenuP.menuPPK().module.eq(module))
                .optionalAnd(codMnp, () -> qMenuP.menuPPK().codMnp.eq(codMnp));
        List<MenuP> result = (List<MenuP>) menuRepository.findAll(builder);

        return (List<MenuPDTO>) MenuPFactory.menuPToMenuPDTOs(result);
    }
    
//    @Transactional(
//      readOnly = true
//    )
//    public list<MenuPDTO> findMenuByModule (String module){
//        
//    }
}
