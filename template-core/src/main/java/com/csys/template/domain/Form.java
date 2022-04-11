/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
@Entity
@Table(name = "Form")
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f")})
public class Form implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private List<DemandeForm> demandeFormList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FormPK formPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NomForm", nullable = false, length = 200)
    private String nomForm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomControl", nullable = false, length = 100)
    private String nomControl;
    @Size(max = 200)
    @Column(name = "ParentForm", length = 200)
    private String parentForm;
    @Size(max = 200)
    @Column(name = "ParentControl", length = 200)
    private String parentControl;
    @Size(max = 255)
    @Column(name = "logo", length = 255)
    private String logo;
    @Size(max = 1)
    @Column(name = "order_button", length = 1)
    private String orderButton;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form1")
    private Collection<AccessFormUser> accessFormUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form1")
    private Collection<AccessForm> accessFormCollection;
//    @ManyToOne
//    DemandeModule demandeModule;
    
    
    public Form() {
    }

    public Form(FormPK formPK) {
        this.formPK = formPK;
    }

    public Form(FormPK formPK, String nomForm, String nomControl) {
        this.formPK = formPK;
        this.nomForm = nomForm;
        this.nomControl = nomControl;
    }

    public Form(String module, String form, String control, String codeMenu) {
        this.formPK = new FormPK(module, form, control, codeMenu);
    }

    public FormPK getFormPK() {
        return formPK;
    }

    public void setFormPK(FormPK formPK) {
        this.formPK = formPK;
    }

    public String getNomForm() {
        return nomForm;
    }

    public void setNomForm(String nomForm) {
        this.nomForm = nomForm;
    }

    public String getNomControl() {
        return nomControl;
    }

    public void setNomControl(String nomControl) {
        this.nomControl = nomControl;
    }

    public String getParentForm() {
        return parentForm;
    }

    public void setParentForm(String parentForm) {
        this.parentForm = parentForm;
    }

    public String getParentControl() {
        return parentControl;
    }

    public void setParentControl(String parentControl) {
        this.parentControl = parentControl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOrderButton() {
        return orderButton;
    }

    public void setOrderButton(String orderButton) {
        this.orderButton = orderButton;
    }

    public Collection<AccessFormUser> getAccessFormUserCollection() {
        return accessFormUserCollection;
    }

    public void setAccessFormUserCollection(Collection<AccessFormUser> accessFormUserCollection) {
        this.accessFormUserCollection = accessFormUserCollection;
    }

    public Collection<AccessForm> getAccessFormCollection() {
        return accessFormCollection;
    }

    public void setAccessFormCollection(Collection<AccessForm> accessFormCollection) {
        this.accessFormCollection = accessFormCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formPK != null ? formPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.formPK == null && other.formPK != null) || (this.formPK != null && !this.formPK.equals(other.formPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.Form[ formPK=" + formPK + " ]";
    }

    public List<DemandeForm> getDemandeFormList() {
        return demandeFormList;
    }

    public void setDemandeFormList(List<DemandeForm> demandeFormList) {
        this.demandeFormList = demandeFormList;
    }
    
}
