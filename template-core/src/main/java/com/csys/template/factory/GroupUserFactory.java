/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.AccessForm;
import com.csys.template.domain.AccessMenu;
import com.csys.template.domain.Demande;
import com.csys.template.domain.GroupUser;
import com.csys.template.domain.Module;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.AccessFormDTO;
import com.csys.template.dto.AccessMenuDTO;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.dto.ModuleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class GroupUserFactory {
    
    public static GroupUser groupUserDTOToGroupUser(GroupUserDTO groupUserDTO) {
        GroupUser groupUser = new GroupUser();
        groupUser.setAccessControlCollection(AccessControlFactory.accessControlDTOToAccessControls((List<AccessControlDTO>) groupUserDTO.getAccessControlCollection()));
        groupUser.setAccessFormCollection(AccessFormFactory.accessFormDTOToAccessForms((List<AccessFormDTO>) groupUserDTO.getAccessFormCollection()));
        groupUser.setAccessMenuCollection(AccessMenuFactory.accessMenuDTOToAccessMenus((List<AccessMenuDTO>) groupUserDTO.getAccessMenuCollection()));
        groupUser.setActif(groupUserDTO.getActif());
        groupUser.setDemandeCollection(DemandeFactory.demandeDTOToDemandes((List<DemandeDTO>) groupUserDTO.getDemandeCollection()));
        groupUser.setDescription(groupUserDTO.getDescription());
        groupUser.setModuleCollection(ModuleFactory.moduleDTOToModules((List<ModuleDTO>) groupUserDTO.getModuleCollection()));
        groupUser.setGrp(groupUserDTO.getGrp());
        return groupUser;
    }
    
    public static GroupUserDTO groupUserToGroupUserDTO(GroupUser groupUser,boolean lazy) {
        GroupUserDTO groupDTO = new GroupUserDTO();
        groupDTO.setAccessControlCollection(AccessControlFactory.accessControlToAccessControlDTOs((List<AccessControl>) groupUser.getAccessControlCollection(),lazy));
        groupDTO.setAccessFormCollection(AccessFormFactory.accessFormToAccessFormDTOs((List<AccessForm>) groupUser.getAccessFormCollection(),lazy));
        groupDTO.setAccessMenuCollection(AccessMenuFactory.accessMenuToAccessMenuDTOs((List<AccessMenu>) groupUser.getAccessMenuCollection(),lazy));
        groupDTO.setActif(groupUser.getActif());
        groupDTO.setDemandeCollection(DemandeFactory.demandeToDemandeDTOs((List<Demande>) groupUser.getDemandeCollection(),lazy));
        groupDTO.setDescription(groupUser.getDescription());
        groupDTO.setGrp(groupUser.getGrp());
        groupDTO.setModuleCollection(ModuleFactory.moduleToModuleDTOs((List<Module>) groupUser.getModuleCollection(),lazy));
        return groupDTO;
    }
    
    public static List<GroupUserDTO> groupUserToGroupUserDTOs(List<GroupUser> groupUsers,boolean lazy) {
     List<GroupUserDTO> groupUsersDTO=new ArrayList<>();
     groupUsers.forEach(x -> {
      groupUsersDTO.add(groupUserToGroupUserDTO(x,lazy));
     } );
     return groupUsersDTO;
    }
    
    public static List<GroupUser> groupUserDTOToGroupUsers(List<GroupUserDTO> groupUserDTOs) {
        List<GroupUser> groupUsers = new ArrayList<>();
        groupUserDTOs.forEach(x -> {
            groupUsers.add(groupUserDTOToGroupUser(x));
        });
        return groupUsers;
    }
}
