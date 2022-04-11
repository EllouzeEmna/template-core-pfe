/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class AccessControlDTO {

    @NotNull
    @Size(min = 1, max = 20)
    private String userName;
    @Size(max = 40)
    private String description;
    @Size(max = 10)
    private String passWord;
    @Size(max = 10)
    private String codemedecininfirmier;
    @NotNull
    private boolean actif;
    private Collection<ModuleDTO> moduleCollection;
    private Collection<AccessFormUserDTO> accessFormUserCollection;
    private Collection<DemandeDTO> demandeCollection;
    private GroupUserDTO groupUser;
    private Collection<AccessMenuUserDTO> accessMenuUserCollection;
    private CliniqueDTO clinique;

    public CliniqueDTO getClinique() {
        return clinique;
    }

    public void setClinique(CliniqueDTO clinique) {
        this.clinique = clinique;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCodemedecininfirmier() {
        return codemedecininfirmier;
    }

    public void setCodemedecininfirmier(String codemedecininfirmier) {
        this.codemedecininfirmier = codemedecininfirmier;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    

    public Collection<ModuleDTO> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<ModuleDTO> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    public Collection<AccessFormUserDTO> getAccessFormUserCollection() {
        return accessFormUserCollection;
    }

    public void setAccessFormUserCollection(Collection<AccessFormUserDTO> accessFormUserCollection) {
        this.accessFormUserCollection = accessFormUserCollection;
    }

    public Collection<DemandeDTO> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<DemandeDTO> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    public GroupUserDTO getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUserDTO groupUser) {
        this.groupUser = groupUser;
    }

    public Collection<AccessMenuUserDTO> getAccessMenuUserCollection() {
        return accessMenuUserCollection;
    }

    public void setAccessMenuUserCollection(Collection<AccessMenuUserDTO> accessMenuUserCollection) {
        this.accessMenuUserCollection = accessMenuUserCollection;
    }

}
