/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "ACCESS_MENU_USER")
@NamedQueries({
    @NamedQuery(name = "AccessMenuUser.findAll", query = "SELECT a FROM AccessMenuUser a")})
public class AccessMenuUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessMenuUserPK accessMenuUserPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISIBLE", nullable = false)
    private boolean visible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personalise", nullable = false)
    private boolean personalise;
    @JoinColumn(name = "[User]", referencedColumnName = "UserName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AccessControl accessControl;
    @JoinColumns({
        @JoinColumn(name = "Module", referencedColumnName = "Module", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "MENU", referencedColumnName = "CodMnp", nullable = false, insertable = false, updatable = false)})
 
     @ManyToOne(optional = false)
    private MenuP menuP;

    public MenuP getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuP menuP) {
        this.menuP = menuP;
    }

    public AccessMenuUser() {
    }

    public AccessMenuUser(AccessMenuUserPK accessMenuUserPK) {
        this.accessMenuUserPK = accessMenuUserPK;
    }

    public AccessMenuUser(AccessMenuUserPK accessMenuUserPK, boolean visible, boolean personalise) {
        this.accessMenuUserPK = accessMenuUserPK;
        this.visible = visible;
        this.personalise = personalise;
    }

    public AccessMenuUser(String module, String user, String menu) {
        this.accessMenuUserPK = new AccessMenuUserPK(module, user, menu);
    }

    public AccessMenuUserPK getAccessMenuUserPK() {
        return accessMenuUserPK;
    }

    public void setAccessMenuUserPK(AccessMenuUserPK accessMenuUserPK) {
        this.accessMenuUserPK = accessMenuUserPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getPersonalise() {
        return personalise;
    }

    public void setPersonalise(boolean personalise) {
        this.personalise = personalise;
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessMenuUserPK != null ? accessMenuUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenuUser)) {
            return false;
        }
        AccessMenuUser other = (AccessMenuUser) object;
        if ((this.accessMenuUserPK == null && other.accessMenuUserPK != null) || (this.accessMenuUserPK != null && !this.accessMenuUserPK.equals(other.accessMenuUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessMenuUser[ accessMenuUserPK=" + accessMenuUserPK + " ]";
    }
    
}
