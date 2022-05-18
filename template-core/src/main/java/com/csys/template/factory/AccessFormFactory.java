/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.AccessForm;
import com.csys.template.domain.AccessFormPK;
import com.csys.template.dto.AccessFormDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class AccessFormFactory {
    
    
    public static AccessForm accessFormDTOToAccessForm(AccessFormDTO accessFormDTO) {
        AccessForm accessForm = new AccessForm ();
        AccessFormPK accessFormPK=new AccessFormPK();
        accessFormPK.setCodeMenu(accessFormDTO.getCodeMenu());
        accessFormPK.setControl(accessFormDTO.getControl());
        accessFormPK.setForm(accessFormDTO.getForm());
        accessFormPK.setGrp(accessFormDTO.getGrp());
        accessFormPK.setModule(accessFormDTO.getModule());
        accessForm.setAccessFormPK(accessFormPK);
        accessForm.setForm(FormFactory.formDTOToForm(accessFormDTO.getForm1()));
        accessForm.setGroupUser(GroupUserFactory.groupUserDTOToGroupUser(accessFormDTO.getGroupUser()));
        accessForm.setVisible(accessFormDTO.isVisible());
        return accessForm;
    }
    
    public static AccessFormDTO accessFormToAccessFormDTO(AccessForm accessForm) {
        AccessFormDTO accessFormDTO = new AccessFormDTO();
        accessFormDTO.setCodeMenu(accessForm.getAccessFormPK().getCodeMenu());
        accessFormDTO.setControl(accessForm.getAccessFormPK().getControl());
        accessFormDTO.setForm(accessForm.getAccessFormPK().getForm());
        accessFormDTO.setForm1(FormFactory.formToFormDTO(accessForm.getForm()));
//        accessFormDTO.setGroupUser(GroupUserFactory.groupUserToGroupUserDTO(accessForm.getGroupUser()));
        accessFormDTO.setGrp(accessForm.getAccessFormPK().getGrp());
        accessFormDTO.setModule(accessForm.getAccessFormPK().getModule());
        accessFormDTO.setVisible(accessForm.getVisible());
        return accessFormDTO;
    }
    
    public static List<AccessFormDTO> accessFormToAccessFormDTOs(List<AccessForm> accessForms) {
     List<AccessFormDTO> accessFormsDTO=new ArrayList<>();
     accessForms.forEach(x -> {
      accessFormsDTO.add(accessFormToAccessFormDTO(x));
     } );
     return accessFormsDTO;
    }
    
    public static List<AccessForm> accessFormDTOToAccessForms(List<AccessFormDTO> accessFormDTOs) {
        List<AccessForm> accessForms = new ArrayList<>();
        if(accessFormDTOs!=null){
        accessFormDTOs.forEach(x -> {
            accessForms.add(accessFormDTOToAccessForm(x));
        });
        }
        return accessForms;
    }
}
