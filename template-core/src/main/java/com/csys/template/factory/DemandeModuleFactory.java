/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.DemandeModule;
import com.csys.template.domain.DemandeModulePK;
import com.csys.template.dto.DemandeModuleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class DemandeModuleFactory {
    
    public static DemandeModule demandeModuleDTOToDemandeModule(DemandeModuleDTO demandeModuleDTO) {
        DemandeModule demandeModule = new DemandeModule();
        DemandeModulePK demandeModulePK = new DemandeModulePK();
        demandeModulePK.setCodeDemande(demandeModuleDTO.getCodeDemande());
        demandeModulePK.setNumModule(demandeModuleDTO.getNumModule());
        demandeModule.setDemandeModulePK(demandeModulePK);
        demandeModule.setValider(demandeModuleDTO.getValider());
        return demandeModule;
    }
    
    public static DemandeModuleDTO demandeModuleToDemandeModuleDTO(DemandeModule demandeModule) {
        DemandeModuleDTO demandeModuleDTO = new DemandeModuleDTO();
        demandeModuleDTO.setCodeDemande(demandeModule.getDemandeModulePK().getCodeDemande());
        demandeModuleDTO.setNumModule(demandeModule.getDemandeModulePK().getNumModule());
        demandeModuleDTO.setModule(ModuleFactory.moduleToModuleDTO(demandeModule.getModule()));
        demandeModuleDTO.setValider(demandeModule.getValider());
        return demandeModuleDTO;
    }
    
    public static List<DemandeModuleDTO> demandeModuleToDemandeModuleDTOs(List<DemandeModule> demandeModules) {
     List<DemandeModuleDTO> demandeModuleDTOs=new ArrayList<>();
     demandeModules.forEach(x -> {
      demandeModuleDTOs.add(demandeModuleToDemandeModuleDTO(x));
     } );
     return demandeModuleDTOs;
    }
    
    public static List<DemandeModule> demandeModuleDTOToDemandeModules(List<DemandeModuleDTO> demandeModuleDTOs) {
        List<DemandeModule> demandeModules = new ArrayList<>();
        demandeModuleDTOs.forEach(x -> {
            demandeModules.add(demandeModuleDTOToDemandeModule(x));
        });
        return demandeModules;
    }
}
