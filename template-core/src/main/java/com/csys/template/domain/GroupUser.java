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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "GroupUser")
@NamedQueries({
    @NamedQuery(name = "GroupUser.findAll", query = "SELECT g FROM GroupUser g")})
public class GroupUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Grp", nullable = false, length = 10)
    private String grp;
    @Size(max = 50)
    @Column(name = "Description", length = 50)
    private String description;
    @Column(name = "Actif")
    private Boolean actif;
    @JoinTable(name = "Access_Module", joinColumns = {
        @JoinColumn(name = "grp", referencedColumnName = "Grp", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "module", referencedColumnName = "NumModule", nullable = false)})
    @ManyToMany
    private Collection<Module> moduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupUser")
    private Collection<Demande> demandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupUser")
    private Collection<AccessMenu> accessMenuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupUser")
    private Collection<AccessForm> accessFormCollection;
    @OneToMany(mappedBy = "groupUsers")
    private Collection<AccessControl> accessControlCollection;

    public GroupUser() {
    }

    public GroupUser(String grp) {
        this.grp = grp;
    }

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

    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    public Collection<Demande> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demande> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    public Collection<AccessMenu> getAccessMenuCollection() {
        return accessMenuCollection;
    }

    public void setAccessMenuCollection(Collection<AccessMenu> accessMenuCollection) {
        this.accessMenuCollection = accessMenuCollection;
    }

    public Collection<AccessForm> getAccessFormCollection() {
        return accessFormCollection;
    }

    public void setAccessFormCollection(Collection<AccessForm> accessFormCollection) {
        this.accessFormCollection = accessFormCollection;
    }

    public Collection<AccessControl> getAccessControlCollection() {
        return accessControlCollection;
    }

    public void setAccessControlCollection(Collection<AccessControl> accessControlCollection) {
        this.accessControlCollection = accessControlCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grp != null ? grp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupUser)) {
            return false;
        }
        GroupUser other = (GroupUser) object;
        if ((this.grp == null && other.grp != null) || (this.grp != null && !this.grp.equals(other.grp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.GroupUser[ grp=" + grp + " ]";
    }
    
}
