/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import com.csys.template.domain.EtatDemandeEnum;
import java.time.LocalDate;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class DemandeDTO {

    @NotNull
    @Size(min = 1, max = 20)
    private String codeDemande;
    @NotNull
    @Size(min = 1, max = 20)
    private String userName;
    @NotNull
    @Size(min = 1, max = 10)
    private String userGrp;
    @NotNull
    @Size(max = 10)
    private LocalDate dateCreation;
    @NotNull
    @Size(max = 10)
    private LocalDate dateValidation;
    @NotNull
    @Size(max = 20)
    private String userValidation;
    @NotNull
    @Size(max = 20)
    private String userCreate;
    private EtatDemandeEnum etat;
    @Size(max = 255)
    private String message;
    private AccessControlDTO accessControl;
    private GroupUserDTO groupUser;
    private Collection<DemandeModuleDTO> demandeModuleCollection;

    private Collection<DemandeFormDTO> demandeFormCollection;
    private Collection<DemandeMenuDTO> demandeMenuCollection;
    public AccessControlDTO getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControlDTO accessControl) {
        this.accessControl = accessControl;
    }

    public GroupUserDTO getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUserDTO groupUser) {
        this.groupUser = groupUser;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGrp() {
        return userGrp;
    }

    public void setUserGrp(String userGrp) {
        this.userGrp = userGrp;
    }

    public String getUserValidation() {
        return userValidation;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDate dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setUserValidation(String userValidation) {
        this.userValidation = userValidation;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

   

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EtatDemandeEnum getEtat() {
        return etat;
    }

    public void setEtat(EtatDemandeEnum etat) {
        this.etat = etat;
    }

    public Collection<DemandeModuleDTO> getDemandeModuleCollection() {
        return demandeModuleCollection;
    }

    public void setDemandeModuleCollection(Collection<DemandeModuleDTO> demandeModuleCollection) {
        this.demandeModuleCollection = demandeModuleCollection;
    }

    public Collection<DemandeFormDTO> getDemandeFormCollection() {
        return demandeFormCollection;
    }

    public void setDemandeFormCollection(Collection<DemandeFormDTO> demandeFormCollection) {
        this.demandeFormCollection = demandeFormCollection;
    }

    public Collection<DemandeMenuDTO> getDemandeMenuCollection() {
        return demandeMenuCollection;
    }

    public void setDemandeMenuCollection(Collection<DemandeMenuDTO> demandeMenuCollection) {
        this.demandeMenuCollection = demandeMenuCollection;
    }

}
