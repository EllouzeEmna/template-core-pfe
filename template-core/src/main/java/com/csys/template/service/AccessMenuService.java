/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessMenu;
import com.csys.template.domain.AccessMenuPK;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.factory.AccessMenuFactory;
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
public class AccessMenuService {

    private final Logger log = LoggerFactory.getLogger(AccessMenuService.class);

    private final DemandeRepository demandeRepository;
    private final GroupUserService groupUserService;
    private final MenuPRepository menuPRepository;

    public AccessMenuService(MenuPRepository menuPRepository, DemandeRepository demandeRepository, GroupUserService groupUserService) {
        this.demandeRepository = demandeRepository;
        this.groupUserService = groupUserService;
        this.menuPRepository = menuPRepository;
    }

    public void validateAccessDemande(List<DemandeMenuDTO> demandeMenus, GroupUserDTO grpUserDemande) {

        demandeMenus.stream().filter(x -> x.getValider()).forEach(y -> {
            AccessMenu accessMenu = new AccessMenu();
            AccessMenuPK accessMenuPK = new AccessMenuPK();
            accessMenuPK.setMenu(y.getMenuP().getCodMnp());
            accessMenuPK.setModule(y.getMenuP().getModule());
            accessMenu.setAccessMenuPK(accessMenuPK);
            accessMenu.setMenuP(MenuPFactory.menuPDTOToMenuP(y.getMenuP()));
            grpUserDemande.getAccessMenuCollection().add(AccessMenuFactory.accessMenuToAccessMenuDTO(accessMenu));
        });

    }
}
