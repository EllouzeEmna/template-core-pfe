/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessFormUser;
import com.csys.template.domain.AccessFormUserPK;
import com.csys.template.dto.AccessFormUserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class AccessFormUserFactory {

    public static AccessFormUser accessFormUserDTOToAccessFormUser(AccessFormUserDTO accessFormUserDTO) {
        AccessFormUser accessFormUser = new AccessFormUser ();
        AccessFormUserPK accessFormUserPK=new AccessFormUserPK();
        accessFormUser.setAccessControl(AccessControlFactory.accessControlDTOToAccessControl(accessFormUserDTO.getAccessControl()));
        accessFormUserPK.setCodeMenu(accessFormUserDTO.getCodeMenu());
        accessFormUserPK.setControl(accessFormUserDTO.getControl());
        accessFormUserPK.setForm(accessFormUserDTO.getForm());
        accessFormUserPK.setModule(accessFormUserDTO.getModule());
        accessFormUserPK.setUser(accessFormUserDTO.getUser());
        accessFormUser.setAccessFormUserPK(accessFormUserPK);
        accessFormUser.setForm(FormFactory.formDTOToForm(accessFormUserDTO.getFormDTO()));
        accessFormUser.setVisible(accessFormUserDTO.isVisible());
        return accessFormUser;
    }
    
    public static AccessFormUserDTO accessFormUserToAccessFormUserDTO(AccessFormUser accessFormUser) {
        AccessFormUserDTO accessFormUDTO = new AccessFormUserDTO();
        accessFormUDTO.setAccessControl(AccessControlFactory.accessControlToAccessControlDTO(accessFormUser.getAccessControl(),true));
        accessFormUDTO.setCodeMenu(accessFormUser.getAccessFormUserPK().getCodeMenu());
        accessFormUDTO.setControl(accessFormUser.getAccessFormUserPK().getControl());
        accessFormUDTO.setForm(accessFormUser.getAccessFormUserPK().getForm());
        accessFormUDTO.setFormDTO(FormFactory.formToFormDTO(accessFormUser.getForm()));
        accessFormUDTO.setModule(accessFormUser.getAccessFormUserPK().getModule());
        accessFormUDTO.setUser(accessFormUser.getAccessFormUserPK().getUser());
        accessFormUDTO.setVisible(accessFormUser.getVisible());

       
        return accessFormUDTO;
    }
    
    public static List<AccessFormUserDTO> accessFormUserToAccessFormUserDTOs(List<AccessFormUser> accessFormUsers) {
     List<AccessFormUserDTO> accessFormUsersDTO=new ArrayList<>();
     accessFormUsers.forEach(x -> {
      accessFormUsersDTO.add(accessFormUserToAccessFormUserDTO(x));
     } );
     return accessFormUsersDTO;
    }
    
    public static List<AccessFormUser> accessFormUserDTOToAccessFormUsers(List<AccessFormUserDTO> accessFormUserDTOs) {
        List<AccessFormUser> accessFormUsers = new ArrayList<>();
        accessFormUserDTOs.forEach(x -> {
            accessFormUsers.add(accessFormUserDTOToAccessFormUser(x));
        });
        return accessFormUsers;
    }
}
