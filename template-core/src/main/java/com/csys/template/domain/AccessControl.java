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
import javax.persistence.ManyToOne;
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
@Table(name = "[Access Control]", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"UserName", "Grp", "Description"})})
@NamedQueries({
    @NamedQuery(name = "AccessControl.findAll", query = "SELECT a FROM AccessControl a")})
public class AccessControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UserName", nullable = false, length = 20)
    private String userName;
    @Size(max = 40)
    @Column(name = "Description", length = 40)
    private String description;
    @Size(max = 10)
    @Column(name = "PassWord", length = 10)
    private String passWord;
    @Size(max = 10)
    @Column(name = "Code_medecin_infirmier", length = 10)
    private String codemedecininfirmier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif", nullable = false)
    private boolean actif;
    @JoinTable(name = "Access_Module_user", joinColumns = {
        @JoinColumn(name = "[user]", referencedColumnName = "UserName", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "module", referencedColumnName = "NumModule", nullable = false)})
    @ManyToMany
    private Collection<Module> moduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessControl")
    private Collection<AccessFormUser> accessFormUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessControl")
    private Collection<Demande> demandeCollection;
    @JoinColumn(name = "Grp", referencedColumnName = "Grp")
    @ManyToOne
    private GroupUser groupUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessControl")
    private Collection<AccessMenuUser> accessMenuUserCollection;
    @JoinColumn(name = "code_clinique", referencedColumnName = "code_clinique")
    @ManyToOne
    private Clinique clinique;

    public Clinique getClinique() {
        return clinique;
    }

    public void setClinique(Clinique clinique) {
        this.clinique = clinique;
    }
    
    public AccessControl() {
    }

    public AccessControl(String userName) {
        this.userName = userName;
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

   

    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    public Collection<AccessFormUser> getAccessFormUserCollection() {
        return accessFormUserCollection;
    }

    public void setAccessFormUserCollection(Collection<AccessFormUser> accessFormUserCollection) {
        this.accessFormUserCollection = accessFormUserCollection;
    }

    public Collection<Demande> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demande> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    public GroupUser getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUser groupUser) {
        this.groupUser = groupUser;
    }

    public Collection<AccessMenuUser> getAccessMenuUserCollection() {
        return accessMenuUserCollection;
    }

    public void setAccessMenuUserCollection(Collection<AccessMenuUser> accessMenuUserCollection) {
        this.accessMenuUserCollection = accessMenuUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessControl)) {
            return false;
        }
        AccessControl other = (AccessControl) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessControl[ userName=" + userName + " ]";
    }
    
}
