/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Form;
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

    private final FormRepository fRepository;

    public FormService(FormRepository formRepository) {
       this.fRepository=formRepository;
    }
    
    @Transactional(
      readOnly = true
    )
    public List<FormDTO> findAllDTO() {
     log.debug("Request to get All DemandeForms");
     List<Form> result= fRepository.findAll();
     
     return FormFactory.formToFormDTOs(result,false);
    }
    
    @Transactional(
      readOnly = true
    )
    public List<Form> findAll() {
     log.debug("Request to get All DemandeForms");
     List<Form> result= fRepository.findAll();
     return (result);
    }
    
}
