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
public class FormDTO {
    
    @NotNull
    @Size(min = 1, max = 3)
    private String module;
    @NotNull
    @Size(min = 1, max = 250)
    private String form;
    @NotNull
    @Size(min = 1, max = 50)
    private String control;
    @NotNull
    @Size(min = 1, max = 15)
    private String codeMenu;
    @NotNull
    @Size(min = 1, max = 200)
    private String nomForm;
    @NotNull
    @Size(min = 1, max = 100)
    private String nomControl;
    @Size(max = 200)
    private String parentForm;
    @Size(max = 200)
    private String parentControl;
    @Size(max = 255)
    private String logo;
    @Size(max = 1)
    private String orderButton;
    private Collection<AccessFormUserDTO> accessFormUserCollection;
    private Collection<AccessFormDTO> accessFormCollection;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
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

    public Collection<AccessFormUserDTO> getAccessFormUserCollection() {
        return accessFormUserCollection;
    }

    public void setAccessFormUserCollection(Collection<AccessFormUserDTO> accessFormUserCollection) {
        this.accessFormUserCollection = accessFormUserCollection;
    }

    public Collection<AccessFormDTO> getAccessFormCollection() {
        return accessFormCollection;
    }

    public void setAccessFormCollection(Collection<AccessFormDTO> accessFormCollection) {
        this.accessFormCollection = accessFormCollection;
    }
    
    

}
