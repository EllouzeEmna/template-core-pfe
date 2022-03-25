/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.Demande;
import com.csys.template.domain.DemandeForm;
import com.csys.template.domain.DemandeMenu;
import com.csys.template.domain.DemandeModule;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.dto.DemandeMenuDTO;
import com.csys.template.dto.DemandeModuleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class DemandeFactory {

    public static Demande demandeDTOToDemande(DemandeDTO demandeDTO) {
        Demande demande = new Demande();

        demande.setAccessControl(AccessControlFactory.accessControlDTOToAccessControl(demandeDTO.getAccessControl()));
        demande.setDateCreation(demandeDTO.getDateCreation());
        demande.setDateValidation(demandeDTO.getDateValidation());
        demande.setCodeDemande(demandeDTO.getCodeDemande());
        demande.setGroupUser(GroupUserFactory.groupUserDTOToGroupUser(demandeDTO.getGroupUser()));
        demande.setMessage(demandeDTO.getMessage());
        demande.setUserCreate(demandeDTO.getUserCreate());
        demande.setUserValidation(demandeDTO.getUserValidation());
        demande.setDemandeFormCollection(DemandeFormFactory.demandeFormDTOToDemandeForms((List<DemandeFormDTO>) demandeDTO.getDemandeFormCollection()));
        demande.setDemandeMenuCollection(DemandeMenuFactory.demandeMenuDTOToDemandeMenus((List<DemandeMenuDTO>) demandeDTO.getDemandeMenuCollection()));
        demande.setDemandeModuleCollection(DemandeModuleFactory.demandeModuleDTOToDemandeModules((List<DemandeModuleDTO>) demandeDTO.getDemandeModuleCollection()));
        return demande;
    }

    public static DemandeDTO demandeToDemandeDTO(Demande demande, boolean lazy) {
        DemandeDTO demandeDTO = new DemandeDTO();
        demandeDTO.setAccessControl(AccessControlFactory.accessControlToAccessControlDTO(demande.getAccessControl(),lazy));
        demandeDTO.setCodeDemande(demande.getCodeDemande());
        demandeDTO.setDateCreation(demande.getDateCreation());
        demandeDTO.setDateValidation(demande.getDateValidation());
        demandeDTO.setGroupUser(GroupUserFactory.groupUserToGroupUserDTO(demande.getGroupUser(),lazy));
        demandeDTO.setMessage(demande.getMessage());
        demandeDTO.setUserCreate(demande.getUserCreate());
        demandeDTO.setUserValidation(demande.getUserValidation());
//        demandeDTO.setValider(demande.getValider());
        if (!lazy) {
            demandeDTO.setDemandeFormCollection(DemandeFormFactory.demandeFormToDemandeFormDTOs((List<DemandeForm>) demande.getDemandeFormCollection(),lazy));
            demandeDTO.setDemandeMenuCollection(DemandeMenuFactory.demandeMenuToDemandeMenuDTOs((List<DemandeMenu>) demande.getDemandeMenuCollection(),lazy));
            demandeDTO.setDemandeModuleCollection(DemandeModuleFactory.demandeModuleToDemandeModuleDTOs((List<DemandeModule>) demande.getDemandeModuleCollection(),lazy));
        }

        return demandeDTO;
    }

    public static List<DemandeDTO> demandeToDemandeDTOs(List<Demande> demandes, boolean lazy) {
        List<DemandeDTO> demandesDTO = new ArrayList<>();
        demandes.forEach(x -> {
            demandesDTO.add(demandeToDemandeDTO(x, lazy));
        });
        return demandesDTO;
    }

    public static List<Demande> demandeDTOToDemandes(List<DemandeDTO> demandeDTOs) {
        List<Demande> demandes = new ArrayList<>();
        demandeDTOs.forEach(x -> {
            demandes.add(demandeDTOToDemande(x));
        });
        return demandes;
    }
}
