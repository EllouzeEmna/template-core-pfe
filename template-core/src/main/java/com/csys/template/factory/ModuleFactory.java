/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.GroupUser;
import com.csys.template.domain.Module;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.dto.ModuleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class ModuleFactory {
   
    
    public static Module moduleDTOToModule(ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setAccessControlCollection(AccessControlFactory.accessControlDTOToAccessControls((List<AccessControlDTO>) moduleDTO.getAccessControlCollection()));
        module.setAfficher(moduleDTO.isAfficher());
        module.setChemin(moduleDTO.getChemin());
        module.setDesModule(moduleDTO.getDesModule());
        module.setGroupUserCollection(GroupUserFactory.groupUserDTOToGroupUsers((List<GroupUserDTO>) moduleDTO.getGroupUserCollection()));
        module.setImage(moduleDTO.getImage());
        module.setNomImage(moduleDTO.getNomImage());
        module.setNumModule(moduleDTO.getNumModule());
        module.setUrlWeb(moduleDTO.getUrlWeb());
        module.setVersionDatabase(moduleDTO.getVersionDatabase());
        module.setVersionModule(moduleDTO.getVersionModule());
        return module;
    }
    
    public static ModuleDTO moduleToModuleDTO(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
//        moduleDTO.setAccessControlCollection(AccessControlFactory.accessControlToAccessControlDTOs((List<AccessControl>) module.getAccessControlCollection()));
        moduleDTO.setAfficher(module.getAfficher());
        moduleDTO.setChemin(module.getChemin());
        moduleDTO.setDesModule(module.getDesModule());
//        moduleDTO.setGroupUserCollection(GroupUserFactory.groupUserToGroupUserDTOs((List<GroupUser>) module.getGroupUserCollection()));
        moduleDTO.setImage(module.getImage());
        moduleDTO.setNomImage(module.getNomImage());
        moduleDTO.setNumModule(module.getNumModule());
        moduleDTO.setUrlWeb(module.getUrlWeb());
        moduleDTO.setVersionDatabase(module.getVersionDatabase());
        moduleDTO.setVersionModule(module.getVersionModule());
        return moduleDTO;
    }
    
    public static List<ModuleDTO> moduleToModuleDTOs(List<Module> modules) {
     List<ModuleDTO> modulesDTO=new ArrayList<>();
     modules.forEach(x -> {
      modulesDTO.add(moduleToModuleDTO(x));
     } );
     return modulesDTO;
    }
    
    public static List<Module> moduleDTOToModules(List<ModuleDTO> moduleDTOs) {
        List<Module> modules = new ArrayList<>();
        if(moduleDTOs!=null){
        moduleDTOs.forEach(x -> {
            modules.add(moduleDTOToModule(x));
        });}
        return modules;
    }
}
