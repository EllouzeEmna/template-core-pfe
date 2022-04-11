/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.DemandeMenu;
import com.csys.template.domain.DemandeMenuPK;
import com.csys.template.domain.Form;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.dto.FormDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class DemandeMenuFactory {

    public static DemandeMenu demandeMenuDTOToDemandeMenu(DemandeMenuDTO demandeMenuDTO) {
        DemandeMenu demandeMenu = new DemandeMenu();
        DemandeMenuPK demandeMenuPK = new DemandeMenuPK();
        demandeMenuPK.setCodeDemande(demandeMenuDTO.getCodeDemande());
        demandeMenuPK.setCodeMenu(demandeMenuDTO.getCodeMenu());
        demandeMenuPK.setCodeModule(demandeMenuDTO.getCodeModule());
        demandeMenu.setDemandeMenuPK(demandeMenuPK);
        demandeMenu.setValider(demandeMenuDTO.getValider());
        return demandeMenu;
    }

    public static DemandeMenuDTO demandeMenuToDemandeMenuDTO(DemandeMenu demandeMenu) {
        DemandeMenuDTO demandeMenuDTO = new DemandeMenuDTO();
        demandeMenuDTO.setCodeDemande(demandeMenu.getDemandeMenuPK().getCodeDemande());
        demandeMenuDTO.setCodeMenu(demandeMenu.getDemandeMenuPK().getCodeMenu());
        demandeMenuDTO.setCodeModule(demandeMenu.getDemandeMenuPK().getCodeModule());
        demandeMenuDTO.setMenuP(MenuPFactory.menuPToMenuPDTO(demandeMenu.getMenuP()));
        demandeMenuDTO.setValider(demandeMenu.getValider());
        return demandeMenuDTO;
    }

    public static List<DemandeMenuDTO> demandeMenuToDemandeMenuDTOs(List<DemandeMenu> demandeMenus) {
        List<DemandeMenuDTO> demandeMenuDTOs = new ArrayList<>();
        demandeMenus.forEach(x -> {
            demandeMenuDTOs.add(demandeMenuToDemandeMenuDTO(x));
        });
        return demandeMenuDTOs;
    }

    public static List<DemandeMenu> demandeMenuDTOToDemandeMenus(List<DemandeMenuDTO> demandeMenuDTOs) {
        List<DemandeMenu> demandeMenus = new ArrayList<>();
        demandeMenuDTOs.forEach(x -> {
            demandeMenus.add(demandeMenuDTOToDemandeMenu(x));
        });
        return demandeMenus;
    }

}
