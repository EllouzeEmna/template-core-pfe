/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessMenu;
import com.csys.template.domain.AccessMenuUser;
import com.csys.template.domain.MenuP;
import com.csys.template.domain.MenuPPK;
import com.csys.template.dto.AccessMenuDTO;
import com.csys.template.dto.AccessMenuUserDTO;
import com.csys.template.dto.MenuPDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class MenuPFactory {
    
    public static MenuP menuPDTOToMenuP(MenuPDTO menuPDTO) {
        MenuP menuP = new MenuP();
        MenuPPK menuPK=new MenuPPK();
        menuP.setAccessMenuCollection(AccessMenuFactory.accessMenuDTOToAccessMenus((List<AccessMenuDTO>) menuPDTO.getAccessMenuCollection()));
        menuP.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserDTOToAccessMenuUsers((List<AccessMenuUserDTO>) menuPDTO.getAccessMenuUserCollection()));
        menuP.setCodemenu(menuPDTO.getCodemenu());
        menuP.setDesMenuP(menuPDTO.getDesMenuP());
        menuP.setLogo(menuPDTO.getLogo());
        menuPK.setCodMnp(menuPDTO.getCodMnp());
        menuPK.setModule(menuPDTO.getModule());
        menuP.setMnName(menuPDTO.getMnName());
        menuP.setOrder(menuPDTO.getOrder());
        return menuP;
    }
    
    public static MenuPDTO menuPToMenuPDTO(MenuP menuP) {
        MenuPDTO menuPDTO = new MenuPDTO();
//        menuPDTO.setAccessMenuCollection(AccessMenuFactory.accessMenuToAccessMenuDTOs((List<AccessMenu>) menuP.getAccessMenuCollection()));
//        menuPDTO.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserToAccessMenuUserDTOs((List<AccessMenuUser>) menuP.getAccessMenuUserCollection()));
        menuPDTO.setCodMnp(menuP.getMenuPPK().getCodMnp());
        menuPDTO.setCodemenu(menuP.getCodemenu());
        menuPDTO.setDesMenuP(menuP.getDesMenuP());
        menuPDTO.setLogo(menuP.getLogo());
        menuPDTO.setMnName(menuP.getMnName());
        menuPDTO.setModule(menuP.getMenuPPK().getModule());
        menuPDTO.setOrder(menuP.getOrder());
        return menuPDTO;
    }
    
    public static List<MenuPDTO> menuPToMenuPDTOs(List<MenuP> menuPs) {
     List<MenuPDTO> menuPsDTO=new ArrayList<>();
     menuPs.forEach(x -> {
      menuPsDTO.add(menuPToMenuPDTO(x));
     } );
     return menuPsDTO;
    }
    
    public static List<MenuP> menuPDTOToMenuPs(List<MenuPDTO> menuPDTOs) {
        List<MenuP> menuPs = new ArrayList<>();
        if(menuPDTOs!=null){
        menuPDTOs.forEach(x -> {
            menuPs.add( menuPDTOToMenuP(x));
        });}
        return menuPs;
    }
}
