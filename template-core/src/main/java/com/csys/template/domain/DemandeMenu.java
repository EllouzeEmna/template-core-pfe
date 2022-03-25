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
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "demande_menu")
@NamedQueries({
    @NamedQuery(name = "DemandeMenu.findAll", query = "SELECT d FROM DemandeMenu d")})
public class DemandeMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DemandeMenuPK demandeMenuPK;
    @Size(max = 50)
    @Column(name = "valider", length = 50)
    private String valider;
    @JoinColumn(name = "code_demande", referencedColumnName = "code_demande", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Demande demande;
    @JoinColumns({
        @JoinColumn(name = "code_module", referencedColumnName = "Module", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "code_menu", referencedColumnName = "CodMnp", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MenuP menuP;

    public DemandeMenu() {
    }

    public DemandeMenu(DemandeMenuPK demandeMenuPK) {
        this.demandeMenuPK = demandeMenuPK;
    }

    public DemandeMenu(String codeMenu, String codeDemande, String codeModule) {
        this.demandeMenuPK = new DemandeMenuPK(codeMenu, codeDemande, codeModule);
    }

    public DemandeMenuPK getDemandeMenuPK() {
        return demandeMenuPK;
    }

    public void setDemandeMenuPK(DemandeMenuPK demandeMenuPK) {
        this.demandeMenuPK = demandeMenuPK;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public MenuP getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuP menuP) {
        this.menuP = menuP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demandeMenuPK != null ? demandeMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeMenu)) {
            return false;
        }
        DemandeMenu other = (DemandeMenu) object;
        if ((this.demandeMenuPK == null && other.demandeMenuPK != null) || (this.demandeMenuPK != null && !this.demandeMenuPK.equals(other.demandeMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeMenu[ demandeMenuPK=" + demandeMenuPK + " ]";
    }
    
}
