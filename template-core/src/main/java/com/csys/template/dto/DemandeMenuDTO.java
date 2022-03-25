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
public class DemandeMenuDTO {

    @NotNull
    @Size(min = 1, max = 15)
    private String codeMenu;
    @NotNull
    @Size(min = 1, max = 20)
    private String codeDemande;
    @NotNull
    @Size(min = 1, max = 3)
    private String codeModule;
    @Size(max = 50)
    private String valider;
    private MenuPDTO menuP;

    public String getCodeMenu() {
        return codeMenu;
    }

    public void setCodeMenu(String codeMenu) {
        this.codeMenu = codeMenu;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public MenuPDTO getMenuP() {
        return menuP;
    }

    public void setMenuP(MenuPDTO menuP) {
        this.menuP = menuP;
    }

}
