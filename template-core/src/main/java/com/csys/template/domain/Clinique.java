/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Clinique")
@NamedQueries({
    @NamedQuery(name = "Clinique.findAll", query = "SELECT c FROM Clinique c")})
public class Clinique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code_clinique", nullable = false, length = 50)
    private String codeClinique;
    @Size(max = 255)
    @Column(name = "adresse_clinique", length = 255)
    private String adresseClinique;
    @Size(max = 50)
    @Column(name = "nom_clinique", length = 50)
    private String nomClinique;
    @OneToMany(mappedBy = "clinique")
    private List<AccessControl> accessControlList;

    public Clinique() {
    }

    public Clinique(String codeClinique) {
        this.codeClinique = codeClinique;
    }

    public String getCodeClinique() {
        return codeClinique;
    }

    public void setCodeClinique(String codeClinique) {
        this.codeClinique = codeClinique;
    }

    public String getAdresseClinique() {
        return adresseClinique;
    }

    public void setAdresseClinique(String adresseClinique) {
        this.adresseClinique = adresseClinique;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public List<AccessControl> getAccessControlList() {
        return accessControlList;
    }

    public void setAccessControlList(List<AccessControl> accessControlList) {
        this.accessControlList = accessControlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeClinique != null ? codeClinique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinique)) {
            return false;
        }
        Clinique other = (Clinique) object;
        if ((this.codeClinique == null && other.codeClinique != null) || (this.codeClinique != null && !this.codeClinique.equals(other.codeClinique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.Clinique[ codeClinique=" + codeClinique + " ]";
    }
    
}
