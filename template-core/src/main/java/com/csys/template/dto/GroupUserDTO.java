/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import java.util.Collection;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class GroupUserDTO {
    
    @NotNull
    @Size(min = 1, max = 10)
    private String grp;
    @Size(max = 50)
    private String description;
    @Column(name = "Actif")
    private Boolean actif;
    private Collection<ModuleDTO> moduleCollection;
    private Collection<DemandeDTO> demandeCollection;
    private Collection<AccessMenuDTO> accessMenuCollection;
    private Collection<AccessFormDTO> accessFormCollection;
    private Collection<AccessControlDTO> accessControlCollection;

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Collection<ModuleDTO> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<ModuleDTO> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    public Collection<DemandeDTO> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<DemandeDTO> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    public Collection<AccessMenuDTO> getAccessMenuCollection() {
        return accessMenuCollection;
    }

    public void setAccessMenuCollection(Collection<AccessMenuDTO> accessMenuCollection) {
        this.accessMenuCollection = accessMenuCollection;
    }

    public Collection<AccessFormDTO> getAccessFormCollection() {
        return accessFormCollection;
    }

    public void setAccessFormCollection(Collection<AccessFormDTO> accessFormCollection) {
        this.accessFormCollection = accessFormCollection;
    }

    public Collection<AccessControlDTO> getAccessControlCollection() {
        return accessControlCollection;
    }

    public void setAccessControlCollection(Collection<AccessControlDTO> accessControlCollection) {
        this.accessControlCollection = accessControlCollection;
    }
    

}
