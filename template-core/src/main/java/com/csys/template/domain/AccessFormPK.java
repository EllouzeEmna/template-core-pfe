/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Embeddable
public class AccessFormPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Module", nullable = false, length = 3)
    private String module;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Grp", nullable = false, length = 10)
    private String grp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Form", nullable = false, length = 250)
    private String form;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Control", nullable = false, length = 50)
    private String control;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "code_menu", nullable = false, length = 15)
    private String codeMenu;

    public AccessFormPK() {
    }

    public AccessFormPK(String module, String grp, String form, String control, String codeMenu) {
        this.module = module;
        this.grp = grp;
        this.form = form;
        this.control = control;
        this.codeMenu = codeMenu;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (module != null ? module.hashCode() : 0);
        hash += (grp != null ? grp.hashCode() : 0);
        hash += (form != null ? form.hashCode() : 0);
        hash += (control != null ? control.hashCode() : 0);
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessFormPK)) {
            return false;
        }
        AccessFormPK other = (AccessFormPK) object;
        if ((this.module == null && other.module != null) || (this.module != null && !this.module.equals(other.module))) {
            return false;
        }
        if ((this.grp == null && other.grp != null) || (this.grp != null && !this.grp.equals(other.grp))) {
            return false;
        }
        if ((this.form == null && other.form != null) || (this.form != null && !this.form.equals(other.form))) {
            return false;
        }
        if ((this.control == null && other.control != null) || (this.control != null && !this.control.equals(other.control))) {
            return false;
        }
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessFormPK[ module=" + module + ", grp=" + grp + ", form=" + form + ", control=" + control + ", codeMenu=" + codeMenu + " ]";
    }
    
}
