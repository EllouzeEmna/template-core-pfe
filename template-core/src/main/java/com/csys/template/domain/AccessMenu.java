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
@Table(name = "ACCESS_MENU")
@NamedQueries({
    @NamedQuery(name = "AccessMenu.findAll", query = "SELECT a FROM AccessMenu a")})
public class AccessMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessMenuPK accessMenuPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISIBLE", nullable = false)
    private boolean visible;
    @JoinColumn(name = "Grp", referencedColumnName = "Grp", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupUser groupUser;
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

    public AccessMenu() {
    }

    public AccessMenu(AccessMenuPK accessMenuPK) {
        this.accessMenuPK = accessMenuPK;
    }

    public AccessMenu(AccessMenuPK accessMenuPK, boolean visible) {
        this.accessMenuPK = accessMenuPK;
        this.visible = visible;
    }

    public AccessMenu(String module, String grp, String menu) {
        this.accessMenuPK = new AccessMenuPK(module, grp, menu);
    }

    public AccessMenuPK getAccessMenuPK() {
        return accessMenuPK;
    }

    public void setAccessMenuPK(AccessMenuPK accessMenuPK) {
        this.accessMenuPK = accessMenuPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public GroupUser getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUser groupUser) {
        this.groupUser = groupUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessMenuPK != null ? accessMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenu)) {
            return false;
        }
        AccessMenu other = (AccessMenu) object;
        if ((this.accessMenuPK == null && other.accessMenuPK != null) || (this.accessMenuPK != null && !this.accessMenuPK.equals(other.accessMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessMenu[ accessMenuPK=" + accessMenuPK + " ]";
    }
    
}
