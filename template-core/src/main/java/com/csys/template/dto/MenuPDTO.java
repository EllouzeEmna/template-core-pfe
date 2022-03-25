/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class MenuPDTO {
    @NotNull
    @Size(min = 1, max = 3)
    private String module;
    @NotNull
    @Size(min = 1, max = 15)
    private String codMnp;
    @NotNull
    @Size(min = 1, max = 500)
    private String desMenuP;
    @NotNull
    @Size(min = 1, max = 500)
    private String mnName;
    private Integer order;
    @Size(max = 255)
    private String logo;
    @Size(max = 15)
    private String codemenu;
    private Collection<AccessMenuDTO> accessMenuCollection;
    private Collection<AccessMenuUserDTO> accessMenuUserCollection;

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

    public Collection<AccessMenuDTO> getAccessMenuCollection() {
        return accessMenuCollection;
    }

    public void setAccessMenuCollection(Collection<AccessMenuDTO> accessMenuCollection) {
        this.accessMenuCollection = accessMenuCollection;
    }

    public Collection<AccessMenuUserDTO> getAccessMenuUserCollection() {
        return accessMenuUserCollection;
    }

    public void setAccessMenuUserCollection(Collection<AccessMenuUserDTO> accessMenuUserCollection) {
        this.accessMenuUserCollection = accessMenuUserCollection;
    }
    
    
}
