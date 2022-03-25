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
public class DemandeMenuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "code_menu", nullable = false, length = 15)
    private String codeMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_demande", nullable = false, length = 20)
    private String codeDemande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "code_module", nullable = false, length = 3)
    private String codeModule;

    public DemandeMenuPK() {
    }

    public DemandeMenuPK(String codeMenu, String codeDemande, String codeModule) {
        this.codeMenu = codeMenu;
        this.codeDemande = codeDemande;
        this.codeModule = codeModule;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        hash += (codeDemande != null ? codeDemande.hashCode() : 0);
        hash += (codeModule != null ? codeModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeMenuPK)) {
            return false;
        }
        DemandeMenuPK other = (DemandeMenuPK) object;
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        if ((this.codeDemande == null && other.codeDemande != null) || (this.codeDemande != null && !this.codeDemande.equals(other.codeDemande))) {
            return false;
        }
        if ((this.codeModule == null && other.codeModule != null) || (this.codeModule != null && !this.codeModule.equals(other.codeModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeMenuPK[ codeMenu=" + codeMenu + ", codeDemande=" + codeDemande + ", codeModule=" + codeModule + " ]";
    }
    
}
