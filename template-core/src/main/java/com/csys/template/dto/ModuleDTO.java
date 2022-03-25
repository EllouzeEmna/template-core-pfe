/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class ModuleDTO {
    @NotNull
    @Size(min = 1, max = 3)
    private String numModule;
    @Size(max = 100)
    private String desModule;
    @NotNull
    @Size(min = 1, max = 50)
    private String chemin;
    @NotNull
    private boolean afficher;
    private byte[] image;
    @NotNull
    @Size(min = 1, max = 50)
    private String nomImage;
    @NotNull
    @Size(min = 1, max = 50)
    private String versionDatabase;
    @NotNull
    @Size(min = 1, max = 150)
    private String urlWeb;
    @Size(max = 50)
    private String versionModule;
    private Collection<GroupUserDTO> groupUserCollection;
    private Collection<AccessControlDTO> accessControlCollection;

    public String getNumModule() {
        return numModule;
    }

    public void setNumModule(String numModule) {
        this.numModule = numModule;
    }

    public String getDesModule() {
        return desModule;
    }

    public void setDesModule(String desModule) {
        this.desModule = desModule;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public boolean isAfficher() {
        return afficher;
    }

    public void setAfficher(boolean afficher) {
        this.afficher = afficher;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public String getVersionDatabase() {
        return versionDatabase;
    }

    public void setVersionDatabase(String versionDatabase) {
        this.versionDatabase = versionDatabase;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getVersionModule() {
        return versionModule;
    }

    public void setVersionModule(String versionModule) {
        this.versionModule = versionModule;
    }

    public Collection<GroupUserDTO> getGroupUserCollection() {
        return groupUserCollection;
    }

    public void setGroupUserCollection(Collection<GroupUserDTO> groupUserCollection) {
        this.groupUserCollection = groupUserCollection;
    }

    public Collection<AccessControlDTO> getAccessControlCollection() {
        return accessControlCollection;
    }

    public void setAccessControlCollection(Collection<AccessControlDTO> accessControlCollection) {
        this.accessControlCollection = accessControlCollection;
    }

    
}
