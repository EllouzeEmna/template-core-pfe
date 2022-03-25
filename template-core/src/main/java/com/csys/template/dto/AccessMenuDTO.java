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
public class AccessMenuDTO {
    
    @NotNull
    @Size(min = 1, max = 3)
    private String module;
    @NotNull
    @Size(min = 1, max = 10)
    private String grp;
    @NotNull
    @Size(min = 1, max = 15)
    private String menu;
    @NotNull
    private boolean visible;
    private GroupUserDTO groupUser;
    private MenuPDTO menuP;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
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

    public GroupUserDTO getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupUserDTO groupUser) {
        this.groupUser = groupUser;
    }

    public MenuPDTO getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuPDTO menuP) {
        this.menuP = menuP;
    }
    
    
}
