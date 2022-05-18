/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessMenuUser;
import com.csys.template.domain.AccessMenuUserPK;
import com.csys.template.dto.AccessMenuUserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class AccessMenuUserFactory {

    
    public static AccessMenuUser accessMenuUserDTOToAccessMenuUser(AccessMenuUserDTO accessMenuUserDTO) {
        AccessMenuUser accessMenuUser = new AccessMenuUser ();
        AccessMenuUserPK accessMenuUserPK=new AccessMenuUserPK();
        accessMenuUserPK.setMenu(accessMenuUserDTO.getMenu());
        accessMenuUserPK.setModule(accessMenuUserDTO.getModule());
        accessMenuUserPK.setUser(accessMenuUserDTO.getUser());
        accessMenuUser.setAccessMenuUserPK(accessMenuUserPK);
        accessMenuUser.setAccessControl(AccessControlFactory.accessControlDTOToAccessControl(accessMenuUserDTO.getAccessControl()));
        accessMenuUser.setMenuP(MenuPFactory.menuPDTOToMenuP(accessMenuUserDTO.getMenuP()));
        accessMenuUser.setPersonalise(accessMenuUserDTO.isPersonalise());
        accessMenuUser.setVisible(accessMenuUserDTO.isVisible());
        return accessMenuUser;
    }
    
    public static AccessMenuUserDTO accessMenuUserToAccessMenuUserDTO(AccessMenuUser accessMenuUser) {
        AccessMenuUserDTO accessMenuUserDTO = new AccessMenuUserDTO();
        accessMenuUserDTO.setAccessControl(AccessControlFactory.accessControlToAccessControlDTO(accessMenuUser.getAccessControl(),true));
        accessMenuUserDTO.setMenu(accessMenuUser.getAccessMenuUserPK().getMenu());
        accessMenuUserDTO.setMenuP(MenuPFactory.menuPToMenuPDTO(accessMenuUser.getMenuP()));
        accessMenuUserDTO.setModule(accessMenuUser.getAccessMenuUserPK().getModule());
        accessMenuUserDTO.setPersonalise(accessMenuUser.getPersonalise());
        accessMenuUserDTO.setUser(accessMenuUser.getAccessMenuUserPK().getUser());
        accessMenuUserDTO.setVisible(accessMenuUser.getVisible());
//        dfDTO.setDemandeFormPK(demandeForm.getDemandeFormPK());
//        dfDTO.setModule(demandeForm.getModule());
       
        return accessMenuUserDTO;
    }
    
    public static List<AccessMenuUserDTO> accessMenuUserToAccessMenuUserDTOs(List<AccessMenuUser> accessMenuUsers) {
     List<AccessMenuUserDTO> accessMenuUsersDTO=new ArrayList<>();
     accessMenuUsers.forEach(x -> {
      accessMenuUsersDTO.add(accessMenuUserToAccessMenuUserDTO(x));
     } );
     return accessMenuUsersDTO;
    }
    
    public static List<AccessMenuUser> accessMenuUserDTOToAccessMenuUsers(List<AccessMenuUserDTO> accessMenuUserDTOs) {
        List<AccessMenuUser> accessMenuUsers = new ArrayList<>();
        if(accessMenuUserDTOs!=null){
        accessMenuUserDTOs.forEach(x -> {
            accessMenuUsers.add(accessMenuUserDTOToAccessMenuUser(x));
        });}
        return accessMenuUsers;
    }
}
