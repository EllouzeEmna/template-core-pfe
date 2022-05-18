/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "demande", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code_demande"})})
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_demande", nullable = false, length = 20)
    private String codeDemande;
    @NotNull
    @Column(name = "date_creation")
    private LocalDate dateCreation;
    @NotNull
    @Column(name = "date_validation")
    private LocalDate dateValidation;
    @Size(max = 20)
    @Column(name = "user_validation", length = 20)
    private String userValidation;
    @Size(max = 20)
    @Column(name = "user_create", length = 20)
    private String userCreate;
    @Column(name = "valider")
    private EtatDemandeEnum etat;
    @Size(max = 255)
    @Column(name = "message", length = 255)
    private String message;
    @Size(max = 20)
    @Column(name = "user_name", length = 20)
    private String userName;
    @Size(max = 20)
    @Column(name = "user_grp", length = 20)
    private String userGrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demande")
    private Collection<DemandeModule> demandeModuleCollection;
    @JoinColumn(name = "user_name", referencedColumnName = "UserName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AccessControl accessControl;
    @JoinColumn(name = "user_grp", referencedColumnName = "Grp", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupUser groupUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demande")
    private Collection<DemandeForm> demandeFormCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demande")
    private Collection<DemandeMenu> demandeMenuCollection;

    public Demande() {
    }

    public Demande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
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

    public String getUserValidation() {
        return userValidation;
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

    public EtatDemandeEnum getEtat() {
        return etat;
    }

    public void setEtat(EtatDemandeEnum valider) {
        this.etat = valider;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public GroupUser getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUser groupUser) {
        this.groupUser = groupUser;
    }

    public Collection<DemandeModule> getDemandeModuleCollection() {
        return demandeModuleCollection;
    }

    public void setDemandeModuleCollection(Collection<DemandeModule> demandeModuleCollection) {
        this.demandeModuleCollection = demandeModuleCollection;
    }

    public Collection<DemandeForm> getDemandeFormCollection() {
        return demandeFormCollection;
    }

    public void setDemandeFormCollection(Collection<DemandeForm> demandeFormCollection) {
        this.demandeFormCollection = demandeFormCollection;
    }

    public Collection<DemandeMenu> getDemandeMenuCollection() {
        return demandeMenuCollection;
    }

    public void setDemandeMenuCollection(Collection<DemandeMenu> demandeMenuCollection) {
        this.demandeMenuCollection = demandeMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDemande != null ? codeDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.codeDemande == null && other.codeDemande != null) || (this.codeDemande != null && !this.codeDemande.equals(other.codeDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.Demande[ codeDemande=" + codeDemande + " ]";
    }
    
}
