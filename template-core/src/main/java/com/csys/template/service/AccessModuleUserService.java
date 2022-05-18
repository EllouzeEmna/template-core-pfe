/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.DemandeModuleDTO;
import com.csys.template.repository.DemandeRepository;
import com.csys.template.repository.ModuleRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
@Service
@Transactional
public class AccessModuleUserService {

    private final Logger log = LoggerFactory.getLogger(AccessModuleUserService.class);

    private final DemandeRepository demandeRepository;
    private final AccessControlService accessControlService;
    private final ModuleRepository moduleRepository;

    public AccessModuleUserService(ModuleRepository moduleRepository, DemandeRepository demandeRepository, AccessControlService accessControlService) {
        this.demandeRepository = demandeRepository;
        this.accessControlService = accessControlService;
        this.moduleRepository = moduleRepository;
    }

//    public void validateAccessDemande(DemandeDTO demandeDTO) {
//        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());
//        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
//        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
//        if (userDemande != null) {
//            demande.getDemandeModuleCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//                userDemande.getModuleCollection().add(ModuleFactory.moduleToModuleDTO(y.getModule()));
//            });
//        }else{
//            demande.getDemandeModuleCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//            grpUserDemande.getModuleCollection().add(ModuleFactory.moduleToModuleDTO(y.getModule()));
//        });
//        }
//    }
    public void validateAccessDemande(List<DemandeModuleDTO> demandeModule, AccessControlDTO userDemande) {

        demandeModule.stream().filter(x -> x.getValider()).forEach(y -> {
            userDemande.getModuleCollection().add(y.getModule());
        });
    }
}
