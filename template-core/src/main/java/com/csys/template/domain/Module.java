/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "Module", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NumModule", "DesModule"})})
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "NumModule", nullable = false, length = 3)
    private String numModule;
    @Size(max = 100)
    @Column(name = "DesModule", length = 100)
    private String desModule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Chemin", nullable = false, length = 50)
    private String chemin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Afficher", nullable = false)
    private boolean afficher;
    @Lob
    @Column(name = "Image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NomImage", nullable = false, length = 50)
    private String nomImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Version_Database", nullable = false, length = 50)
    private String versionDatabase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "urlWeb", nullable = false, length = 150)
    private String urlWeb;
    @Size(max = 50)
    @Column(name = "Version_Module", length = 50)
    private String versionModule;
    @ManyToMany(mappedBy = "moduleCollection")
    private Collection<GroupUser> groupUserCollection;
    @ManyToMany(mappedBy = "moduleCollection")
    private Collection<AccessControl> accessControlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private Collection<DemandeModule> demandeModuleCollection;

    public Module() {
    }

    public Module(String numModule) {
        this.numModule = numModule;
    }

    public Module(String numModule, String chemin, boolean afficher, String nomImage, String versionDatabase, String urlWeb) {
        this.numModule = numModule;
        this.chemin = chemin;
        this.afficher = afficher;
        this.nomImage = nomImage;
        this.versionDatabase = versionDatabase;
        this.urlWeb = urlWeb;
    }

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

    public boolean getAfficher() {
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

    public Collection<GroupUser> getGroupUserCollection() {
        return groupUserCollection;
    }

    public void setGroupUserCollection(Collection<GroupUser> groupUserCollection) {
        this.groupUserCollection = groupUserCollection;
    }

    public Collection<AccessControl> getAccessControlCollection() {
        return accessControlCollection;
    }

    public void setAccessControlCollection(Collection<AccessControl> accessControlCollection) {
        this.accessControlCollection = accessControlCollection;
    }

    public Collection<DemandeModule> getDemandeModuleCollection() {
        return demandeModuleCollection;
    }

    public void setDemandeModuleCollection(Collection<DemandeModule> demandeModuleCollection) {
        this.demandeModuleCollection = demandeModuleCollection;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numModule != null ? numModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.numModule == null && other.numModule != null) || (this.numModule != null && !this.numModule.equals(other.numModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.Module[ numModule=" + numModule + " ]";
    }
    
}
