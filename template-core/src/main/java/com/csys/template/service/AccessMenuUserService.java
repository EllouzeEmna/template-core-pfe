/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessMenuUser;
import com.csys.template.domain.AccessMenuUserPK;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.factory.AccessMenuUserFactory;
import com.csys.template.factory.MenuPFactory;
import com.csys.template.repository.DemandeRepository;
import com.csys.template.repository.MenuPRepository;
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
public class AccessMenuUserService {

    private final Logger log = LoggerFactory.getLogger(AccessMenuUserService.class);

    private final DemandeRepository demandeRepository;
    private final AccessControlService accessControlService;
    private final MenuPRepository menuPRepository;

    public AccessMenuUserService(MenuPRepository menuPRepository, DemandeRepository demandeRepository, AccessControlService accessControlService) {
        this.demandeRepository = demandeRepository;
        this.accessControlService = accessControlService;
        this.menuPRepository = menuPRepository;
    }

//    public void validateAccessDemande(DemandeDTO demandeDTO) {
//        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());
//        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
//        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
//        if (userDemande != null) {
//            demande.getDemandeMenuCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//                AccessMenuUser accessMenuUser = new AccessMenuUser();
//                AccessMenuUserPK accessMenuUserPK = new AccessMenuUserPK();
//                accessMenuUserPK.setMenu(y.getMenuP().getMenuPPK().getCodMnp());
//                accessMenuUserPK.setModule(y.getMenuP().getMenuPPK().getModule());
//                accessMenuUser.setAccessMenuUserPK(accessMenuUserPK);
//                accessMenuUser.setMenuP(y.getMenuP());
//                userDemande.getAccessMenuUserCollection().add(AccessMenuUserFactory.accessMenuUserToAccessMenuUserDTO(accessMenuUser));       
//            });
//        }else{
//            demande.getDemandeMenuCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//            AccessMenu accessMenu = new AccessMenu();
//            AccessMenuPK accessMenuPK = new AccessMenuPK();
//            accessMenuPK.setMenu(y.getMenuP().getMenuPPK().getCodMnp());
//            accessMenuPK.setModule(y.getMenuP().getMenuPPK().getModule());
//            accessMenu.setAccessMenuPK(accessMenuPK);
//            accessMenu.setMenuP(y.getMenuP());
//            grpUserDemande.getAccessMenuCollection().add(AccessMenuFactory.accessMenuToAccessMenuDTO(accessMenu));
//        });
//        }
//    }
    public void validateAccessDemande(List<DemandeMenuDTO> demandeMenus, AccessControlDTO userDemande) {

        demandeMenus.stream().filter(x -> x.getValider()).forEach(y -> {
            AccessMenuUser accessMenuUser = new AccessMenuUser();
            AccessMenuUserPK accessMenuUserPK = new AccessMenuUserPK();
            accessMenuUserPK.setMenu(y.getMenuP().getCodMnp());
            accessMenuUserPK.setModule(y.getMenuP().getModule());
            accessMenuUser.setAccessMenuUserPK(accessMenuUserPK);
            accessMenuUser.setMenuP(MenuPFactory.menuPDTOToMenuP(y.getMenuP()));
            userDemande.getAccessMenuUserCollection().add(AccessMenuUserFactory.accessMenuUserToAccessMenuUserDTO(accessMenuUser));
        });
    }
}
