/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Form;
import com.csys.template.domain.FormPK;
import com.csys.template.dto.FormDTO;
import com.csys.template.factory.FormFactory;
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
public class FormService {
    
    private final Logger log = LoggerFactory.getLogger(FormService.class);

    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
       this.formRepository=formRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<FormDTO> findAllDTO() {
     log.debug("Request to get All Form");
     List<Form> result= formRepository.findAll();
     
     return FormFactory.formToFormDTOs(result);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<Form> findAll() {
     log.debug("Request to get All DemandeForms");
     List<Form> result= formRepository.findAll();
     return (result);
    }
    
    @Transactional(
      readOnly = true
    )
    public FormDTO findFormDTO(String module,String form,String control,String codeMenu) {
     FormPK formPK=new FormPK();
     formPK.setCodeMenu(codeMenu);
     formPK.setControl(control);
     formPK.setForm(form);
     formPK.setModule(module);
     log.debug("Request to get FormDTO: {}",formPK);
     Form form1= formRepository.findOne(formPK);
     FormDTO formDTO = FormFactory.formToFormDTO(form1);
     return formDTO;
    }
    
}
