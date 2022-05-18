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
import com.csys.template.dto.GroupUserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author 21694
 */
public class GroupUserFactory {

    public static GroupUser groupUserDTOToGroupUser(GroupUserDTO groupUserDTO) {
        GroupUser groupUser = new GroupUser();
        groupUser.setGrp(groupUserDTO.getGrp());
        groupUser.setDescription(groupUserDTO.getDescription());
        groupUser.setActif(groupUserDTO.getActif());
        return groupUser;
    }

    public static GroupUserDTO groupUserToGroupUserDTO(GroupUser groupUser, boolean lazy) {
        GroupUserDTO groupDTO = new GroupUserDTO();
        groupDTO.setDescription(groupUser.getDescription());
        groupDTO.setGrp(groupUser.getGrp());
        groupDTO.setActif(groupUser.getActif());
        groupDTO.setAccessControlCollection(AccessControlFactory.accessControlToAccessControlDTOs((List<AccessControl>) groupUser.getAccessControlCollection(), true));

        if (!lazy) {
            if (groupUser.getAccessFormCollection() != null) {
                groupDTO.setAccessFormCollection(AccessFormFactory.accessFormToAccessFormDTOs((List<AccessForm>) groupUser.getAccessFormCollection()));

            }
            if (groupUser.getAccessMenuCollection() != null) {
                groupDTO.setAccessMenuCollection(AccessMenuFactory.accessMenuToAccessMenuDTOs((List<AccessMenu>) groupUser.getAccessMenuCollection()));

            }
            if (groupUser.getDemandeCollection() != null) {
                groupDTO.setDemandeCollection(DemandeFactory.demandeToDemandeDTOs((List<Demande>) groupUser.getDemandeCollection(), false));

            }
            if (groupUser.getModuleCollection() != null) {
                groupDTO.setModuleCollection(ModuleFactory.moduleToModuleDTOs((List<Module>) groupUser.getModuleCollection()));

            }
        }

        return groupDTO;
    }

    public static Collection<GroupUserDTO> groupUserToGroupUserDTOs(Collection<GroupUser> groupUsers, boolean lazy) {
        List<GroupUserDTO> groupUsersDTO = new ArrayList<>();
        groupUsers.forEach(x -> {
            groupUsersDTO.add(groupUserToGroupUserDTO(x, lazy));
        });
        return groupUsersDTO;
    }

    public static List<GroupUser> groupUserDTOToGroupUsers(List<GroupUserDTO> groupUserDTOs) {
        List<GroupUser> groupUsers = new ArrayList<>();
        if (groupUserDTOs != null) {
            groupUserDTOs.forEach(x -> {
                groupUsers.add(groupUserDTOToGroupUser(x));
            });
        }
        return groupUsers;
    }
}
