/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.GroupUser;
import com.csys.template.domain.QGroupUser;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.AccessFormDTO;
import com.csys.template.dto.AccessMenuDTO;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.dto.ModuleDTO;
import com.csys.template.factory.AccessFormFactory;
import com.csys.template.factory.AccessMenuFactory;
import com.csys.template.factory.DemandeFactory;
import com.csys.template.factory.GroupUserFactory;
import com.csys.template.factory.ModuleFactory;
import com.csys.template.repository.GroupUserRepository;
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
public class GroupUserService {

    private final Logger log = LoggerFactory.getLogger(GroupUserService.class);

    private final GroupUserRepository grpUserRepository;
    private final AccessControlService accessControlService;

    public GroupUserService(GroupUserRepository grpUserRepository, AccessControlService accessControlService) {
        this.grpUserRepository = grpUserRepository;
        this.accessControlService = accessControlService;
    }

    

    @Transactional(
            readOnly = true
    )
    public List<GroupUser> findAll(Boolean[] actifs, String group, String description, boolean lazy,
            String[] groupUsers) {
        log.debug("Request to get All DemandeForms");
        QGroupUser qGroupUser = QGroupUser.groupUser;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(actifs, () -> qGroupUser.actif.in(actifs))
                .optionalAnd(group, () -> qGroupUser.grp.eq(group))
                .optionalAnd(description, () -> qGroupUser.description.eq(description))
                .optionalAnd(groupUsers, () -> qGroupUser.grp.in(groupUsers));

        List<GroupUser> result = (List<GroupUser>) grpUserRepository.findAll(builder);

        return result;
    }
  @Transactional(
            readOnly = true
    )
    public List<GroupUserDTO> findAllDTO(Boolean[] actifs, String group, String description, boolean lazy,
            String[] groupUsers) {
        return (List<GroupUserDTO>) GroupUserFactory.groupUserToGroupUserDTOs(findAll(actifs,group,description,lazy,groupUsers), lazy);
    }
    @Transactional(
            readOnly = true
    )
    public GroupUserDTO findGroupUserDTO(String grp) {

        log.debug("Request to get GroupUserDTO: {}", grp);
        GroupUser grpUser = grpUserRepository.findOne(grp);
        GroupUserDTO grpUserDTO = GroupUserFactory.groupUserToGroupUserDTO(grpUser, false);
        return grpUserDTO;
    }

//    public GroupUserDTO save(GroupUserDTO groupUserDTO) {
//        GroupUser groupUserInBase = grpUserRepository.findOne(groupUserDTO.getGrp());
//        log.error("groupUserInBase {}", groupUserInBase);
//        Preconditions.checkBusinessLogique(groupUserInBase == null, "Le code groupe existe déja.");
//        String[] userNames = groupUserDTO.getAccessControlCollection().stream().map(AccessControlDTO::getUserName).toArray(String[]::new);
//        List<AccessControl> accessControls = accessControlService.findAll(null, null, null, userNames);
//
//        GroupUser groupUser = GroupUserFactory.groupUserDTOToGroupUser(groupUserDTO);
//        for (AccessControlDTO accessControlDTO : groupUserDTO.getAccessControlCollection()) {
//            AccessControl accessControl = accessControls.stream().filter(x -> x.getUserName().equals(accessControlDTO.getUserName())).findFirst().orElse(null);
//            Preconditions.checkBusinessLogique(accessControl != null, "Le utilisateur " + accessControlDTO.getUserName() + " est inexistant.");
//            List<GroupUser> groupUsers = (List<GroupUser>) accessControl.getGroupUsers();
//            groupUsers.add(groupUser);
//            accessControl.setGroupUsers(groupUsers);
//            //groupUser.setAccessControlCollection(accessControls);
//
//        }
//        groupUser = grpUserRepository.save(groupUser);
//        return GroupUserFactory.groupUserToGroupUserDTO(groupUser, false);
//    }

//    public GroupUserDTO update(GroupUserDTO groupUserDTO) {
//        GroupUser groupUserInBase = grpUserRepository.findOne(groupUserDTO.getGrp());
//        log.error("groupUserInBase {}", groupUserInBase);
//        Preconditions.checkBusinessLogique(groupUserInBase != null, "grpUser est inexistant.");
//        String[] userNames = groupUserDTO.getAccessControlCollection().stream().map(AccessControlDTO::getUserName).toArray(String[]::new);
//        List<AccessControl> accessControls = accessControlService.findAll(null, null, null, userNames);
//
//        GroupUser groupUser = GroupUserFactory.groupUserDTOToGroupUser(groupUserDTO);
//        for (AccessControlDTO accessControlDTO : groupUserDTO.getAccessControlCollection()) {
//            AccessControl accessControl = accessControls.stream().filter(x -> x.getUserName().equals(accessControlDTO.getUserName())).findFirst().orElse(null);
//            Preconditions.checkBusinessLogique(accessControl != null, "Le utilisateur " + accessControlDTO.getUserName() + " est inexistant.");
//            List<GroupUser> groupUsers = (List<GroupUser>) accessControl.getGroupUsers();
//            groupUsers.add(groupUser);
//            accessControl.setGroupUsers(groupUsers);
//            //groupUser.setAccessControlCollection(accessControls);
//        }
//        if (groupUserDTO.getDemandeCollection() != null) {
//            groupUser.setDemandeCollection(DemandeFactory.demandeDTOToDemandes((List<DemandeDTO>) groupUserDTO.getDemandeCollection()));
//        }
//        groupUser.setAccessFormCollection(AccessFormFactory.accessFormDTOToAccessForms((List<AccessFormDTO>) groupUserDTO.getAccessFormCollection()));
//        groupUser.setAccessMenuCollection(AccessMenuFactory.accessMenuDTOToAccessMenus((List<AccessMenuDTO>) groupUserDTO.getAccessMenuCollection()));
//        groupUser.setModuleCollection(ModuleFactory.moduleDTOToModules((List<ModuleDTO>) groupUserDTO.getModuleCollection()));
//
//        groupUser = grpUserRepository.save(groupUser);
//        return GroupUserFactory.groupUserToGroupUserDTO(groupUser, false);
//    }

    public void delete(String grp) {
        GroupUser groupUser = grpUserRepository.findOne(grp);
        Preconditions.checkBusinessLogique(groupUser != null, "grpUser est inexistante.");
        Preconditions.checkBusinessLogique(groupUser.getAccessControlCollection() != null, "grpUser contient des utilisateurs.");

        grpUserRepository.delete(groupUser);
    }
}
