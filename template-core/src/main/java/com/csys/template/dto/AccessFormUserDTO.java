/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 21694
 */
public class AccessFormUserDTO {
    
    @Size(min = 1, max = 3)
    private String module;
    
    @Size(min = 1, max = 20)
    private String user;
    @Size(min = 1, max = 250)
    private String form;
    @Size(min = 1, max = 50)
    private String control;
    
    @Size(min = 1, max = 15)
    private String codeMenu;
    private boolean visible;
    private AccessControlDTO accessControl;
    private FormDTO formDTO;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public AccessControlDTO getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControlDTO accessControl) {
        this.accessControl = accessControl;
    }

    public FormDTO getFormDTO() {
        return formDTO;
    }

    public void setFormDTO(FormDTO form1) {
        this.formDTO = form1;
    }
    
    
}
