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
public class MenuPPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Module", nullable = false, length = 3)
    private String module;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CodMnp", nullable = false, length = 15)
    private String codMnp;

    public MenuPPK() {
    }

    public MenuPPK(String module, String codMnp) {
        this.module = module;
        this.codMnp = codMnp;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCodMnp() {
        return codMnp;
    }

    public void setCodMnp(String codMnp) {
        this.codMnp = codMnp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (module != null ? module.hashCode() : 0);
        hash += (codMnp != null ? codMnp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPPK)) {
            return false;
        }
        MenuPPK other = (MenuPPK) object;
        if ((this.module == null && other.module != null) || (this.module != null && !this.module.equals(other.module))) {
            return false;
        }
        if ((this.codMnp == null && other.codMnp != null) || (this.codMnp != null && !this.codMnp.equals(other.codMnp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.MenuPPK[ module=" + module + ", codMnp=" + codMnp + " ]";
    }
    
}
