/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.service;

import com.csys.template.domain.AccessControl;
import com.csys.template.domain.GroupUser;
import com.csys.template.domain.QAccessControl;
import com.csys.template.dto.AccessControlDTO;
import com.csys.template.dto.AccessFormUserDTO;
import com.csys.template.dto.AccessMenuUserDTO;
import com.csys.template.dto.DemandeDTO;
import com.csys.template.dto.GroupUserDTO;
import com.csys.template.dto.ModuleDTO;
import com.csys.template.factory.AccessControlFactory;
import com.csys.template.factory.AccessFormUserFactory;
import com.csys.template.factory.AccessMenuUserFactory;
import com.csys.template.factory.DemandeFactory;
import com.csys.template.factory.ModuleFactory;
import com.csys.template.repository.AccessControleRepository;
import com.csys.template.util.Preconditions;
import com.csys.template.util.WhereClauseBuilder;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 21694
 */
@Service
@Transactional
public class AccessControlService {

    private final Logger log = LoggerFactory.getLogger(AccessControlService.class);

    private final AccessControleRepository accessControlRepository;

    @Lazy
    @Autowired
    GroupUserService groupUserService;

    public AccessControlService(AccessControleRepository accessControlRepository) {
        this.accessControlRepository = accessControlRepository;
    }

    @Transactional(
            readOnly = true
    )
    public List<AccessControl> findAll(Boolean[] actifs, Boolean[] personalises, String group, String[] userNames) {
        log.debug("Request to get All DemandeForms");
        QAccessControl qAccessControl = QAccessControl.accessControl;
        WhereClauseBuilder builder;
        builder = new WhereClauseBuilder()
                .optionalAnd(actifs, () -> qAccessControl.actif.in(actifs))
                .optionalAnd(personalises, () -> qAccessControl.accessMenuUserCollection.any().personalise.in(personalises))
                .optionalAnd(group, () -> qAccessControl.groupUsers.any().grp.eq(group))
                .optionalAnd(userNames, () -> qAccessControl.userName.in(userNames));
        List<AccessControl> result = (List<AccessControl>) accessControlRepository.findAll(builder);

        return result;
    }

    @Transactional(
            readOnly = true
    )
    public List<AccessControlDTO> findAllDTO(Boolean[] actifs, Boolean[] personalises, String group, String[] userNames) {
        return AccessControlFactory.accessControlToAccessControlDTOs(findAll(actifs, personalises, group, userNames), true);
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

    public AccessControlDTO save(AccessControlDTO accessControlDTO) {
        AccessControl accessControlInBase = accessControlRepository.findByUserName(accessControlDTO.getUserName());
        log.error("accessControlInBase {}", accessControlInBase);
        Preconditions.checkBusinessLogique(accessControlInBase == null, "accessControl exist.");
        String[] grps = accessControlDTO.getGroupUsers().stream().map(GroupUserDTO::getGrp).toArray(String[]::new);
        List<GroupUser> groupUsers = groupUserService.findAll(null, null, null, true, grps);

        AccessControl accessControl = AccessControlFactory.accessControlDTOToAccessControl(accessControlDTO);
        for (GroupUserDTO groupUserDTO : accessControlDTO.getGroupUsers()) {
            GroupUser groupUser = groupUsers.stream().filter(x -> x.getGrp().equals(groupUserDTO.getGrp())).findFirst().orElse(null);
            Preconditions.checkBusinessLogique(groupUser != null, "Le groupe " + groupUserDTO.getGrp() + " est inexistant.");
            List<AccessControl> accessControls = (List<AccessControl>) groupUser.getAccessControlCollection();
            accessControls.add(accessControl);
            groupUser.setAccessControlCollection(accessControls);
            //accessControl.setGroupUsers(groupUsers);

        }
        accessControl = accessControlRepository.save(accessControl);
        return AccessControlFactory.accessControlToAccessControlDTO(accessControl, true);
    }

    public AccessControlDTO update(AccessControlDTO accessControlDTO) {
        AccessControl accessControlInBase = accessControlRepository.findByUserName(accessControlDTO.getUserName());
        log.error("accessControlInBase {}", accessControlInBase);
        Preconditions.checkBusinessLogique(accessControlInBase != null, "accessControl exist.");
        String[] grps = accessControlDTO.getGroupUsers().stream().map(GroupUserDTO::getGrp).toArray(String[]::new);
        List<GroupUser> groupUsers = groupUserService.findAll(null, null, null, true, grps);

        AccessControl accessControl = AccessControlFactory.accessControlDTOToAccessControl(accessControlDTO);
        for (GroupUserDTO groupUserDTO : accessControlDTO.getGroupUsers()) {
            GroupUser groupUser = groupUsers.stream().filter(x -> x.getGrp().equals(groupUserDTO.getGrp())).findFirst().orElse(null);
            Preconditions.checkBusinessLogique(groupUser != null, "Le groupe " + groupUserDTO.getGrp() + " est inexistant.");
            List<AccessControl> accessControls = (List<AccessControl>) groupUser.getAccessControlCollection();
            accessControls.add(accessControl);
            groupUser.setAccessControlCollection(accessControls);
            //accessControl.setGroupUsers(groupUsers);

        }
        accessControl.setAccessFormUserCollection(AccessFormUserFactory.accessFormUserDTOToAccessFormUsers((List<AccessFormUserDTO>) accessControlDTO.getAccessFormUserCollection()));
        accessControl.setAccessMenuUserCollection(AccessMenuUserFactory.accessMenuUserDTOToAccessMenuUsers((List<AccessMenuUserDTO>) accessControlDTO.getAccessMenuUserCollection()));
        accessControl.setModuleCollection(ModuleFactory.moduleDTOToModules((List<ModuleDTO>) accessControlDTO.getModuleCollection()));
        if (accessControlDTO.getDemandeCollection() != null) {
            accessControl.setDemandeCollection(DemandeFactory.demandeDTOToDemandes((List<DemandeDTO>) accessControlDTO.getDemandeCollection()));
        }
        accessControl = accessControlRepository.save(accessControl);
        return AccessControlFactory.accessControlToAccessControlDTO(accessControl, true);
    }

    public void delete(String userName) {
        AccessControl accessControl = accessControlRepository.findOne(userName);
        Preconditions.checkFound(accessControl == null, "Utilisateur est inexistante.");
        Preconditions.checkBusinessLogique(accessControl.getGroupUsers() != null, "utilisateur appartient dans un autre.");

        accessControlRepository.delete(accessControl);
    }
}
