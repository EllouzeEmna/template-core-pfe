/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.factory;

import com.csys.template.domain.Form;
import com.csys.template.domain.FormPK;
import com.csys.template.dto.AccessFormDTO;
import com.csys.template.dto.AccessFormUserDTO;
import com.csys.template.dto.FormDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21694
 */
public class FormFactory {

    
    public static Form formDTOToForm(FormDTO formDTO) {
        Form form = new Form();
        FormPK formPK=new FormPK();
        form.setAccessFormCollection(AccessFormFactory.accessFormDTOToAccessForms((List<AccessFormDTO>) formDTO.getAccessFormCollection()));
        form.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserDTOToAccessFormUsers((List<AccessFormUserDTO>) formDTO.getAccessFormUserCollection()));
        formPK.setCodeMenu(formDTO.getCodeMenu());
        formPK.setControl(formDTO.getControl());
        formPK.setForm(formDTO.getForm());
        formPK.setModule(formDTO.getModule());
        form.setFormPK(formPK);
        form.setLogo(formDTO.getLogo());
        form.setNomControl(formDTO.getNomControl());
        form.setNomForm(formDTO.getNomForm());
        form.setOrderButton(formDTO.getOrderButton());
        form.setParentControl(formDTO.getParentControl());
        form.setParentForm(formDTO.getParentForm());
        return form;
    }
    
    public static FormDTO formToFormDTO(Form form) {
        FormDTO formDTO = new FormDTO();
//        formDTO.setAccessFormCollection(AccessFormFactory.accessFormToAccessFormDTOs((List<AccessForm>) form.getAccessFormCollection()));
//        formDTO.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserToAccessFormUserDTOs((List<AccessFormUser>) form.getAccessFormUserCollection()));
        formDTO.setCodeMenu(form.getFormPK().getCodeMenu());
        formDTO.setControl(form.getFormPK().getControl());
        formDTO.setForm(form.getFormPK().getForm());
        formDTO.setLogo(form.getLogo());
        formDTO.setModule(form.getFormPK().getModule());
        formDTO.setNomControl(form.getNomControl());
        formDTO.setNomForm(form.getNomForm());
        formDTO.setOrderButton(form.getOrderButton());
        formDTO.setParentControl(form.getParentControl());
        formDTO.setParentForm(form.getParentForm());
        return formDTO;
    }
    
    public static List<FormDTO> formToFormDTOs(List<Form> forms) {
     List<FormDTO> formsDTO=new ArrayList<>();
     forms.forEach(x -> {
      formsDTO.add(formToFormDTO(x));
     } );
     return formsDTO;
    }
    
    public static List<Form> formDTOToForms(List<FormDTO> formDTOs) {
        List<Form> forms = new ArrayList<>();
        if(formDTOs!=null){
        formDTOs.forEach(x -> {
            forms.add(formDTOToForm(x));
        });
        }
        return forms;
    }
}
