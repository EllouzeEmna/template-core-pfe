/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.GroupUser;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.AccessFormUserDTO;
import com.csys.template.dto.AccessMenuUserDTO;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.dto.ModuleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class AccessControlFactory {

    public static AccessControl accessControlDTOToAccessControl(AccessControlDTO accessControlDTO) {
        AccessControl accessControl = new AccessControl();
        if (accessControlDTO.getAccessFormUserCollection() != null) {
            accessControl.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserDTOToAccessFormUsers((List<AccessFormUserDTO>) accessControlDTO.getAccessFormUserCollection()));
        }
        if (accessControlDTO.getAccessMenuUserCollection() != null) {
            accessControl.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserDTOToAccessMenuUsers((List<AccessMenuUserDTO>) accessControlDTO.getAccessMenuUserCollection()));

        }
        accessControl.setActif(accessControlDTO.isActif());
        accessControl.setCodemedecininfirmier(accessControlDTO.getCodemedecininfirmier());
        if (accessControlDTO.getDemandeCollection() != null) {
            accessControl.setDemandeCollection(DemandeFactory.demandeDTOToDemandes((List<DemandeDTO>) accessControlDTO.getDemandeCollection()));

        }
        accessControl.setDescription(accessControlDTO.getDescription());
        if (accessControlDTO.getGroupUsers() != null) {
            accessControl.setGroupUsers(GroupUserFactory.groupUserDTOToGroupUsers((List<GroupUserDTO>) accessControlDTO.getGroupUsers()));

        }
        if (accessControlDTO.getModuleCollection() != null) {
            accessControl.setModuleCollection(ModuleFactory.moduleDTOToModules((List<ModuleDTO>) accessControlDTO.getModuleCollection()));

        }
        accessControl.setPassWord(accessControlDTO.getPassWord());
        accessControl.setUserName(accessControlDTO.getUserName());
        if (accessControlDTO.getClinique() != null) {
            accessControl.setClinique(CliniqueFactory.cliniqueDTOToClinique(accessControlDTO.getClinique()));
        }

        return accessControl;
    }

    public static AccessControlDTO accessControlToAccessControlDTO(AccessControl accessControl, boolean lazy) {
        AccessControlDTO accessControlDTO = new AccessControlDTO();
        accessControlDTO.setActif(accessControl.isActif());
        accessControlDTO.setCodemedecininfirmier(accessControl.getCodemedecininfirmier());
        if (!lazy) {
            accessControlDTO.setGroupUsers(GroupUserFactory.groupUserToGroupUserDTOs((List<GroupUser>) accessControl.getGroupUsers(), true));
//        accessControlDTO.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserToAccessFormUserDTOs((List<AccessFormUser>) accessControl.getAccessFormUserCollection()));
//        accessControlDTO.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserToAccessMenuUserDTOs((List<AccessMenuUser>) accessControl.getAccessMenuUserCollection()));
//        accessControlDTO.setModuleCollection(ModuleFactory.moduleToModuleDTOs((List<Module>) accessControl.getModuleCollection()));
//        accessControlDTO.setDemandeCollection(DemandeFactory.demandeToDemandeDTOs((List<Demande>) accessControl.getDemandeCollection(),false));
//        accessControlDTO.setClinique(CliniqueFactory.cliniqueToCliniqueDTO(accessControl.getClinique()));

        }
        accessControlDTO.setDescription(accessControl.getDescription());
        accessControlDTO.setPassWord(accessControl.getPassWord());
        accessControlDTO.setUserName(accessControl.getUserName());

        return accessControlDTO;
    }

    public static List<AccessControlDTO> accessControlToAccessControlDTOs(List<AccessControl> accessControls, boolean lazy) {
        List<AccessControlDTO> accessControlsDTO = new ArrayList<>();
        if (accessControls != null) {
            accessControls.forEach(x -> {
                if (x != null) {
                    accessControlsDTO.add(accessControlToAccessControlDTO(x, lazy));
                }
            });
        }
        return accessControlsDTO;
    }

    public static List<AccessControl> accessControlDTOToAccessControls(List<AccessControlDTO> accessControlDTOs) {
        List<AccessControl> accessControls = new ArrayList<>();
        if (accessControlDTOs != null) {
            accessControlDTOs.forEach(x -> {
                accessControls.add(accessControlDTOToAccessControl(x));
            });
        }
        return accessControls;
    }
}
