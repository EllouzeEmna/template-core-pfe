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
public class AccessMenuUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Module", nullable = false, length = 3)
    private String module;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "[User]", nullable = false, length = 20)
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MENU", nullable = false, length = 15)
    private String menu;

    public AccessMenuUserPK() {
    }

    public AccessMenuUserPK(String module, String user, String menu) {
        this.module = module;
        this.user = user;
        this.menu = menu;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (module != null ? module.hashCode() : 0);
        hash += (user != null ? user.hashCode() : 0);
        hash += (menu != null ? menu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessMenuUserPK)) {
            return false;
        }
        AccessMenuUserPK other = (AccessMenuUserPK) object;
        if ((this.module == null && other.module != null) || (this.module != null && !this.module.equals(other.module))) {
            return false;
        }
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        if ((this.menu == null && other.menu != null) || (this.menu != null && !this.menu.equals(other.menu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.AccessMenuUserPK[ module=" + module + ", user=" + user + ", menu=" + menu + " ]";
    }
    
}
