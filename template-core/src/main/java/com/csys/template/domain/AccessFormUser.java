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
@Table(name = "ACCESS_FORM_USER")
@NamedQueries({
    @NamedQuery(name = "AccessFormUser.findAll", query = "SELECT a FROM AccessFormUser a")})
public class AccessFormUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessFormUserPK accessFormUserPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visible", nullable = false)
    private boolean visible;
    @JoinColumn(name = "[User]", referencedColumnName = "UserName", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AccessControl accessControl;
    @JoinColumns({
        @JoinColumn(name = "Module", referencedColumnName = "Module", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Form", referencedColumnName = "Form", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Control", referencedColumnName = "Control", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_menu", referencedColumnName = "code_menu", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Form form1;

    public AccessFormUser() {
    }

    public AccessFormUser(AccessFormUserPK accessFormUserPK) {
        this.accessFormUserPK = accessFormUserPK;
    }

    public AccessFormUser(AccessFormUserPK accessFormUserPK, boolean visible) {
        this.accessFormUserPK = accessFormUserPK;
        this.visible = visible;
    }

    public AccessFormUser(String module, String user, String form, String control, String codeMenu) {
        this.accessFormUserPK = new AccessFormUserPK(module, user, form, control, codeMenu);
    }

    public AccessFormUserPK getAccessFormUserPK() {
        return accessFormUserPK;
    }

    public void setAccessFormUserPK(AccessFormUserPK accessFormUserPK) {
        this.accessFormUserPK = accessFormUserPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public Form getForm() {
        return form1;
    }

    public void setForm(Form form1) {
        this.form1 = form1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessFormUserPK != null ? accessFormUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessFormUser)) {
            return false;
        }
        AccessFormUser other = (AccessFormUser) object;
        if ((this.accessFormUserPK == null && other.accessFormUserPK != null) || (this.accessFormUserPK != null && !this.accessFormUserPK.equals(other.accessFormUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessFormUser[ accessFormUserPK=" + accessFormUserPK + " ]";
    }
    
}
