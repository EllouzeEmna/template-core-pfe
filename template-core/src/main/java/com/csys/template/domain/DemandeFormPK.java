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
public class DemandeFormPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "code_form", nullable = false, length = 250)
    private String codeForm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "code_module", nullable = false, length = 3)
    private String codeModule;
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
    @Size(min = 1, max = 50)
    @Column(name = "code_control", nullable = false, length = 50)
    private String codeControl;

    public DemandeFormPK() {
    }

    public DemandeFormPK(String codeForm, String codeModule, String codeMenu, String codeDemande, String codeControl) {
        this.codeForm = codeForm;
        this.codeModule = codeModule;
        this.codeMenu = codeMenu;
        this.codeDemande = codeDemande;
        this.codeControl = codeControl;
    }

    public String getCodeForm() {
        return codeForm;
    }

    public void setCodeForm(String codeForm) {
        this.codeForm = codeForm;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
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

    public String getCodeControl() {
        return codeControl;
    }

    public void setCodeControl(String codeControl) {
        this.codeControl = codeControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeForm != null ? codeForm.hashCode() : 0);
        hash += (codeModule != null ? codeModule.hashCode() : 0);
        hash += (codeMenu != null ? codeMenu.hashCode() : 0);
        hash += (codeDemande != null ? codeDemande.hashCode() : 0);
        hash += (codeControl != null ? codeControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeFormPK)) {
            return false;
        }
        DemandeFormPK other = (DemandeFormPK) object;
        if ((this.codeForm == null && other.codeForm != null) || (this.codeForm != null && !this.codeForm.equals(other.codeForm))) {
            return false;
        }
        if ((this.codeModule == null && other.codeModule != null) || (this.codeModule != null && !this.codeModule.equals(other.codeModule))) {
            return false;
        }
        if ((this.codeMenu == null && other.codeMenu != null) || (this.codeMenu != null && !this.codeMenu.equals(other.codeMenu))) {
            return false;
        }
        if ((this.codeDemande == null && other.codeDemande != null) || (this.codeDemande != null && !this.codeDemande.equals(other.codeDemande))) {
            return false;
        }
        if ((this.codeControl == null && other.codeControl != null) || (this.codeControl != null && !this.codeControl.equals(other.codeControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeFormPK[ codeForm=" + codeForm + ", codeModule=" + codeModule + ", codeMenu=" + codeMenu + ", codeDemande=" + codeDemande + ", codeControl=" + codeControl + " ]";
    }
    
}
