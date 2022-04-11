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
@Table(name = "MenuP")
@NamedQueries({
    @NamedQuery(name = "MenuP.findAll", query = "SELECT m FROM MenuP m")})
public class MenuP implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuP")
    private List<DemandeMenu> demandeMenuList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuPPK menuPPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DesMenuP", nullable = false, length = 500)
    private String desMenuP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MnName", nullable = false, length = 500)
    private String mnName;
    @Column(name = "[order]")
    private Integer order;
    @Size(max = 255)
    @Column(name = "logo", length = 255)
    private String logo;
    @Size(max = 15)
    @Column(name = "Code_menu", length = 15)
    private String codemenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuP")
    private Collection<AccessMenu> accessMenuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuP")
    private Collection<AccessMenuUser> accessMenuUserCollection;
   
    
    public Collection<AccessMenu> getAccessMenuCollection() {
        return accessMenuCollection;
    }

    public void setAccessMenuCollection(Collection<AccessMenu> accessMenuCollection) {
        this.accessMenuCollection = accessMenuCollection;
    }

    public Collection<AccessMenuUser> getAccessMenuUserCollection() {
        return accessMenuUserCollection;
    }

    public void setAccessMenuUserCollection(Collection<AccessMenuUser> accessMenuUserCollection) {
        this.accessMenuUserCollection = accessMenuUserCollection;
    }
    
    public MenuP() {
    }

    public MenuP(MenuPPK menuPPK) {
        this.menuPPK = menuPPK;
    }

    public MenuP(MenuPPK menuPPK, String desMenuP, String mnName) {
        this.menuPPK = menuPPK;
        this.desMenuP = desMenuP;
        this.mnName = mnName;
    }

    public MenuP(String module, String codMnp) {
        this.menuPPK = new MenuPPK(module, codMnp);
    }

    public MenuPPK getMenuPPK() {
        return menuPPK;
    }

    public void setMenuPPK(MenuPPK menuPPK) {
        this.menuPPK = menuPPK;
    }

    public String getDesMenuP() {
        return desMenuP;
    }

    public void setDesMenuP(String desMenuP) {
        this.desMenuP = desMenuP;
    }

    public String getMnName() {
        return mnName;
    }

    public void setMnName(String mnName) {
        this.mnName = mnName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCodemenu() {
        return codemenu;
    }

    public void setCodemenu(String codemenu) {
        this.codemenu = codemenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuPPK != null ? menuPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuP)) {
            return false;
        }
        MenuP other = (MenuP) object;
        if ((this.menuPPK == null && other.menuPPK != null) || (this.menuPPK != null && !this.menuPPK.equals(other.menuPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.template.domain.MenuP[ menuPPK=" + menuPPK + " ]";
    }

    public List<DemandeMenu> getDemandeMenuList() {
        return demandeMenuList;
    }

    public void setDemandeMenuList(List<DemandeMenu> demandeMenuList) {
        this.demandeMenuList = demandeMenuList;
    }
    
}
