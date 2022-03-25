/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "demande_module")
@NamedQueries({
    @NamedQuery(name = "DemandeModule.findAll", query = "SELECT d FROM DemandeModule d")})
public class DemandeModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DemandeModulePK demandeModulePK;
    @Size(max = 50)
    @Column(name = "valider", length = 50)
    private String valider;
    @JoinColumn(name = "code_demande", referencedColumnName = "code_demande", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Demande demande;
    @JoinColumn(name = "num_module", referencedColumnName = "NumModule", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Module module;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeModule")
    private Collection<MenuP> listMenu=new ArrayList<MenuP>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeModule")
    private Collection<Form> listForm=new ArrayList<Form>();

    public Collection<MenuP> getListMenu() {
        return listMenu;
    }

    public void setListMenu(Collection<MenuP> listMenu) {
        this.listMenu = listMenu;
    }

    public Collection<Form> getListForm() {
        return listForm;
    }

    public void setListForm(Collection<Form> listForm) {
        this.listForm = listForm;
    }
    
    public DemandeModule() {
    }

    public DemandeModule(DemandeModulePK demandeModulePK) {
        this.demandeModulePK = demandeModulePK;
    }

    public DemandeModule(String numModule, String codeDemande) {
        this.demandeModulePK = new DemandeModulePK(numModule, codeDemande);
    }

    public DemandeModulePK getDemandeModulePK() {
        return demandeModulePK;
    }

    public void setDemandeModulePK(DemandeModulePK demandeModulePK) {
        this.demandeModulePK = demandeModulePK;
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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demandeModulePK != null ? demandeModulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeModule)) {
            return false;
        }
        DemandeModule other = (DemandeModule) object;
        if ((this.demandeModulePK == null && other.demandeModulePK != null) || (this.demandeModulePK != null && !this.demandeModulePK.equals(other.demandeModulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.DemandeModule[ demandeModulePK=" + demandeModulePK + " ]";
    }
    
}
