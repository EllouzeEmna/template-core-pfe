/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessMenu;
import com.csys.template.domain.AccessMenuPK;
import com.csys.template.dto.AccessMenuDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class AccessMenuFactory {
    
    
    public static AccessMenu accessMenuDTOToAccessMenu(AccessMenuDTO accessMenuDTO) {
        AccessMenu accessMenu = new AccessMenu ();
        AccessMenuPK accessMenuPK=new AccessMenuPK();
        accessMenuPK.setGrp(accessMenuDTO.getGrp());
        accessMenuPK.setMenu(accessMenuDTO.getMenu());
        accessMenuPK.setModule(accessMenuDTO.getModule());
        accessMenu.setAccessMenuPK(accessMenuPK);
//        accessMenu.setGroupUser(GroupUserFactory.groupUserDTOToGroupUser(accessMenuDTO.getGroupUser()));
//        accessMenu.setMenuP(MenuPFactory.menuPDTOToMenuP(accessMenuDTO.getMenuP()));
        accessMenu.setVisible(accessMenuDTO.isVisible());
        return accessMenu;
    }
    
    public static AccessMenuDTO accessMenuToAccessMenuDTO(AccessMenu accessMenu) {
        AccessMenuDTO accessMenuDTO = new AccessMenuDTO();
//        accessMenuDTO.setGroupUser(GroupUserFactory.groupUserToGroupUserDTO(accessMenu.getGroupUser()));
        accessMenuDTO.setGrp(accessMenu.getAccessMenuPK().getGrp());
        accessMenuDTO.setMenu(accessMenu.getAccessMenuPK().getMenu());
//        accessMenuDTO.setMenuP(MenuPFactory.menuPToMenuPDTO(accessMenu.getMenuP()));
        accessMenuDTO.setModule(accessMenu.getAccessMenuPK().getModule());
        accessMenuDTO.setVisible(accessMenu.getVisible());
       
        return accessMenuDTO;
    }
    
    public static List<AccessMenuDTO> accessMenuToAccessMenuDTOs(List<AccessMenu> accessMenus) {
     List<AccessMenuDTO> accessMenusDTO=new ArrayList<>();
     accessMenus.forEach(x -> {
      accessMenusDTO.add(accessMenuToAccessMenuDTO(x));
     } );
     return accessMenusDTO;
    }
    
    public static List<AccessMenu> accessMenuDTOToAccessMenus(List<AccessMenuDTO> accessMenuDTOs) {
        List<AccessMenu> accessMenus = new ArrayList<>();
        accessMenuDTOs.forEach(x -> {
            accessMenus.add(accessMenuDTOToAccessMenu(x));
        });
        return accessMenus;
    }
}
