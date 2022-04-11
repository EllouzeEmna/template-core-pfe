/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.GroupUser;
import com.csys.template.domain.QAccessControl;
import com.csys.template.domain.QGroupUser;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.factory.AccessControlFactory;
import com.csys.template.factory.GroupUserFactory;
import com.csys.template.repository.GroupUserRepository;
import com.csys.template.util.WhereClauseBuilder;
import java.util.ArrayList;
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
public class GroupUserService {

    private final Logger log = LoggerFactory.getLogger(GroupUserService.class);

    private final GroupUserRepository grpUserRepository;

    public GroupUserService(GroupUserRepository grRepository) {
        this.grpUserRepository = grRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<GroupUserDTO> findAllDTO() {
        log.debug("Request to get All DemandeForms");
        List<GroupUser> result = grpUserRepository.findAll();

        return GroupUserFactory.groupUserToGroupUserDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public ArrayList<GroupUserDTO> findAllDTO(Boolean[] actifs, String group, String description) {
        log.debug("Request to get All DemandeForms");
        QGroupUser qGroupUser = QGroupUser.groupUser;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(actifs, () -> qGroupUser.actif.in(actifs))
                .optionalAnd(group, () -> qGroupUser.grp.eq(group))
                .optionalAnd(description, () -> qGroupUser.description.eq(description));
        List<GroupUser> result =  (List<GroupUser>) grpUserRepository.findAll(builder);

        return (ArrayList<GroupUserDTO>) GroupUserFactory.groupUserToGroupUserDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public GroupUserDTO findGroupUserDTO(String grp) {

        log.debug("Request to get GroupUserDTO: {}", grp);
        GroupUser grpUser = grpUserRepository.findByGrp(grp);
        GroupUserDTO grpUserDTO = GroupUserFactory.groupUserToGroupUserDTO(grpUser);
        return grpUserDTO;
    }
}
