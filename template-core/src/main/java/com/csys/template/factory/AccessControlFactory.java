/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessControl;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.AccessFormUserDTO;
import com.csys.template.dto.AccessMenuUserDTO;
import com.csys.template.dto.DemandeDTO;
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
        accessControl.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserDTOToAccessFormUsers((List<AccessFormUserDTO>) accessControlDTO.getAccessFormUserCollection()));
        accessControl.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserDTOToAccessMenuUsers((List<AccessMenuUserDTO>) accessControlDTO.getAccessMenuUserCollection()));
        accessControl.setActif(accessControlDTO.isActif());
        accessControl.setCodemedecininfirmier(accessControlDTO.getCodemedecininfirmier());
        accessControl.setDemandeCollection(DemandeFactory.demandeDTOToDemandes((List<DemandeDTO>) accessControlDTO.getDemandeCollection()));
        accessControl.setDescription(accessControlDTO.getDescription());
        accessControl.setGroupUser(GroupUserFactory.groupUserDTOToGroupUser(accessControlDTO.getGroupUser()));
        accessControl.setModuleCollection(ModuleFactory.moduleDTOToModules((List<ModuleDTO>) accessControlDTO.getModuleCollection()));
        accessControl.setPassWord(accessControlDTO.getPassWord());
        accessControl.setUserName(accessControlDTO.getUserName());
        accessControl.setClinique(CliniqueFactory.cliniqueDTOToClinique(accessControlDTO.getClinique()));
        return accessControl;
    }
    
    public static AccessControlDTO accessControlToAccessControlDTO(AccessControl accessControl, boolean lazy) {
        AccessControlDTO accessControlDTO = new AccessControlDTO();
        accessControlDTO.setActif(accessControl.isActif());
        accessControlDTO.setCodemedecininfirmier(accessControl.getCodemedecininfirmier());
        if (!lazy) {
            accessControlDTO.setGroupUser(GroupUserFactory.groupUserToGroupUserDTO(accessControl.getGroupUser()));
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
        accessControls.forEach(x -> {
            accessControlsDTO.add(accessControlToAccessControlDTO(x, lazy));
        });
        return accessControlsDTO;
    }
    
    public static List<AccessControl> accessControlDTOToAccessControls(List<AccessControlDTO> accessControlDTOs) {
        List<AccessControl> accessControls = new ArrayList<>();
        accessControlDTOs.forEach(x -> {
            accessControls.add(accessControlDTOToAccessControl(x));
        });
        return accessControls;
    }
}
