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
public class AccessMenuUserDTO {
    
    @Size(min = 1, max = 3)
    private String module;
    @Size(min = 1, max = 20)
    private String user;
    @Size(min = 1, max = 15)
    private String menu;
    private boolean visible;
    private boolean personalise;
    private AccessControlDTO accessControl;
    private MenuPDTO menuP;

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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isPersonalise() {
        return personalise;
    }

    public void setPersonalise(boolean personalise) {
        this.personalise = personalise;
    }

    public AccessControlDTO getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControlDTO accessControl) {
        this.accessControl = accessControl;
    }

    public MenuPDTO getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuPDTO menuP) {
        this.menuP = menuP;
    }
    
    

}
