/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessFormUser;
import com.csys.template.domain.AccessFormUserPK;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.factory.AccessFormUserFactory;
import com.csys.template.factory.FormFactory;
import com.csys.template.repository.DemandeRepository;
import com.csys.template.repository.FormRepository;
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
public class AccessFormUserService {

    private final Logger log = LoggerFactory.getLogger(AccessFormUserService.class);

    private final DemandeRepository demandeRepository;
    private final AccessControlService accessControlService;
    private final FormRepository formRepository;

    public AccessFormUserService(FormRepository formRepository, DemandeRepository demandeRepository, AccessControlService accessControlService) {
        this.demandeRepository = demandeRepository;
        this.accessControlService = accessControlService;
        this.formRepository = formRepository;
    }

    public void validateAccessDemande(List<DemandeFormDTO> demandeFormDTO, AccessControlDTO userDemande) {

        demandeFormDTO.stream().filter(x -> x.getValider()).forEach(y -> {
            AccessFormUser accessFormUser = new AccessFormUser();
            AccessFormUserPK accessFormUserPK = new AccessFormUserPK();
            accessFormUserPK.setForm(y.getForm().getForm());
            accessFormUserPK.setModule(y.getForm().getModule());
            accessFormUserPK.setCodeMenu(y.getForm().getCodeMenu());
            accessFormUserPK.setControl(y.getForm().getControl());
            accessFormUser.setAccessFormUserPK(accessFormUserPK);
            accessFormUser.setForm(FormFactory.formDTOToForm(y.getForm()));
            userDemande.getAccessFormUserCollection().add(AccessFormUserFactory.accessFormUserToAccessFormUserDTO(accessFormUser));
        });

    }
}
