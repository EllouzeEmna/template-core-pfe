/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessForm;
import com.csys.template.domain.AccessFormPK;
import com.csys.template.dto.DemandeFormDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.factory.AccessFormFactory;
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
public class AccessFormService {

    private final Logger log = LoggerFactory.getLogger(AccessFormService.class);

    private final DemandeRepository demandeRepository;
    private final GroupUserService groupUserService;
    private final FormRepository formRepository;

    public AccessFormService(FormRepository formRepository, DemandeRepository demandeRepository, GroupUserService groupUserService) {
        this.demandeRepository = demandeRepository;
        this.groupUserService = groupUserService;
        this.formRepository = formRepository;
    }

//    public void validateAccessDemande(DemandeDTO demandeDTO) {
//        GroupUserDTO grpUserDemande = groupUserService.findGroupUserDTO(demandeDTO.getUserGrp());
//        AccessControlDTO userDemande = accessControlService.findAccessControlDTO(demandeDTO.getUserName());
//        Demande demande = demandeRepository.findByCodeDemande(demandeDTO.getCodeDemande());
//        if (userDemande != null) {
//           demande.getDemandeFormCollection().stream().filter(x -> x.getValider()).forEach(y->{
//             AccessFormUser accessFormUser = new AccessFormUser();
//                AccessFormUserPK accessFormUserPK = new AccessFormUserPK();
//                accessFormUserPK.setForm(y.getForm().getFormPK().getForm());
//                accessFormUserPK.setModule(y.getForm().getFormPK().getModule());
//                accessFormUserPK.setCodeMenu(y.getForm().getFormPK().getCodeMenu());
//                accessFormUserPK.setControl(y.getForm().getFormPK().getControl());
//                accessFormUser.setAccessFormUserPK(accessFormUserPK);
//                accessFormUser.setForm(y.getForm());
//                userDemande.getAccessFormUserCollection().add(AccessFormUserFactory.accessFormUserToAccessFormUserDTO(accessFormUser));
//           });
//        }else{
//            demande.getDemandeFormCollection().stream().filter(x -> x.getValider()).forEach(y -> {
//            AccessForm accessForm = new AccessForm();
//            AccessFormPK accessFormPK = new AccessFormPK();
//            accessFormPK.setCodeMenu(y.getForm().getFormPK().getCodeMenu());
//            accessFormPK.setControl(y.getForm().getFormPK().getControl());
//            accessFormPK.setForm(y.getForm().getFormPK().getForm());
//            accessFormPK.setModule(y.getForm().getFormPK().getModule());
//            accessForm.setAccessFormPK(accessFormPK);
//            accessForm.setForm(y.getForm());
//            grpUserDemande.getAccessFormCollection().add(AccessFormFactory.accessFormToAccessFormDTO(accessForm));
//         });
//        }
//    }
    public void validateAccessDemande(List<DemandeFormDTO> demandeFormDTO, GroupUserDTO grpUserDemande) {

        demandeFormDTO.stream().filter(x -> x.getValider()).forEach(y -> {
            AccessForm accessForm = new AccessForm();
            AccessFormPK accessFormPK = new AccessFormPK();
            accessFormPK.setCodeMenu(y.getForm().getCodeMenu());
            accessFormPK.setControl(y.getForm().getControl());
            accessFormPK.setForm(y.getForm().getForm());
            accessFormPK.setModule(y.getForm().getModule());
            accessForm.setAccessFormPK(accessFormPK);
            accessForm.setForm(FormFactory.formDTOToForm(y.getForm()));
            grpUserDemande.getAccessFormCollection().add(AccessFormFactory.accessFormToAccessFormDTO(accessForm));
        });

    }
}
