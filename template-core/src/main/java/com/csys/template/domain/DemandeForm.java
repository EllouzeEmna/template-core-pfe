/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "demande_form", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code_form"})})
@NamedQueries({
    @NamedQuery(name = "DemandeForm.findAll", query = "SELECT d FROM DemandeForm d")})
public class DemandeForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DemandeFormPK demandeFormPK;
    @Column(name = "valider")
    private Boolean valider;
    @JoinColumn(name = "code_demande", referencedColumnName = "code_demande", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Demande demande;
    @JoinColumns({
        @JoinColumn(name = "code_module", referencedColumnName = "Module", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_form", referencedColumnName = "Form", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_control", referencedColumnName = "Control", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_menu", referencedColumnName = "code_menu", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Form form;

    public DemandeForm() {
    }

    public DemandeForm(DemandeFormPK demandeFormPK) {
        this.demandeFormPK = demandeFormPK;
    }

    public DemandeForm(String codeForm, String codeModule, String codeMenu, String codeDemande, String codeControl) {
        this.demandeFormPK = new DemandeFormPK(codeForm, codeModule, codeMenu, codeDemande, codeControl);
    }

    public DemandeFormPK getDemandeFormPK() {
        return demandeFormPK;
    }

    public void setDemandeFormPK(DemandeFormPK demandeFormPK) {
        this.demandeFormPK = demandeFormPK;
    }

    public Boolean getValider() {
        return valider;
    }

    public void setValider(Boolean valider) {
        this.valider = valider;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demandeFormPK != null ? demandeFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeForm)) {
            return false;
        }
        DemandeForm other = (DemandeForm) object;
        if ((this.demandeFormPK == null && other.demandeFormPK != null) || (this.demandeFormPK != null && !this.demandeFormPK.equals(other.demandeFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeForm[ demandeFormPK=" + demandeFormPK + " ]";
    }
    
}
