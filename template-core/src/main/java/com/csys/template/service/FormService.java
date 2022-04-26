/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.Form;
import com.csys.template.domain.FormPK;
import com.csys.template.domain.MenuP;
import com.csys.template.domain.QForm;
import com.csys.template.domain.QMenuP;
import com.csys.template.dto.FormDTO;
import com.csys.template.dto.MenuPDTO;
import com.csys.template.factory.FormFactory;
import com.csys.template.factory.MenuPFactory;
import com.csys.template.repository.FormRepository;
import com.csys.template.util.WhereClauseBuilder;
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
        this.formRepository = formRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<FormDTO> findAllDTO() {
        log.debug("Request to get All Form");
        List<Form> result = formRepository.findAll();

        return FormFactory.formToFormDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public List<FormDTO> findFormDTO(String module, String form, String control, String codeMenu) {
        log.debug("Request to get All Forms");
        QForm qForm = QForm.form;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
            .optionalAnd(form, () -> qForm.formPK().module.eq(form))
            .optionalAnd(module, () -> qForm.formPK().module.eq(module))
            .optionalAnd(control, () -> qForm.formPK().control.eq(control))
            .optionalAnd(codeMenu, () -> qForm.formPK().codeMenu.eq(codeMenu));

        List<Form> result = (List<Form>) formRepository.findAll(builder);

        return (List<FormDTO>) FormFactory.formToFormDTOs(result);
    }

}
