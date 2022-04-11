/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.QAccessControl;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.factory.AccessControlFactory;
import com.csys.template.repository.AccessControleRepository;
import com.csys.template.util.Preconditions;
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
public class ControlService {

    private final Logger log = LoggerFactory.getLogger(ControlService.class);

    private final AccessControleRepository accessControlRepository;

    public ControlService(AccessControleRepository accessControlRepository) {
        this.accessControlRepository = accessControlRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<AccessControlDTO> findAllDTO(Boolean[] actifs, Boolean[] personalises, String group) {
        log.debug("Request to get All DemandeForms");
        QAccessControl qAccessControl = QAccessControl.accessControl;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(actifs, () -> qAccessControl.actif.in(actifs))
                .optionalAnd(personalises, () -> qAccessControl.accessMenuUserCollection.any().personalise.in(personalises))
                .optionalAnd(group, () -> qAccessControl.groupUser().grp.eq(group));
        List<AccessControl> result = (List<AccessControl>) accessControlRepository.findAll(builder);

        return AccessControlFactory.accessControlToAccessControlDTOs(result, true);
    }

    @Transactional(
            readOnly = true
    )
    public AccessControlDTO findAccessControlDTO(String userName) {

        log.debug("Request to get AccessControlDTO: {}", userName);
        AccessControl accessControl = accessControlRepository.findOne(userName);
        Preconditions.checkBusinessLogique(accessControl != null, "L'utilasateur est inexistant.");
        AccessControlDTO accessControlDTO = AccessControlFactory.accessControlToAccessControlDTO(accessControl, false);
        return accessControlDTO;
    }

}
