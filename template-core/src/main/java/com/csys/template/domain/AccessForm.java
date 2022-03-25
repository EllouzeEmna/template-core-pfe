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
@Table(name = "ACCESS_FORM")
@NamedQueries({
    @NamedQuery(name = "AccessForm.findAll", query = "SELECT a FROM AccessForm a")})
public class AccessForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessFormPK accessFormPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Visible", nullable = false)
    private boolean visible;
    @JoinColumns({
        @JoinColumn(name = "Module", referencedColumnName = "Module", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Form", referencedColumnName = "Form", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "Control", referencedColumnName = "Control", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_menu", referencedColumnName = "code_menu", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Form form1;
    @JoinColumn(name = "Grp", referencedColumnName = "Grp", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GroupUser groupUser;

    public AccessForm() {
    }

    public AccessForm(AccessFormPK accessFormPK) {
        this.accessFormPK = accessFormPK;
    }

    public AccessForm(AccessFormPK accessFormPK, boolean visible) {
        this.accessFormPK = accessFormPK;
        this.visible = visible;
    }

    public AccessForm(String module, String grp, String form, String control, String codeMenu) {
        this.accessFormPK = new AccessFormPK(module, grp, form, control, codeMenu);
    }

    public AccessFormPK getAccessFormPK() {
        return accessFormPK;
    }

    public void setAccessFormPK(AccessFormPK accessFormPK) {
        this.accessFormPK = accessFormPK;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Form getForm() {
        return form1;
    }

    public void setForm(Form form1) {
        this.form1 = form1;
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
        hash += (accessFormPK != null ? accessFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessForm)) {
            return false;
        }
        AccessForm other = (AccessForm) object;
        if ((this.accessFormPK == null && other.accessFormPK != null) || (this.accessFormPK != null && !this.accessFormPK.equals(other.accessFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessForm[ accessFormPK=" + accessFormPK + " ]";
    }
    
}
