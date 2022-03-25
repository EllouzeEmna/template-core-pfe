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
public class DemandeModulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "num_module", nullable = false, length = 3)
    private String numModule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_demande", nullable = false, length = 20)
    private String codeDemande;

    public DemandeModulePK() {
    }

    public DemandeModulePK(String numModule, String codeDemande) {
        this.numModule = numModule;
        this.codeDemande = codeDemande;
    }

    public String getNumModule() {
        return numModule;
    }

    public void setNumModule(String numModule) {
        this.numModule = numModule;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numModule != null ? numModule.hashCode() : 0);
        hash += (codeDemande != null ? codeDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeModulePK)) {
            return false;
        }
        DemandeModulePK other = (DemandeModulePK) object;
        if ((this.numModule == null && other.numModule != null) || (this.numModule != null && !this.numModule.equals(other.numModule))) {
            return false;
        }
        if ((this.codeDemande == null && other.codeDemande != null) || (this.codeDemande != null && !this.codeDemande.equals(other.codeDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeModulePK[ numModule=" + numModule + ", codeDemande=" + codeDemande + " ]";
    }
    
}
